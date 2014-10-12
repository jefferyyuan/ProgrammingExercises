package com.cllin.algorithms;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given two strings A and B, find whether any anagram of string A is a sub-string of string B.
 * 
 * For example,
 * A = xyz
 * B = afdgzyxksldfm
 * 
 * The program should return true.
 * 
 * Source: http://www.careercup.com/question?id=5389078581215232
 */

public class AnagramSubstring extends Exercise {

    private final TestCase[] testSuite = {
            new TestCase("xyz", "afdgzyxksldfm")
    };
    
    private int index;
    private boolean result;
    
    @Override
    public void run() {
        for (index = 0; index < testSuite.length; index++) {
            result = hasAnagramSubstring(testSuite[index].A, testSuite[index].B);
            test();
        }
    }
    
    private boolean hasAnagramSubstring(String A, String B) {
        if (A.length() > B.length()) return false;

        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        HashMap<Character, Integer> reference = new HashMap<Character, Integer>();
        for (char key : A.toCharArray()) {
            int count = (reference.containsKey(key))? reference.get(key) : 0;
            reference.put(key, count + 1);
        }
        
        for (int i = 0; i < B.length() - A.length(); i++) {
            char key = B.charAt(i);
            int count = (counts.containsKey(B.charAt(i)))? counts.get(key) : 0;
            counts.put(B.charAt(i), count + 1);
            
            if (i < A.length()) continue;
            
            char last = B.charAt(i - A.length());
            counts.put(last, counts.get(last) - 1);
            if (counts.get(last) == 0) counts.remove(last);
            
            if (counts.equals(reference)) return true;
        }
        
        return false;
    }

    protected void test() {
        TestCase test = testSuite[index];
        System.out.printf("%s %s an anagram that is a substring of %s%n", test.A, (result)? "has" : "does not have", test.B);
        
    }
    
    private class TestCase {
        String A;
        String B;
        
        TestCase(String A, String B) {
            this.A = A;
            this.B = B;
        }
    }
}
