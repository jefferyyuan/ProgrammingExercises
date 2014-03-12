package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class PermutationsII implements LeetCodeExercise {
	private final int[][] testSuite = {
			{},
			{1},
			{1, 2, 3},
			{1, 1, 2}
	};
	
	private int index;
	ArrayList<ArrayList<Integer>> result;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 2; index < testSuite.length; index++) {
			result = permuteUnique(testSuite[index]);
			test();
		}
	}

	private ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> permutions = new ArrayList<ArrayList<Integer>>();
		
		if (num == null || num.length == 0) return permutions;
		else if (num.length == 1) {
			ArrayList<Integer> p = new ArrayList<Integer>();
			p.add(num[0]);
			permutions.add(p);
			return permutions;
		}
		
		Arrays.sort(num);
		
		int length = num.length;
		for (int i = 0; i < length; i++) {
			if (i > 0 && num[i] == num[i - 1]) {
//				DO NOTHING WHEN FINDING DUPLICATES
			} else {
				int[] next = new int[length - 1];
				for (int j = 0; j < length - 1; j++) {
					if (j < i) next[j] = num[j];
					else next[j] = num[j + 1];
				}
				
				ArrayList<ArrayList<Integer>> p = permuteUnique(next);
				for (ArrayList<Integer> permute : p) {
					permute.add(num[i]);
				}
				
				permutions.addAll(p);
			}
		}
		
		return permutions;
    }
	
	@Override
	public boolean test() {
		System.out.print("For the set [ ");
		for (int n : testSuite[index]) System.out.printf("%d ", n);
		System.out.print("], the permutions are:\n");
		
		for (ArrayList<Integer> permution : result) {
			for (int n : permution) System.out.printf("%d ", n);
			System.out.println();
		}
		
		System.out.println("------------------");
		return true;
	}

}
