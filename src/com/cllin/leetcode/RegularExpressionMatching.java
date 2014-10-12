package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Implement regular expression matching with support for '.' and '*'.
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * 
 * The matching should cover the entire input string (not partial).
 * 
 * Some examples:
 *         isMatch("aa","a") -> false
 *         isMatch("aa","aa") -> true
 *         isMatch("aaa","aa") -> false
 *         isMatch("aa", "a*") -> true
 *         isMatch("aa", ".*") -> true
 *         isMatch("ab", ".*") -> true
 *         isMatch("aab", "c*a*b") -> true
 * 
 * Source: http://oj.leetcode.com/problems/regular-expression-matching/
 */

public class RegularExpressionMatching implements LeetCodeExercise {

    private TestCase[] testSuite = {
            new TestCase("aa", "a"),
            new TestCase("aa", "aa"),
            new TestCase("aa", "aaa"),
            new TestCase("aa", "a*"),
            new TestCase("aa", ".*"),
            new TestCase("aab", "c*a*b"),
            new TestCase("aaa", "ab*ac*a"),
            new TestCase("b", "c*bb"),
            new TestCase("aaa", "ab*a"),
            new TestCase("aaa", "a*a")
    };
    
    private int index;
    private boolean isMatch;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            isMatch = isMatch(test.s, test.p);
            
            test();
        }
    }
    
    /*
     * M(i, j) = P(0, j) matches S(0, i)
     * M(i, j) is true if:
     *         1) P(j) == S(i)
     *         2) P(j) == '.'
     *         3) P(j) == '*' AND M(i, j - 2)                            --- Omitting the previous character
     *         4) P(j) == '*' AND P(j - 1) == S(i) AND M(i - 1, j)        --- Repeating the previous character
     */
    private static boolean isMatch(String s, String p) {
        if (s == null) return (p == null);

        boolean[][] matches = new boolean[s.length() + 1][p.length() + 1];
        
        matches[0][0] = true;
        for (int i = 1; i <= s.length(); i++) matches[i][0] = false;
        for (int j = 1; j <= p.length(); j++) matches[0][j] = false;
        
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (i >= 1 && matches[i - 1][j - 1] && matches(s.charAt(i - 1), p.charAt(j - 1))) {
                    matches[i][j] = true;
                    continue;
                }
                
                if (j >= 2 && p.charAt(j - 1) == '*') {
                    if (matches[i][j - 2]) {
                        matches[i][j] = true;
                        continue;
                    }
                    
                    if (i >= 1 && matches[i - 1][j] && matches(s.charAt(i - 1), p.charAt(j - 2))) {
                        matches[i][j] = true;
                        continue;
                    }
                }
                
                matches[i][j] = false;
            }
        }
        
        return matches[s.length()][p.length()];
    }
    
    private static boolean matches(char s, char p) {
        return (s == p || p == '.');
    }
    
    @Override
    public boolean test() {
        TestCase test = testSuite[index];
        System.out.printf("%s %s %s%n", test.p, (isMatch)? "matches" : "does not match", test.s);
        
        return true;
    }
    
    private class TestCase {
        String s;
        String p;
        TestCase(String s, String p) {
            this.s = s;
            this.p = p;
        }
    }

}
