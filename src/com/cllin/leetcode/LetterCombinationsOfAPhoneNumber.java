package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given a digit string, return all possible letter combinations that the number could represent.
 * 
 * Source: http://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */

public class LetterCombinationsOfAPhoneNumber extends Exercise {
    private String[] testSuite = {"","23", "5566"};
    
    private int index;
    private ArrayList<String> result;

    @Override
    public void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    // Classic Breadth-first search
    private static ArrayList<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            // It is required to have a null String to pass the test cases of
            // LeetCode, blah :S
            ArrayList<String> combinations = new ArrayList<String>();
            combinations.add(new String());
            return combinations;
        }
        
        LinkedList<String> previousCombinations = new LinkedList<String>();
        LinkedList<String> combinations = new LinkedList<String>();

        for (int i = 0; i < digits.length(); i++) {
            int digit = Character.getNumericValue(digits.charAt(i));
            char[] characters = getCharacters(digit);
            
            if (previousCombinations.size() == 0) {
                for (char c : characters) {
                    combinations.add(String.valueOf(c));
                }
            } else {
                while (!previousCombinations.isEmpty()) {
                    String newCombination = new String(previousCombinations.poll());
                    
                    for (char c : characters) {
                        combinations.add(newCombination + String.valueOf(c));
                    }
                }
            }
            
            previousCombinations = combinations;
            combinations = new LinkedList<String>();
        }
        
        return new ArrayList<String>(previousCombinations);
    }
    
    private static char[] getCharacters(int digit) {
        switch (digit) {
        case 2:
            return new char[]{'a', 'b', 'c'};
        case 3:
            return new char[]{'d', 'e', 'f'};
        case 4:
            return new char[]{'g', 'h', 'i'};
        case 5:
            return new char[]{'j', 'k', 'l'};
        case 6:
            return new char[]{'m', 'n', 'o'};
        case 7:
            return new char[]{'p', 'q', 'r', 's'};
        case 8:
            return new char[]{'t', 'u', 'v'};
        case 9:
            return new char[]{'w', 'x', 'y', 'z'};
            default:
                return new char[4];
            
        }
    }

    @Override
    public boolean test() {
        for (index = 0; index < testSuite.length; index++) {
            result = letterCombinations(testSuite[index]);
            
            int expectedSize = 1;
            String input = testSuite[index];
            
            if (input.length() == 0) expectedSize = 1;
            else {
                for (char c : input.toCharArray()) {
                    int digit  = Character.getNumericValue(c);
                    if (digit < 7 || digit == 8) expectedSize *= 3;
                    else expectedSize *= 4;
                }
            }
            if ((result.size() == expectedSize)) {
                System.out.println("Success");
            } else {
                System.out.println("Failed");
                return false;
            }
        }
        
        return true;
    }

}
