package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class EditDistance implements LeetCodeExercise {
	private final TestCase[] testSuite = {
			new TestCase("", ""),
			new TestCase("a", "a"),
			new TestCase("mike", "bike"),
			new TestCase("kitten", "sitting")
	};

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (TestCase test : testSuite) {
			int distance = minDistance(test.word1, test.word2);
			System.out.printf("The edit distance between '%s' and '%s' is %d%n", test.word1, test.word2, distance);
		}
	}
	
	private int minDistance(String word1, String word2) {
		if (word1 == null || word2 == null) {
			if (word1 == null && word2 == null) return 0;
			else if (word1 == null) return word2.length();
			else if (word2 == null) return word1.length();
		}
		
		if (word1.length() == 0 || word2.length() == 0) {
			if (word1.length() == 0 && word2.length() == 0) return 0;
			else if (word1.length() == 0) return word2.length();
			else if (word2.length() == 0) return word1.length();
		}
		
		int length1 = word1.length();
		int length2 = word2.length();
		int[][] distanceMap = new int[length1 + 1][length2 + 1];
		
		for (int i = 0; i <= length1; i++) distanceMap[i][0] = i;
		for (int j = 0; j <= length2; j++) distanceMap[0][j] = j;
		
		for (int i = 1; i <= length1; i++) {
			for (int j = 1; j <= length2; j++) {
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					distanceMap[i][j] = distanceMap[i - 1][j - 1];
				} else {
					int min = Math.min(distanceMap[i - 1][j], distanceMap[i][j - 1]);
					min = Math.min(min, distanceMap[i - 1][j - 1]);
					
					distanceMap[i][j] = min + 1;
				}
			}
		}
		
		return distanceMap[length1][length2];
	}

	@Override
	public boolean test() {
		return false;
	}
	
	private class TestCase {
		String word1;
		String word2;
		
		TestCase(String word1, String word2) {
			this.word1 = word1;
			this.word2 = word2;
		}
	}

}