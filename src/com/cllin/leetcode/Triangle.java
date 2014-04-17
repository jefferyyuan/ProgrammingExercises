package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 * For example, given the following triangle
 * 
 * 	[
 * 	     [2],
 * 	    [3,4],
 * 	   [6,5,7],
 * 	  [4,1,8,3]
 * 	]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 * 
 * Source: http://oj.leetcode.com/problems/triangle/
 */

public class Triangle implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private int SIZE;
	private ArrayList<ArrayList<Integer>> triangle;
	
	private int result;

	@Override
	public void initialize() {
		result = 0;
		SIZE = (int) (Math.random() * MAXIMUM) + 1;
		
		triangle = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= SIZE; i++) {
			ArrayList<Integer> level = new ArrayList<Integer>();
			for (int j = 0; j < i; j++) level.add((int) (Math.random() * MAXIMUM));
			
			triangle.add(level);
		}
	}

	@Override
	public void runExercise() {
		initialize();
		result = minimumTotal(triangle);
		test();
	}
	
	private int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int height = triangle.size();
		
		for (int i = height - 2; i >= 0; i--) {
			for (int j = 0; j < i + 1; j++) {
				int min = Integer.MAX_VALUE;
				for (int k = j; k <= j + 1; k++) {
					min = Math.min(min, triangle.get(i + 1).get(k) + triangle.get(i).get(j));
				}
				
				triangle.get(i).set(j, min);
			}
		}
		
		return triangle.get(0).get(0);
	}

	@Override
	public boolean test() {
		System.out.printf("The minimum path sum is %d%n", result);
		return false;
	}

}
