package com.cllin.leetcode;

public class PlusOne implements LeetCodeExercise {
	private final int MAXIMUM = 10;
	
	private int LENGTH = 5;
	private int reference;
	private int[] digits;

	@Override
	public void initialize() {
		digits = new int[LENGTH];
		reference = 0;
		
    	int power = (int) Math.pow(10, LENGTH - 1);
		for (int i = 0; i < LENGTH; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			
			digits[i] = value;
			reference += (value * power);
			power /= 10;
		}

		reference++;
	}

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			initialize();
			digits = plusOne(digits);
			
			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
    private int[] plusOne(int[] digits) {
    	if (digits == null || digits.length == 0) return new int[]{};
    	int length = digits.length;
 
    	digits[length - 1]++;
    	for (int i = length - 2; i >= 0; i--) {
    		if (digits[i + 1] == 10) {
    			digits[i]++;
    			digits[i + 1] = 0;
    		}
    	}
    	
    	if (digits[0] == 10) {
    		int[] result = new int[length + 1];
    		for (int i = length - 1; i >= 2; i--) {
    			result[i] = digits[i];
    		}
    		
    		result[1] = 0;
    		result[0] = 1;
    		
    		return result;
    	}
        
        return digits;
    }
    
    private int toInteger(int[] digits) {
    	int result = 0;
    	int length = digits.length;
    	
    	if (length == 0) return result;
    	
    	int power = (int) Math.pow(10, length - 1);
		for (int i = 0; i < length; i++) {
			result += (digits[i] * power);
			power /= 10;
		}
    	
    	return result;
    }

	@Override
	public boolean test() {
		return (toInteger(digits) == reference)? true : false;
	}

}
