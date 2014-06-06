package com.cllin.cci.chap08;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Write a method that returns all subsets of a set.
 */

public class Exercise08_03 implements Exercise {
	private final int[] testSuite = new int[]{3, 5, 6, 7};
	private ArrayList<Integer> set;
	
	
	@Override
	public void runExercise() {
		for (int n : testSuite) {
			initialize(n);
			ArrayList<ArrayList<Integer>> subsets = getSubset(set);
			
			printSet(set, subsets);
		}
	}
	
	private static ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set) {
		return getSubsetHelper(set, 0);
	}
	
	private static ArrayList<ArrayList<Integer>> getSubsetHelper(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		
		if (set.size() == index) {
			subsets.add(new ArrayList<Integer>());
		} else {
			subsets = getSubsetHelper(set, index + 1);
			int element = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			
			for (ArrayList<Integer> sets : subsets) {
				ArrayList<Integer> newSet = new ArrayList<Integer>();
				newSet.add(element);
				newSet.addAll(sets);
				moreSubsets.add(newSet);
			}
			
			subsets.addAll(moreSubsets);
		}
		
		return subsets;
	}
	
	private static void printSet(ArrayList<Integer> set, ArrayList<ArrayList<Integer>> subsets) {
		System.out.println("This set has " + subsets.size() + " subsets");
		
		System.out.printf("S = { ");
		for (int n : set) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		for (ArrayList<Integer> subset : subsets) {
			System.out.printf("    { ");
			
			for (int n : subset) {
				System.out.printf("%d ", n);
			}
			System.out.printf("}%n");
		}
		System.out.println("------------------------------");
	}
	
	private void initialize(int size) {
		set = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			set.add(i);
		}
	}
}
