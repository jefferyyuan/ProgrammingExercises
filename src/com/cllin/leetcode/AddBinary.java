package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given two binary strings, return their sum (also a binary string).
 * 
 * For example,
 * 		a = "11"
 * 		b = "1"
 * 		Return "100".
 * 
 * Source: http://oj.leetcode.com/problems/add-binary/
 */

public class AddBinary implements LeetCodeExercise {
	private final TestCase[] testSuite = {
		new TestCase("", "", "0"),
		new TestCase("1", "1", "10"),
		new TestCase("11", "1", "100"),
		new TestCase("0", "1", "1"),
		new TestCase("1010", "1011", "10101"),
		new TestCase("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", 
				"110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011", 
				"110111101100010011000101110110100000011101000101011001000011011000001100011110011010010011000000000")
		
	};
	
	private int index;
	private String solution;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			solution = addBinary(testSuite[index].a, testSuite[index].b);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private String addBinary(String a, String b) {
		boolean addOne = false;
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		StringBuffer buffer = new StringBuffer();
		
		while (indexA >= 0 && indexB >= 0) {
			char charA = a.charAt(indexA);
			char charB = b.charAt(indexB);
	
			char result = (charA == charB)? '0' : '1';
			if (addOne) {
				result = (result == '0')? '1' : '0';
			}
			addOne = (charA == charB)? charA == '1' : addOne;

			buffer.append(result);
			indexA--;
			indexB--;
		}
		
		int index = (indexA >= 0)? indexA : indexB;
		String remaining = (indexA >= 0)? a : b;
		
		while (index >= 0) {
			char c = remaining.charAt(index);
			char result = (addOne)? ((c == '0')? '1' : '0') : c;
			
			addOne = addOne && c == '1';
			
			buffer.append(result);
			index--;
		}
		
		if (addOne) buffer.append('1');
		
		return (buffer.length() == 0)? "0" : buffer.reverse().toString();
	}

	@Override
	public boolean test() {
		return (solution.equals(testSuite[index].solution));
	}

	private class TestCase {
		String a;
		String b;
		String solution;
		
		TestCase(String a, String b, String solution) {
			this.a = a;
			this.b = b;
			this.solution = solution;
		}
	}
}
