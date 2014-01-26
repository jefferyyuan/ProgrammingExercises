package com.cllin.leetcode;

public class IntegerToRoman implements LeetCodeExercise {
	private final int SIZE = 100;
	private final int MAXIMUM = 3998;

	private int[] numbers;
	
	@Override
	public void initialize() {
		numbers = new int[SIZE];
		
		for (int i = 0; i < SIZE; i++) {
			numbers[i] = (int)(Math.random() * MAXIMUM) + 1;
		}

	}

	@Override
	public void runExercise() {
		initialize();
		
		for (int n : numbers) {
			System.out.printf("In Roman, %d is %s%n", n, intToRoman(n));
		}
	}
	
    private String intToRoman(int num) {
    	String string = new String();

    	int[] digits = new int[4];
    	
    	for (int i = 0; i < 4; i++) {
    		digits[i] = num % 10;
    		num -= num % 10;
    		num /= 10;
    	}
    	
    	for (int i = 0; i < digits[3]; i++) {
    		string += "M";
    	}
    	
    	if (digits[2] == 9) {
    		string += "CM";
    	} else if (digits[2] == 4) {
    		string += "CD";
    	} else if (digits[2] >= 5) {
    		string += "D";
    		
    		int k = digits[2] - 5;
    		for (int i = 0; i < k; i++) {
    			string += "C";
    		}
    	} else {
    		for (int i = 0; i < digits[2]; i++) {
    			string += "C";
    		}
    	}
    	
    	if (digits[1] == 9) {
    		string += "XC";
    	} else if (digits[1] == 4) {
    		string += "XL";
    	} else if (digits[1] >= 5) {
    		string += "L";
    		
    		int k = digits[1] - 5;
    		for (int i = 0; i < k; i++) {
    			string += "X";
    		}
    	} else {
    		for (int i = 0; i < digits[1]; i++) {
    			string += "X";
    		}
    	}
    	
    	if (digits[0] == 9) {
    		string += "IX";
    	} else if (digits[0] == 4) {
    		string += "IV";
    	} else if (digits[0] >= 5) {
    		string += "V";
    		
    		int k = digits[0] - 5;
    		for (int i = 0; i < k; i++) {
    			string += "I";
    		}
    	} else {
    		for (int i = 0; i < digits[0]; i++) {
    			string += "I";
    		}
    	}
    	
    	return string;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
