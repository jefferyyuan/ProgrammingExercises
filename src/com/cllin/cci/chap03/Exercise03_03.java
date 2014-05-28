package com.cllin.cci.chap03;

import java.util.ArrayList;
import java.util.Stack;

import com.cllin.main.Exercise;

/*
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
 * Therefore, in real life, we would likely start a new stack when the previous stack exceeds some threshold.
 * 
 * Implement a data structure SetOfStacks that mimics this.
 * 
 * SetOfStacks should be composed of several stacks, and should create a new stack once the previous one exceeds capacity.
 * SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack. 
 * That is, pop() should return the same values as it would if there were just a single stack.
 * 
 * FOLLOW UP:
 * Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * 
 */

public class Exercise03_03 implements Exercise {
	private final int SIZE = SetOfStacks.THRESHOLD_OF_STACK * 10 + 2;
	private final int[] testSuite = {1, 3, 5, 6, 8, 9, 10};
	
	private SetOfStacks set;
	private Stack<Plate> reference;
	
	@Override
	public void runExercise() {
		test();
	}
	
	private class SetOfStacks {
		private static final int THRESHOLD_OF_STACK = 5;
		private ArrayList<Stack<Plate>> list;
		
		public SetOfStacks() {
			list = new ArrayList<Stack<Plate>>();
			list.add(new Stack<Plate>());
		}
		
		public void push(Plate plate) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).size() < THRESHOLD_OF_STACK) {
					list.get(i).push(plate);
					return;
				}
			}
			
			Stack<Plate> newStack = new Stack<Plate>();
			newStack.add(plate);
			list.add(newStack);
		}
		
		public Plate pop() {
			for (int i = list.size() - 1; i >= 0; i--) {
				if (!list.get(i).isEmpty()) {
					return list.get(i).pop();
				} else {
					list.remove(i);
				}
			}
			return null;
		}
		
		public Plate popAtIndex(int i) {
			Plate plate = list.get(i).pop();
			Stack<Plate> buf = new Stack<Plate>();
			
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(j).isEmpty()) {
					list.remove(j);
					break;
				}
				
				while (!list.get(j).isEmpty()) {
					buf.push(list.get(j).pop());
				}
				
				list.get(j - 1).push(buf.pop());
				while (!buf.isEmpty()) {
					list.get(j).push(buf.pop());
				}
			}
			
			return plate;
		}
		
		public boolean isEmpty() {
			for (int i = 0; i < list.size(); i++) {
				if (!list.get(i).isEmpty()) {
					return false;
				}
			}
			return true;
		}
	}
	
	private class Plate {
		Plate() {}
	}
	
	private void test() {
		
//		Testing pop()
		initialize();
		while (!set.isEmpty() && !reference.isEmpty()) {
			if (set.pop().hashCode() != reference.pop().hashCode()) {
				System.out.println("Failed");
				return;
			}
		}
		
		for (int index : testSuite) {
			initialize();
			int num = SIZE - (index + 1) * SetOfStacks.THRESHOLD_OF_STACK;
			for (int i = 0; i < num; i++ ) {
				reference.pop();
			}
			
			int hashFromSet = set.popAtIndex(index).hashCode();
			int hashFromReference = reference.pop().hashCode();
			if (hashFromReference != hashFromSet) {
				System.out.println("Failed");
				return;
			}
		}
		
		System.out.println("Success!");
	}
	
	private void initialize() {
		set = new SetOfStacks();
		reference = new Stack<Plate>();
		for (int i = 0; i < SIZE; i++) {
			Plate plate = new Plate();
			set.push(plate);
			reference.push(plate);
		}
	}
}
