package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a collection of candidate numbers (C) and a target number (T), 
 * find all unique combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, ..., ak) must be in non-descending order. (ie, a1 <= a2 <= ... <= ak).
 * The solution set must not contain duplicate combinations.
 * 
 * Source: http://oj.leetcode.com/problems/combination-sum-ii/
 */

public class CombinationSumII implements LeetCodeExercise {
	private static final int[][] testSuite = new int[][]{
		{},
		{1},
		{7, 3, 2},
		{2, 3, 6, 7},
		{5, 10, 8, 4, 3, 12, 9},
		{9, 6, 8, 11, 5, 4},
		{10, 1, 2, 7, 6, 1, 5}
	};
	
	private int index;
	private int target;
	private ArrayList<ArrayList<Integer>> result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 1; index < testSuite.length; index++) {
			for (target = 1; target <= 1; target++) {
				result = combinationSum2(testSuite[index], target);
				
				if (!test()) System.out.println("Failed");
			}
		}
	}
	
	private ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length == 0 || target < 0) return combinations;
		
		Arrays.sort(num);
		
		return getCombination(new ArrayList<Integer>(), 0, num, target);
    }
	
	private ArrayList<ArrayList<Integer>> getCombination(ArrayList<Integer> current, 
			int startIndex, int[] candidates, int target) {
		ArrayList<ArrayList<Integer>> solution = new ArrayList<ArrayList<Integer>>();
		
		if (candidates == null || target < 0) return solution;
		
		if (target == 0) {
			Collections.sort(current);
			solution.add(current);
			return solution;
		}
		
		int length = candidates.length;
		for (int i = startIndex; i < length && target - candidates[i] >= 0;) {
			ArrayList<Integer> nextPath = new ArrayList<Integer>(current);
			nextPath.add(candidates[i]);
			
			solution.addAll(getCombination(nextPath, i + 1, candidates, target - candidates[i]));
			
			i = getNextDistinctNumberIndex(candidates, i);
		}
		
		return solution;
	}
	
	private int getNextDistinctNumberIndex(int[] candidates, int currentIndex) {
		int length = candidates.length;
		
		int i = currentIndex;
		while (i < length) {
			if (candidates[i] != candidates[currentIndex]) return i;
			i++;
		}
		
		return i;
	}

	@Override
	public boolean test() {
		System.out.print("For this set of candidates: { ");
		for (int i = 0; i < testSuite[index].length; i++) System.out.printf("%d ", testSuite[index][i]);
		System.out.printf("} and %d as the target, there are %d combinations: %n", target, result.size());
		
		for (ArrayList<Integer> combination : result) {
			int sum = 0;
			for (int i = 0; i < combination.size(); i++) {
				System.out.printf("%d ", combination.get(i));
				sum += combination.get(i);
			}
			if (sum != target) return false;
			System.out.println();
		}
		
		System.out.println();
		return true;
	}

}
