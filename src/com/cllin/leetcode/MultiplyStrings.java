package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * 
 * Source: http://oj.leetcode.com/problems/multiply-strings/
 */

public class MultiplyStrings implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("0", "0"),			
			new TestCase("100", "0"),
			new TestCase("100", "100"),
			new TestCase("12", "15"),
			new TestCase("123", "5"),
			new TestCase("6913259244", "71103343")
	};
	
	private int index;
	private String product;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			product = multiply(test.num1, test.num2);
			
			test();
		}
	}
	
	private String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
		
		int length1 = num1.length();
		int length2 = num2.length();
		int[] digits = new int[length1 + length2];
		
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();
		for (int i = 0; i < length1; i++) {
			int a = num1.charAt(i) - '0';
			
			for (int j = 0; j < length2; j++) {
				int b = num2.charAt(j) - '0';
				digits[i + j] += a * b;
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < length1 + length2; i++) {
			int carry = digits[i] / 10;
			int digit = digits[i] % 10;
			
			buffer.insert(0, digit);
			if (i < length1 + length2 - 1) {
				digits[i + 1] += carry;
			} else {
				buffer.insert(0, carry);
			}
		}
		
		int startIndex = 0;
		while (startIndex < buffer.length() && buffer.charAt(startIndex) == '0') {
			startIndex++;
		}
		
    	return (startIndex == buffer.length())? "0" : buffer.substring(startIndex);
    }

	@Override
	public boolean test() {
		TestCase test = testSuite[index];
		System.out.printf("%s * %s = %s%n", test.num1, test.num2, product);
		
		return true;
	}
	
	private class TestCase {
		String num1;
		String num2;
		
		TestCase(String num1, String num2) {
			this.num1 = num1;
			this.num2 = num2;
		}
	}
}
