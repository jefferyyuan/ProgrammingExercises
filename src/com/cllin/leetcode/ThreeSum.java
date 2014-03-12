package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

public class ThreeSum implements LeetCodeExercise {
	
	private final int[][] testSuite = {
			{-1, 0, 1, 2, -1, -4},
			{-2, 0, 1, 1, 2},
			{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6},
			{0, 0, 0},
			{0, 0, 0, 0}
	};
	
	private int index;
	private ArrayList<ArrayList<Integer>> triplets;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			long start = System.currentTimeMillis();
			
			triplets = threeSum(Arrays.copyOf(testSuite[index], testSuite[index].length));
			
			test();
			long end = System.currentTimeMillis();
			System.out.printf("Time Cost = %d ms%n", (int) (end - start));
		}
	}
	
	private ArrayList<ArrayList<Integer>> threeSum(int[] num) {
		ArrayList<ArrayList<Integer>> set  = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length < 3) {
			return set;
		}
		
		Arrays.sort(num);
		if (num[0] > 0 || num[num.length - 1] < 0) {
			return set;
		}
		
		int i = 0;
		while (i <= num.length - 3) {
			while (i < num.length && i >= 1 && num[i] == num[i - 1]) i++;
			
			int j = i + 1;
			while (j < num.length && j > i + 1 && num[j] == num[j - 1]) j++;
			
			int k = num.length - 1;
			while (k > j && k <= num.length - 2 && num[k] == num[k + 1]) k++;
			
			if (i >= num.length - 1 || k <= j) break;
			if (num[i] > 0 || num[k] < 0) break;
			
			while (j < k) {
				if (num[i] + num[j] + num[k] == 0) {
					ArrayList<Integer> triplet = new ArrayList<Integer>();
					triplet.add(num[i]);
					triplet.add(num[j]);
					triplet.add(num[k]);
					
					if (!set.contains(triplet)) {
						set.add(triplet);
					}
					
					j++;
					k--;
				}
				
				if (num[i] + num[j] + num[k] < 0) {
					j++;
				} else if (num[i] + num[j] + num[k] > 0) {
					k--;
					j = i + 1;
				}
			}
			i++;
		}
		
    	return set;
    }

	@Override
	public boolean test() {
		System.out.print("Given the set { ");
		for (int n : testSuite[index]) {
			System.out.printf("%d ", n);
		}
		System.out.print("}, the solution set is:\n");
		
		for (ArrayList<Integer> triplet : triplets) {
			for (int n : triplet) {
				System.out.printf("%d ", n);
			}
			System.out.println();
		}
		
		System.out.println("------------------");
		
		return true;
	}

}
