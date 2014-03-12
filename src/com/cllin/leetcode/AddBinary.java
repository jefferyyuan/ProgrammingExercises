package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

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
		int indexA = a.length() - 1;
		int indexB = b.length() - 1;
		boolean addOne = false;
		StringBuffer buffer = new StringBuffer();
		
		while (indexA >= 0 || indexB >= 0) {
			char charA;
			char charB;
			char result = 0;
			
			if (indexA >= 0 && indexB >= 0) {
				charA = a.charAt(indexA);
				charB = b.charAt(indexB);
				
				if (charA == charB) {
					result = '0';
					if (addOne) {
						result = '1';
						addOne = false;
					}
					
					if (charA == '1') addOne = true;
				} else {
					result = '1';
					if (addOne) {
						result = '0';
						addOne = true;
					}					
				}
			} else if (indexA >= 0) {
				charA = a.charAt(indexA);

				if (charA == '0') {
					if (addOne) {
						result = '1';
						addOne = false;
					} else result = charA;
				} else {
					if (addOne) {
						result = '0';
						addOne = true;
					} else result = charA;
				}
			} else if (indexB >= 0)  {
				charB = b.charAt(indexB);

				if (charB == '0') {
					if (addOne) {
						result = '1';
						addOne = false;
					} else result = charB;
				} else {
					if (addOne) {
						result = '0';
						addOne = true;
					} else result = charB;
				}
				
			}

			buffer.append(result);
			indexA--;
			indexB--;
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
