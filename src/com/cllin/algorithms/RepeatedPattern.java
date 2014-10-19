package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Given an input string S write a function which returns true if it satisfies S = nT. 
 * Find if S can be represented from a substring by iterating it n times. n >= 2
 * 
 * Function should return true for:
 *         1) S = "abab"
 *         2) S = "abcdabcd"
 *         3) S = "abcabcabc"
 *         4) S = "zzxzzxzzx"
 * 
 * Function should return false if:
 *         1) S = "abac"
 *         2) S = "abcdabbd"
 *         3) S = "abcabcefg"
 *         4) S = "zzxzzyzzx"
 * 
 * Source: http://www.geeksforgeeks.org/forums/topic/google-interview-question-for-software-engineerdeveloper-fresher-about-strings/
 */

public class RepeatedPattern extends Exercise {

    private final String[] testSuite = {
            "abab",
            "abcdabcd",
            "abcabcabc",
            "zzxzzxzzx",
            "abac",
            "abcdabbd",
            "abcabcefg",
            "zzxzzyzzx"
    };
    
    private int index;
    private boolean isRepeatedPattern;
    
    private boolean isRepeatedPattern(String string) {
        String concatenate = string + string;
        return (concatenate.indexOf(string, 1) < string.length());
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    @Override
    protected void test() {
        for (index = 0; index < testSuite.length; index++) {
            isRepeatedPattern = isRepeatedPattern(testSuite[index]);

            System.out.printf("%s %s a pattern of its substring%n", testSuite[index], (isRepeatedPattern)? "is" : "is not");
        }
    }
}
