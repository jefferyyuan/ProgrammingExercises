package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
 * 
 * Source: http://oj.leetcode.com/problems/scramble-string/
 */

public class ScrambleString extends Exercise {

    private final TestCase[] testSuite = {
            new TestCase("", "", true),
            new TestCase("", "a", false),
            new TestCase("a", "b", false),
            new TestCase("ab", "ba", true),
            new TestCase("great", "rgeat", true),
            new TestCase("great", "rgtae", true),
            new TestCase("abb", "bab", true),
            new TestCase("abab", "bbaa", true),
            new TestCase("abcd", "bcda", true)
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private boolean isScramble(String s1, String s2) {
        if (s1 == null && s2 == null) return true;
        if (s1 == null || s2 == null) return false;
        if (s1.length() != s2.length()) return false;
        
        int length = s1.length();
        
        int[] counts = new int[128];
        Arrays.fill(counts, 0);
        
        for (int i = 0; i < length; i++) {
            counts[(int) s1.charAt(i)]++;
            counts[(int) s2.charAt(i)]--;
        }
        
        for (int i = 0; i < 128; i++) {
            if (counts[i] != 0) return false;
        }
        
        if (length <= 3) return true;
        for (int i = 1; i < length; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) == true 
                    && isScramble(s1.substring(i), s2.substring(i)) == true) return true;
            
            if (isScramble(s1.substring(0, i), s2.substring(length - i)) == true 
                    && isScramble(s1.substring(i), s2.substring(0, length - i)) == true) return true;
        }
        
        return false;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];

            boolean isScrambleString = isScramble(test.string1, test.string2);
            if (testSuite[index].isScrambleString == isScrambleString) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                return false;
            }
        }

        return true;
    }
    
    private class TestCase {
        String string1;
        String string2;
        boolean isScrambleString;
        
        private TestCase(String string1, String string2, boolean isScrambleString) {
            this.string1 = string1;
            this.string2 = string2;
            this.isScrambleString = isScrambleString;
        }
    }

}
