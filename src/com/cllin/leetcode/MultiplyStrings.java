package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

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
		if (num1 == null || num2 == null) {
			return "0";
		}
		
		ArrayList<String> products = new ArrayList<String>();
		int length1 = num1.length();
		int length2 = num2.length();
		
		StringBuffer buffer = new StringBuffer();
		
		for (int i = length1 - 1; i >= 0; i--) {
			int c = Character.getNumericValue(num1.charAt(i));
			StringBuffer buf = new StringBuffer();
			
			if (c == 0) {
				buf.append(c);
				products.add(buf.toString());
			} else {
				for (int p = 0; p < length1 - i - 1; p++) {
					buf.append('0');
				}
				
				int add = 0;
				for (int j = length2 - 1; j >= 0; j--) {
					int p = Character.getNumericValue(num2.charAt(j)) * c + add;
					
					add = (p >= 10)? (p / 10) : 0;
					p -= add * 10;
					
					buf.insert(0, p);
				}
				
				if (add != 0) buf.insert(0, add);
				products.add(buf.toString());
			}
		}
		
		int add = 0;
		for (int i = 0; i <= length1 + length2; i++) {
			int p = add;
			for (String product : products) {
				if (product.length() - 1 >= i) {
					p += Character.getNumericValue(product.charAt(product.length() - 1 - i));
				}
			}
			
			add = (p >= 10)? (p / 10) : 0;
			p -= add * 10;
			
			buffer.insert(0, p);
		}
		
		if (add != 0) buffer.insert(0, add);
		
		int startIndex = buffer.length() - 1;
		for (int i = 0; i < buffer.length(); i++) {
			if (buffer.charAt(i) != '0') {
				startIndex = i;
				break;
			}
		}
		
    	return buffer.substring(startIndex);
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
