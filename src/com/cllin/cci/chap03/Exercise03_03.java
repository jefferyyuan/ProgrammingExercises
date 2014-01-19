package com.cllin.cci.chap03;

import java.util.ArrayList;
import java.util.Stack;

import com.cllin.main.Exercise;

public class Exercise03_03 implements Exercise {
	private final int SIZE = SetOfStacks.THRESHOLD_OF_STACK * 10 + 2;
	
	private SetOfStacks set;
	private Stack<Plate> reference;
	
	@Override
	public void runExercise() {
		initialize();
		test();
	}
	
	private void test(){
		while(!set.isEmpty() && !reference.isEmpty()){
			if(set.pop().hashCode() != reference.pop().hashCode()){
				System.out.println("Failed");
				return;
			}
		}
		
//		Testing popAtIndex()
		int[] testSuite = {1, 3, 5, 6, 8, 9, 10};
		for(int index : testSuite){
			initialize();
			int num = SIZE - (index + 1) * SetOfStacks.THRESHOLD_OF_STACK;
			for(int i = 0; i < num; i++ ){
				reference.pop();
			}
			
			int hashFromSet = set.popAtIndex(index).hashCode();
			int hashFromReference = reference.pop().hashCode();
			if(hashFromReference != hashFromSet){
				System.out.println("Failed");
				return;
			}
		}
		
		System.out.println("Success!");
	}
	
	private void initialize(){
		set = new SetOfStacks();
		reference = new Stack<Plate>();
		for(int i = 0; i < SIZE; i++){
			Plate plate = new Plate();
			set.push(plate);
			reference.push(plate);
		}
	}
	
	private class SetOfStacks {
		private static final int THRESHOLD_OF_STACK = 5;
		private ArrayList<Stack<Plate>> list;
		
		public SetOfStacks(){
			list = new ArrayList<Stack<Plate>>();
			list.add(new Stack<Plate>());
		}
		
		public void push(Plate plate){
			int size = list.size();
			for(int i = 0; i < size; i++){
				if(list.get(i).size() < THRESHOLD_OF_STACK){
					list.get(i).push(plate);
					return;
				}
			}
			list.add(new Stack<Plate>());
			list.get(size).add(plate);
		}
		
		public Plate pop(){
			int size = list.size();
			for(int i = size - 1; i > -1; i--){
				if(!list.get(i).isEmpty()){
					return list.get(i).pop();
				}else{
					list.remove(i);
				}
			}
			return null;
		}
		
		public Plate popAtIndex(int i){
			int size = list.size();
			Plate plate = list.get(i).pop();
			Stack<Plate> buf = new Stack<Plate>();
			
			for(int j = i + 1; j < size; j++){
				if(list.get(j).isEmpty()){
					list.remove(j);
					break;
				}
				
				while(!list.get(j).isEmpty()){
					buf.push(list.get(j).pop());
				}
				list.get(j - 1).push(buf.pop());
				
				while(!buf.isEmpty()){
					list.get(j).push(buf.pop());
				}
			}
			
			return plate;
		}
		
		public boolean isEmpty(){
			int size = list.size();
			for(int i = 0; i < size; i++){
				if(!list.get(i).isEmpty()){
					return false;
				}
			}
			return true;
		}
	}
	
	private class Plate {
	}

}
