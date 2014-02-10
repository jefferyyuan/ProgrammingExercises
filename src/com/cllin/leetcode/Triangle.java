package com.cllin.leetcode;

import java.util.ArrayList;

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
//		for (int i = 1; i <= SIZE; i++) {
//			ArrayList<Integer> level = new ArrayList<Integer>();
//			for (int j = 0; j < i; j++) level.add((int) (Math.random() * MAXIMUM));
//			
//			triangle.add(level);
//		}
		
		ArrayList<Integer> lv1 = new ArrayList<Integer>();
		lv1.add(-1);
		
		ArrayList<Integer> lv2 = new ArrayList<Integer>();
		lv2.add(2);
		lv2.add(3);
		
		ArrayList<Integer> lv3 = new ArrayList<Integer>();
		lv3.add(1);
		lv3.add(-1);
		lv3.add(-3);
		
		triangle.add(lv1);
		triangle.add(lv2);
		triangle.add(lv3);
		
	}

	@Override
	public void runExercise() {
		initialize();
		result = minimumTotal(triangle);
		test();
	}
	
	private int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
		int height = triangle.size();
		int sum = 2147483647;
		int[] last = new int[height];
		int[] current = new int[height];
		
		for (int i = 0; i < height; i++) {
			for (int j = 0; j <= i; j++) {
				int value = 0;
				if (i == 0) {
					value = triangle.get(i).get(j);
				} else {
					if (j == 0) value = last[0] + triangle.get(i).get(j);
					else if (j == i) value = last[i - 1] + triangle.get(i).get(j);
					else {
						value = Math.min(last[j - 1], last[j]) + triangle.get(i).get(j);
					}
				}
				
				current[j] = value;
			}
			
			last = current;
			current = new int[height];
		}
		
		for (int i = 0; i < height; i++) sum = Math.min(last[i], sum);
		
		return sum;
	}

	@Override
	public boolean test() {
		System.out.printf("The minimum path sum is %d%n", result);
		return false;
	}

}
