package com.cllin.cci.chap08;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Write a method to compute all permutations of a string
 */

public class Exercise08_04 extends Exercise {
    private final String[] testSuites = {"lol", "bbc", "apple", "banana", "car", "computer"};
    
    private static ArrayList<String> getPermutation(String input) {
        ArrayList<String> permutations = new ArrayList<String>();
        int count = 0;
        
        int length = input.length();
        for (int i = 0; i < length; i++) {
            char[] existingCharacter = new char[input.length()];
            existingCharacter[count] = input.charAt(count);
            count++;
            
            for (int j = i + 1; j < length; j++) {
                if (input.charAt(j) != input.charAt(i) 
                        && Arrays.binarySearch(existingCharacter, input.charAt(j)) < 0) {
                    char[] string = input.toCharArray();
                    char tmp = string[j];
                    string[j] = string[i];
                    string[i] = tmp;
                    
                    permutations.add(new String(string));
                }
            }
        }
        
        return permutations;
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (String string : testSuites) {
            ArrayList<String> permutations = getPermutation(string);
            for (String permutation : permutations) {
                System.out.println(permutation + " is a pemutation of " + string);
            }
            
            System.out.println("------------------------");
        }
    }

    @Override
    protected void test() {
        return;
    }

}
