package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given an array of strings, return all groups of strings that are anagrams.
 * 
 * Source: http://oj.leetcode.com/problems/anagrams/
 */

public class Anagrams extends Exercise {
    
    private final String[][] testSuite = {
            {"army", "apple", "mary"},
            {"ape", "and", "cat"}
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
     * Strings that are anagram shares the same characters.
     * 1) Sort the string as an array of characters
     * 2) Arrays should be identical if the strings are anagram
     */
    private ArrayList<String> anagrams(String[] strings) {
        ArrayList<String> anagrams = new ArrayList<String>();
        HashMap<String, ArrayList<String>> counts = new HashMap<String, ArrayList<String>>();
        
        if (strings == null || strings.length == 0) return anagrams;
        
        for (int i = 0; i < strings.length; i++) {
            String sorted = sort(strings[i]);
            ArrayList<String> list = (counts.containsKey(sorted))? counts.get(sorted) : new ArrayList<String>();
            
            list.add(strings[i]);
            counts.put(sorted, list);
        }
        
        for (String key : counts.keySet()) {
            if (counts.get(key).size() > 1) {
                anagrams.addAll(counts.get(key));
            }
        }
        
        return anagrams;
    }
    
    private String sort(String string) {
        if (string == null) return null;
        
        char[] array = string.toCharArray();
        Arrays.sort(array);
        
        return new String(array);
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            ArrayList<String> anagrams = anagrams(testSuite[index]);

            System.out.print("For the strings { ");
            for (String string : testSuite[index])
                System.out.printf("%s ", string);
            System.out.print("}, the anagram sets are:\n");

            for (String string : anagrams) {
                System.out.printf("%s ", string);
            }

            System.out.println();
        }
        
        return true;
    }
}
