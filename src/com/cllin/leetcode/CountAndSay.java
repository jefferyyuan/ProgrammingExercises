package com.cllin.leetcode;

public class CountAndSay implements LeetCodeExercise {

	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		for (int n = 1; n <= 5; n++) {
			String sequence = countAndSay(n);
			System.out.printf("The %dth sequence is %s%n", n, sequence);
		}
	}
	
	private String countAndSay(int n) {
		String sequence = "1";
		for (int i = 1; i < n; i++) {
			sequence = getSequence(sequence);
		}
		
    	return sequence;
	}
	
	private String getSequence(String string) {
		int i = 0;
		int length = string.length();
		StringBuffer buffer = new StringBuffer();
		
		while (i < length) {
			char c = string.charAt(i);
			int number = Character.getNumericValue(string.charAt(i));
			int count = 1;
			int j = 0;
			for (j = i + 1; j < length; j++) {
				if (string.charAt(j) != c) break;
				else count++;
			}
			
			buffer.append(count).append(number);
			i = j;
		}
		return buffer.toString();
	}

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
