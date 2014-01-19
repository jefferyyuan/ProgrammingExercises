package com.cllin.cci.chap08;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class Exercise08_03 implements Exercise {
	private final int MAXIMUM = 100;
	private ArrayList<Integer> set;
	
	
	@Override
	public void runExercise() {
		ArrayList<ArrayList<Integer>> subsets;
		
		initialize(3);
		subsets = getSubset(set, 0);
		printSize(subsets);
		
		initialize(5);
		subsets = getSubset(set, 0);
		printSize(subsets);
		
		initialize(7);
		subsets = getSubset(set, 0);
		printSize(subsets);
	}
	
	private ArrayList<ArrayList<Integer>> getSubset(ArrayList<Integer> set, int index){
		ArrayList<ArrayList<Integer>> subsets = new ArrayList<ArrayList<Integer>>();
		
		if(set.size() == index){
			subsets.add(new ArrayList<Integer>());
		}else{
			subsets = getSubset(set, index + 1);
			int element = set.get(index);
			ArrayList<ArrayList<Integer>> moreSubsets = new ArrayList<ArrayList<Integer>>();
			
			for(ArrayList<Integer> sets : subsets){
				ArrayList<Integer> newSet = new ArrayList<Integer>();
				newSet.addAll(sets);
				newSet.add(element);
				moreSubsets.add(newSet);
			}
			
			subsets.addAll(moreSubsets);
		}
		
		return subsets;
	}
	
	private void initialize(int size){
		set = new ArrayList<Integer>();
		for(int i = 0; i < size; i++){
			set.add((int)(Math.random() * MAXIMUM));
		}
	}
	
	private void printSize(ArrayList<ArrayList<Integer>> subsets){
		int count = subsets.size();
		System.out.println("This set has " + count + " subsets");
	}

}
