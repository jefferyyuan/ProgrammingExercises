package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

/*
 * Given an infinite number of quarters (25 cents), dimes (10 cents), nickels (5 cents) and pennies (1 cent), 
 * write code to calculate the number of ways of representing n cents.
 */

public class Exercise08_07 implements Exercise {
	private final int[] testSuites = {1, 27, 39, 100, 25, 492, 20, 1734, 5566, 183, 5};

	@Override
	public void runExercise() {
		for (int n : testSuites) {
			System.out.println("There are " + makeChanges(n) + " ways of changes for " + n);
		}
	}
	
	/*
	 * C(j) = Changes in order. For example, {1, 5, 10, 25}
	 * W(i, j) = Ways to representing i cents with C(0, j) (inclusive)
	 * 
	 * W(i, j) =
	 * 		1) 1, if i == 0 OR j == 0 (all in 1 cent)
	 * 		2) W(i, j - 1), if C(j) > i. 
	 * 			Which means i cannot be represented with C(j), number of ways will be the same as using C(0, j - 1)
	 * 		3) Else, W(i - C(j)) + W(i, j - 1) 
	 */
	private static int makeChanges(int n) {
		int[] changes = {1, 5, 10, 25};
		int[][] counts = new int[n + 1][4 + 1];
		counts[0][0] = 1;
		
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < 4; j++) {
				if (i == 0 || j == 0) {
					counts[i][j] = 1;
				} else if (changes[j] > i) {
					counts[i][j] = counts[i][j - 1];
				} else {
					counts[i][j] = counts[i][j - 1] + counts[i - changes[j]][j];
				}
			}
		}
		
		return counts[n][3];
	}
}
