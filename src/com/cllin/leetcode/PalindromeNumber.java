package com.cllin.leetcode;

import com.cllin.main.Exercise;

public class PalindromeNumber extends Exercise {
    private final int[] testSuite = {0, 1, 5566, 183, 1111, 11011};
    private boolean result;
    
    @Override
    public void initialize() {
        result = false;
    }

    @Override
    protected void runExercise() {
        initialize();
        
        for (int n : testSuite) {
            result = isPalindrome(n);
            if (result) System.out.printf("%d is a palindrome number%n", n);
            else System.out.printf("%d is not a palindrome number%n", n);    
        }
    }
    
    private boolean isPalindrome(int x) {
        if (x <= 0) return x == 0;
        
        int digits = 0;
        int reference = x;
        
        while (reference > 0) {
            reference /= 10;
            digits++;
        }
        
        digits--;
        while (x > 0) {
            int head = x / (int) Math.pow(10, digits);
            int tail = x % 10;
            
            if (head != tail) return false;
            
            x -= tail;
            x %= (int) Math.pow(10, digits);
            x /= 10;
            digits -= 2;
        }
        
        return true;
    }
    
    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
