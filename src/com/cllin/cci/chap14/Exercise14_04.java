package com.cllin.cci.chap14;

import java.util.ArrayList;
import java.util.List;

import com.cllin.main.Exercise;

public class Exercise14_04 implements Exercise {
	ArrayList<Integer> myIntegerList;
	ArrayList<String> myStringList;
	ArrayList<Float> myFloatList;

	@Override
	public void runExercise() {
		
		System.out.println("--------");
		System.out.println("WILDCARD");
		System.out.println("--------");
		
		myIntegerList = new ArrayList<Integer>();
		myStringList = new ArrayList<String>();
		myFloatList = new ArrayList<Float>();

		for(int i = 0; i < 3; i++){
			myIntegerList.add(i);
			myStringList.add(toEnglish(i));
			myFloatList.add((float)i);
		}

		printList(myIntegerList);
		printList(myStringList);
		printList(myFloatList);
		
		System.out.println("--------");
		System.out.println("GENERICS");
		System.out.println("--------");
		
		Box<Integer> myIntegerBox = new Box<>();
		Box<String> myStringBox = new Box<>();
		Box<Float> myFloatBox = new Box<>();
		
		int content = 1;
		myIntegerBox.set(content);
		myStringBox.set(toEnglish(content));
		myFloatBox.set((float)content);
		
		myIntegerBox.print();
		myStringBox.print();
		myFloatBox.print();
	}
	
//	WILDCARD
	private void printList(List<?> list){
		System.out.println("Content Class Type: " + list.get(0).getClass().toString());
		for(Object o : list){
			System.out.println("\t" + o.toString());
		}
	}
	
//	GENERIC
	private class Box<T>{
		private T content;
		
		public void set(T content){
			this.content = content;
		}
		
		public void print(){
			System.out.println("Content Class Type: " + content.getClass().toString());
			System.out.println("\t" + content.toString());
		}
	}

	private String toEnglish(int i){
		switch(i){
		case 0:
			return "zero";
		case 1:
			return "one";
		case 2:
			return "two";
		case 3:
			return "three";
			default:
				return "default";
		}

	}
}
