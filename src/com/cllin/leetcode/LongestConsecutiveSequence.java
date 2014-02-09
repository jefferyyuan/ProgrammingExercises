package com.cllin.leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence implements LeetCodeExercise {
	private final int SIZE = 1000;
	private final int MAXIMUM = 2000;
	
	private int[] array;
	private int result;

	@Override
	public void initialize() {
		result = 0;
		array = new int[SIZE];
		for (int i = 0; i < SIZE; i++) {
			array[i] = (int) (Math.random() * MAXIMUM);
		}
	}

	@Override
	public void runExercise() {
		initialize();
//		array = new int[]{0};
//		array = new int[]{100, 4, 200, 1, 3, 2};
//		array = new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645};
		array = new int[]{-3, -9, -3, 4, -3, -9, -3, -6, 8, -3, 0, 1, 5, -1, -4, 0, -7, 1, 5};

		result = longestConsecutive(array);
		test();
	}
	
	private int longestConsecutive(int[] num) {
		int length = num.length;
		HashMap<Integer, Boolean> set = new HashMap<Integer, Boolean>();
		if (length == 0) return length;
		
		for (int i = 0; i < length; i++) set.put(num[i], false);

		int size = set.size();
		int longest = 0;
		int max = -2147483648;
		int min = 2147483647;
		for (int i = 0; i < size; i++) {
			if (!set.get(num[i])) {
				max = Math.max(max, num[i]);
				min = Math.min(min, num[i]);
				
				int delta = 1;
				int leftLength = 0;
				while (true) {
					if (set.containsKey(num[i] - delta)) {
						min = Math.min(min, num[i] - delta);
						set.put(num[i] - delta, true);
						leftLength++;
						delta++;
					} else break;
				}
				
				delta = 1;
				int rightLength = 0;
				while (true) {
					if (set.containsKey(num[i] + delta)) {
						max = Math.max(max, num[i] + delta);
						set.put(num[i] + delta, true);
						rightLength++;
						delta++;
					} else break;
				}
				
				if (leftLength + rightLength >= longest) {
					longest = leftLength + rightLength + 1;
				}
			}
		}
		
		return longest;
	}

	@Override
	public boolean test() {
		System.out.printf("The length of the longest consecutive sequence is %d%n", result);
		return false;
	}

}
