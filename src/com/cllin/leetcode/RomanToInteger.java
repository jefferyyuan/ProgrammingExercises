package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Given a Roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 * Source: http://oj.leetcode.com/problems/roman-to-integer/
 */

public class RomanToInteger extends Exercise {
    private ArrayList<String> testSuites;
    private ArrayList<Integer> answers;
    private ArrayList<Integer> results;

    @Override
    public void initialize() {
        testSuites = new ArrayList<String>();
        answers = new ArrayList<Integer>();
        results = new ArrayList<Integer>();
        
        testSuites.add("I");
        testSuites.add("VI");
        testSuites.add("IV");
        testSuites.add("VII");
        testSuites.add("IX");
        testSuites.add("XI");
        testSuites.add("CXI");
        testSuites.add("XXXVI");
        testSuites.add("CXIV");
        testSuites.add("cXv");
        testSuites.add("dccXI");
        testSuites.add("MdXxxvi");
        testSuites.add("DLXXXI");
        testSuites.add("MCCCXXXIV");
        testSuites.add("MMMDCCCCLXXXXIX");
        testSuites.add("MCMXCVI");
        
        answers.add(1);
        answers.add(6);
        answers.add(4);
        answers.add(7);
        answers.add(9);
        answers.add(11);
        answers.add(111);
        answers.add(36);
        answers.add(114);
        answers.add(115);
        answers.add(711);
        answers.add(1536);
        answers.add(581);
        answers.add(1334);
        answers.add(3999);
        answers.add(1996);
        
    }

    @Override
    protected void runExercise() {
        initialize();
        
        for (String string : testSuites) {
            results.add(romanToInt(string));
        }
        
        if (test()) System.out.println("Success!");
        else System.out.println("Failed");
    }
    
    private int romanToInt(String s) {
        int length = s.length();
        if (length <= 0) return 0;
        int output = 0;
        s = s.toUpperCase();
        
        HashMap<String, Integer> romans = new HashMap<String, Integer>();
        romans.put("CM", 900);
        romans.put("CD", 400);
        romans.put("XC", 90);
        romans.put("XL", 40);
        romans.put("IX", 9);
        romans.put("IV", 4);
        
        for (String roman : romans.keySet()) {
            if (s.contains(roman)) {
                s = s.replace(roman, "");
                output += romans.get(roman);
            }
        }
        
        romans = new HashMap<String, Integer>();
        romans.put("M", 1000);
        romans.put("D", 500);
        romans.put("C", 100);
        romans.put("L", 50);
        romans.put("X", 10);
        romans.put("V", 5);
        romans.put("I", 1);
        
        int index = 0;
        while (index < s.length()) {
            String key = s.substring(index, index + 1);
            if (romans.containsKey(key)) {
                output += romans.get(key);
                index++;
            } else {
                return -1;
            }
        }
        
        return output;
    }

    @Override
    public boolean test() {
        for (int i = 0; i < results.size(); i++) {
            if (results.get(i).intValue() != answers.get(i).intValue()) {
                System.out.printf("%s is translated to %d, while it should be %d%n", 
                        testSuites.get(i), results.get(i), answers.get(i));
                return false; 
            }
            
            System.out.printf("%s is translated to %d, just as expected%n", 
                    testSuites.get(i), results.get(i));
        }
        
        return true;
    }

}
