package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class LongestCommonSubsequence extends Exercise {
    private final TestCase[] testSuite = new TestCase[]{
            new TestCase("how did you do it", "zoe, how did you ask jack to do it")
    };
    
    private static final int UPPERLEFT = 10;
    private static final int UP = 1;
    private static final int LEFT = 2;
    
    private String getLCSubsequence(String string1, String string2) {
        int length1 = string1.length();
        int length2 = string2.length();
        int[][] length = new int[length1 + 1][length2 + 1];
        int[][] states = new int[length1 + 1][length2 + 1];
        
        for (int i = 0; i < length1; i++) length[i][0] = 0;
        for (int j = 0; j < length2; j++) length[0][j] = 0;
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                
                if (string1.charAt(i - 1) == string2.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    states[i][j] = UPPERLEFT;
                } else if (length[i - 1][j] >= length[i][j - 1]) {
                    length[i][j] = length[i - 1][j];
                    states[i][j] = UP;
                } else {
                    length[i][j] = length[i][j - 1];
                    states[i][j] = LEFT;
                }
            }
        }
        
        int i = length1;
        int j = length2;
        StringBuffer subsequence = new StringBuffer();
        while (i > 0 && j > 0) {
            switch(states[i][j]) {
            case UPPERLEFT:
                subsequence.insert(0, string1.charAt(i - 1));
                i--;
                j--;
                break;
            case UP:
                i--;
                break;
            case LEFT:
                j--;
                break;
            }
        }
        
        return subsequence.toString();
    }
    
    private String getLCSubstring(String string1, String string2){
        int length1 = string1.length();
        int length2 = string2.length();
        int[][] length = new int[length1 + 1][length2 + 1];
        
        int longest = 0;
        String longestCommonSubstring = new String();
        
        for (int i = 0; i < length1; i++) length[i][0] = 0;
        for (int j = 0; j < length2; j++) length[0][j] = 0;
        
        for (int i = 1; i <= length1; i++) {
            for (int j = 1; j <= length2; j++) {
                if (string1.charAt(i - 1) ==  string2.charAt(j - 1)) {
                    length[i][j] = length[i - 1][j - 1] + 1;
                    
                    if (length[i][j] > longest) {
                        longest = length[i][j];
                        longestCommonSubstring = string1.substring(i - longest, i);
                    }
                } else {
                    length[i][j] = 0;
                }
            }
        }
        
        return longestCommonSubstring;
    }
    
    private class TestCase {
        String string1;
        String string2;
        
        TestCase(String string1, String string2) {
            this.string1 = string1;
            this.string2 = string2;
        }
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
        for (TestCase test : testSuite) {
            String string1 = test.string1;
            String string2 = test.string2;

            System.out.printf("S1 = %s%nS2 = %s%n", string1, string2); 
            
            System.out.printf("The Longest Common Subsequence is: %s%n", getLCSubsequence(string1, string2));
            System.out.printf("The Longest Common Substring is: %s%n", getLCSubstring(string1, string2));
            
            System.out.println("------------------------------");
        }        
    }
}
