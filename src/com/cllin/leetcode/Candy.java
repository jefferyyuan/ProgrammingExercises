package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;



public class Candy implements LeetCodeExercise {

	private int[][] testSuite = {
			{1, 2, 2},
			{2, 1},
			{2, 3, 2},
			{4, 2, 3, 4, 1}
	};
	
	private int index;
	private int minimumCandy;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			minimumCandy = candy(testSuite[index]);
			test();
		}
	}
	
	private int candy(int[] ratings) {
		if (ratings == null || ratings.length == 0) return 0;
		if (ratings.length == 1) return 1;

		int nCandy = 0;
		int nSequence = 0;
		int prevCandy = 1;
		int maximumInSequence = prevCandy;
		
		nCandy++;
		
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] < ratings[i - 1]) {
				nSequence++;
				
				if (maximumInSequence == nSequence) {
					nSequence++;
				}
				
				nCandy += nSequence;
				prevCandy = 1;
			} else {
				if (ratings[i] > ratings[i - 1]) {
					prevCandy++;
				} else {
					prevCandy = 1;
				}
				
				nCandy += prevCandy;
				nSequence = 0;
				maximumInSequence = prevCandy;
			}
		}
		
    	return nCandy;
    }

	@Override
	public boolean test() {
		System.out.print("For the following rating: { ");
		for (int i = 0; i < testSuite[index].length; i++) {
			System.out.printf("%d ", testSuite[index][i]);
		}
		
		System.out.printf("}, it needs %d candies at least%n", minimumCandy);
		return false;
	}

}
