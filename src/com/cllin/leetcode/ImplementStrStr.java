package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Implement strStr().
 * Returns a pointer to the first occurrence of needle in haystack, or null if needle is not part of haystack.
 * 
 * Source: http://oj.leetcode.com/problems/implement-strstr/
 * 
 * strstr() returns a pointer to the first occurrence of str2 in str1, or a null pointer if str2 is not part of str1.
 * Reference: http://www.cplusplus.com/reference/cstring/strstr/
 */


public class ImplementStrStr extends LeetCodeExercise {

    private TestCase[] testSuite = {
        new TestCase("", ""),
        new TestCase("", "apple"),
        new TestCase("apple", ""),
        new TestCase("This is a simple string", "simple")
    };
    
    private int index;
    private String subString;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            TestCase test = testSuite[index];
            subString = strStr(test.haystack, test.needle);
            
            test();
        }
    }
    
    private String strStr(String haystack, String needle) {
        if (haystack == null) return null;
        if (needle == null || needle.length() == 0) return haystack;
        
        int hayLength = haystack.length();
        int needleLength = needle.length();
        
        for (int i = 0; i < hayLength - needleLength; i++) {
            int j = 0;
            boolean flag = true;
            
            while (j < needleLength && flag) {
                flag = haystack.charAt(i + j) == needle.charAt(j);
                j++;
            }
            
            if (flag) return haystack.substring(i);
        }
        
        return null;
    }

    @Override
    public boolean test() {
        if (subString == null) System.out.println("null");
        else System.out.println(subString);
        
        return true;
    }

    private class TestCase {
        String haystack;
        String needle;
        
        TestCase(String haystack, String needle) {
            this.haystack = haystack;
            this.needle = needle;
        }
    }
}
