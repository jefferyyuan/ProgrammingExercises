package com.cllin.leetcode;

public class PalindromeNumber implements LeetCodeExercise {
	private final int[] testSuite = {0, 1, 5566, 183, 1111, 11011};
	private boolean result;
	
	@Override
	public void initialize() {
		result = false;
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (int n : testSuite) {
			result = isPalindrome(n);
			if (result) System.out.printf("%d is a palindrome number%n", n);
			else System.out.printf("%d is not a palindrome number%n", n);	
		}
	}
	
    private boolean isPalindrome(int x) {
    	if (x == 0) return true;
    	else if (x < 0) return false;
    	
    	int digits = 0;
    	int reference = x;
    	
    	while (reference > 0) {
    		reference /= 10;
    		digits++;
    	}
    	
    	int boundary = digits / 2;
    	int shift = digits - 1;
    	for (int i = 0; x > 0 && i <= boundary; i++) {
    		int d = x / (int) Math.pow(10, shift);
    		
    		if ((x - d) % 10 != 0) return false;
    		x -= (d + d * (int) Math.pow(10, shift));
    		x /= 10;
    		shift -= 2;
    	}
    	
        return true;
    }
	
	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
