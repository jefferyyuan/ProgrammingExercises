package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Design an algorithm and write code to remove the duplicate characters in a string without using any additional buffer.
 * 
 * NOTE: One or two additional variables are fine. An extra copy of the array is not.
 * FOLLOW UP: Write the test cases for this method.
 */

public class Exercise01_03 extends Exercise {

//  Null string, all duplicates, no duplicates, continuous duplicates, non-continuous duplicates
    private final String[] testSuite = {null, "zzzzz", "car", "apple", "banana"};
    private String input;
    
    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (String string : testSuite) {
            input = string;
        }    
    }

    @Override
    protected void test() {
        String output = removeDuplicates(input);
        
        if (output != null) {
            for (int i = 0; i < output.length(); i++) {
                for (int j = 0; j < i; j++) {
                    if (output.charAt(j) == output.charAt(i)) {
                        System.out.println("Failed");
                        return;
                    }
                }
            }
        }
        
        System.out.printf("Origin = %s, Output = %s%n", input, output);
    }
    
//  Note that in Java, we can not change characters in a string, so an extra char[] is needed
    private String removeDuplicates(String string) {
        if (string == null) return null;
        char[] word = string.toCharArray();
        
        int tail = word.length - 1;
        for (int i = 0; i <= tail; i++) {
            
            for (int j = i + 1; j <= tail; j++) {
//            if there is any duplicate character, swap it with the last unique one
            if (word[j] == word[i]) {
                char temp = word[tail];
                word[tail] = word[j];
                word[j] = temp;
                
            }
            }
        }
        
        return new String(word).substring(0, tail + 1);
    }
}
