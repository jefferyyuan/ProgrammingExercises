package com.cllin.cci.chap01;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Write a method to decide if two strings are anagrams or not.
 */

public class Exercise01_04 extends Exercise {

    private final TestCase[] testSuite = new TestCase[]{
            new TestCase("mary", "army"),
            new TestCase("no", "on")
    };
    private TestCase pair;

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (TestCase test : testSuite) {
            pair = test;
        }
    }

    @Override
    protected void test() {
    boolean result = areAnagrams(pair.s1, pair.s2);
    System.out.printf("%s and %s %s anagrams%n", pair.s1, pair.s2, (result)? "are" : "are not");
    }
    
    /*
     * Time Complexity = O(n), n = lenght of the string
     * Space Complexity = O(n)
     */
    private boolean areAnagrams(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        
        HashMap<Character, Integer> count1 = new HashMap<Character, Integer>();
        HashMap<Character, Integer> count2 = new HashMap<Character, Integer>();

        for (int i = 0; i < s1.length(); i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);

            int c1 = (count1.containsKey(char1))? count1.get(char1) : 0;
            int c2 = (count2.containsKey(char2))? count1.get(char2) : 0;
            count1.put(char1, c1 + 1);
            count1.put(char2, c2 + 1);
        }
        
        for (Character character : count1.keySet()) {
            if (!count2.containsKey(character) || count2.get(character) != count1.get(character)) {
                return false;
            }
        }
        
        return true;
    }
    
    private class TestCase {
        String s1;
        String s2;
        TestCase(String s1, String s2) {
            this.s1 = s1;
            this.s2 = s2;
        }
    }
}
