package com.cllin.algorithms;

import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Sort the input character array based on the dictionary given.
 * 
 * For example:
 * If input word is "SHEEP", sorting will make it as "EEHPS".
 * 
 * But in the dictionary, E may not be at first. As per the dictionary, if P is first, S followed and E later and finally H.
 * Then sorted array is ��PSEEH��.
 * 
 * Source: http://www.geeksforgeeks.org/forums/topic/google-telephonic-interview-questions/
 */

public class SortByDictionary extends Exercise {

    private final TestCase[] testSuite = {
            new TestCase(new char[]{'E', 'H', 'P', 'S'}, "SHEEP"),
            new TestCase(new char[]{'P', 'S', 'E', 'H'}, "SHEEP")
    };
    
    private String sortByDictionary(char[] dictionary, String string) {
        StringBuffer buffer = new StringBuffer();
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        
        for (char c : string.toCharArray()) {
            int count = (counts.containsKey(c))? counts.get(c).intValue() : 0;
            counts.put(c, count + 1);
        }
        
        for (int i = 0; i < dictionary.length; i++) {
            char c = dictionary[i];
            
            while (counts.containsKey(c)) {
                int count = counts.get(c).intValue();
                
                if (count == 0) {
                    counts.remove(c);
                } else {
                    counts.put(c, count - 1);
                    buffer.append(c);
                }
            }
        }
        
        return buffer.toString();
    }
    
    private class TestCase {
        char[] dictionary;
        String string;
        
        TestCase(char[] dictionary, String string) {
            this.dictionary = dictionary;
            this.string = string;
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
    protected boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            String output = sortByDictionary(testSuite[index].dictionary, testSuite[index].string);

            System.out.print("Dictionary = { ");
            for (char c : testSuite[index].dictionary) {
                System.out.printf("%c ", c);
            }
            System.out.printf("}%n");

            System.out.printf("Input = %s%n", testSuite[index].string);
            System.out.printf("Output = %s%n", output);

            System.out.println("------------------------------");
        }

        return true;
    }
}
