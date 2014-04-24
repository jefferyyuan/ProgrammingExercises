package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Given a string with all A's and B's. Edit the string such that all A's come before B's.
 * Return the minimum number of edition.
 */

public class EditString implements Exercise {

	private String[] testSuite = {
			"AAAA",
			"BBBB",
			"AABB",
			"ABAB",
			"BABA",
	};
	
	@Override
	public void runExercise() {
		for (String string : testSuite) {
			int distance = getDistance(string);
			System.out.printf("The minimum distance of %s is %d%n", string, distance);
		}
	}

	private int getDistance(String string) {
		int length = string.length();
		int distance = Integer.MAX_VALUE;
		
		int[] numA = new int[length];
		int[] numBBefore = new int[length];
		int[] numAAfter = new int[length];
		
		for (int i = 0; i < length; i++) {
			int prev = (i == 0)? 0 : numA[i - 1];
			numA[i] = (string.charAt(i) == 'A')? prev + 1 : prev;
		}

		for (int i = 0; i < length; i++) {
			numBBefore[i] = (i + 1) - numA[i];
			numAAfter[i] = numA[length - 1] - numA[i];
			
			int d = Integer.MAX_VALUE;
			if (numAAfter[i] == 0) d = (numBBefore[i] == i + 1)? 0 : numBBefore[i];
			
			distance = Math.min(distance, d);
		}
		
		return distance;
	}
}
