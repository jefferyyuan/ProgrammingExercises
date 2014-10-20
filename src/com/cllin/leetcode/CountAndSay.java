package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * Source: http://oj.leetcode.com/problems/count-and-say/
 */

public class CountAndSay extends Exercise {

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    protected void runExercise() {
        for (int n = 1; n <= 5; n++) {
            String sequence = countAndSay(n);
            System.out.printf("The %dth sequence is %s%n", n, sequence);
        }
    }
    
    private String countAndSay(int n) {
        String sequence = "1";
        
        int iteration = 1;
        while (iteration < n) {
            int length = sequence.length();
            StringBuffer buffer = new StringBuffer();
            
            int i = 0;
            while (i < length) {
                char c = sequence.charAt(i);
                int count = 1;
                int j = i + 1;
                while (j < length && sequence.charAt(j) == c) {
                    count++;
                    j++;
                }
                
                buffer.append(count).append(c);
                i = j;
            }
            
            sequence = buffer.toString();
            iteration++;
        }
        
        return sequence;
    }

    @Override
    public boolean test() {
        // TODO Auto-generated method stub
        return false;
    }

}
