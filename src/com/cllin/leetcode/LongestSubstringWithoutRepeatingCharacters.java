package com.cllin.leetcode;

import com.cllin.main.Exercise;

/*
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 * 
 * Source: http://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstringWithoutRepeatingCharacters extends Exercise {

    private final String[] testSuite = {
            "abcabcbb",
            "bbbbb",
            "aabcd",
            "wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"
    };
    
    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    /*
     * L(i) = Longest valid substring in A(0, i)
     * L(i + 1) = 
     *         1) If A(i + 1) does not exist in the current longest substring, L(i) + A(i + 1)
     *         2) Else, update the longest length. The new substring starts from the last occurance of A(i + 1) 
     */
    private int lengthOfLongestSubstring(String string) {
        if (string == null || string.length() == 0) return 0; 

        int longestSubstringLength = 0;
        String buffer = new String();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int index = buffer.indexOf(c);
            
            buffer = (index != -1)? buffer.substring(index + 1) + c : buffer + c;
            longestSubstringLength = Math.max(longestSubstringLength, buffer.length());
        }
        
        return longestSubstringLength;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            int length = lengthOfLongestSubstring(testSuite[index]);
            System.out.printf(
                    "The length of longest substring without repeating characters of %s is %d%n",
                    testSuite[index], length);
        }
        
        return true;
    }

}
