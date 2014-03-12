package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

public class ReverseWordsInAString implements LeetCodeExercise {

	private final String[] testSuite = {
			"the sky is blue",
			"sup   buddy",
			"  sup   buddy",
			"sup   buddy  ",
			"  sup   buddy  "
	};
	
	private int index;
	private String reversedString;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			reversedString = reverseWords(testSuite[index]);
			
			test();
		}
	}
	
	private String reverseWords(String string) {
		if (string == null || string.length() == 0) return new String();
		
		int length = string.length();
		char[] charArray = string.toCharArray();
		for (int i = 0; i < length / 2; i++) {
			char tmp = charArray[length - 1 - i];
			charArray[length - 1 - i] = charArray[i];
			charArray[i] = tmp;
		}
		
		int i = 0;
		while (i < length) {
			int j = i + 1;
			while (j < length && charArray[j] != ' ') {
				j++;
			}
			
			int l = (j - i);
			for (int p = 0; p < l / 2; p++) {
				char tmp = charArray[l - 1 - p + i];
				charArray[l - 1 - p + i] = charArray[i + p];
				charArray[i + p] = tmp;
			}
			
			i = j + 1;
			while (i < length && charArray[i] == ' ') {
				i++;
			}
		}
		
		StringBuffer buffer = new StringBuffer(new String(charArray));
		for (int idx = 1; idx < buffer.length(); idx++) {
			if (buffer.charAt(idx) == ' ' && buffer.charAt(idx - 1) == ' ') {
				buffer.deleteCharAt(idx);
				idx--;
			}
		}
		
		while (buffer.length() >= 0 && buffer.charAt(0) == ' ') {
			buffer.deleteCharAt(0);
		}
		
		while (buffer.length() >= 0 && buffer.charAt(buffer.length() - 1) == ' ') {
			buffer.deleteCharAt(buffer.length() - 1);
		}
		
    	return buffer.toString();
    }

	@Override
	public boolean test() {
		System.out.printf("%s -> %s%n", testSuite[index], reversedString);
		return true;
	}

}
