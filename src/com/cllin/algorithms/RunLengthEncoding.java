package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class RunLengthEncoding extends Exercise {

    private final String[] testSuite = new String[] {
            "BBBWBBBBBWWWBB"
    };

    private static String encode(String input) {
        if (input == null || input.length() == 0) return new String();
        
        StringBuffer output = new StringBuffer();
        
        int index = 0;
        while (index < input.length()) {
            int count = 0;
            char character = input.charAt(index);
            while (index < input.length() && input.charAt(index) == character) {
                count++;
                index++;
            }
            
            output.append(count).append(character);
        }
        
        return output.toString();
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (String input : testSuite) {
            String output = encode(input);
            System.out.println(output);
        }
    }

    @Override
    protected boolean test() {
        return true;
    }
}
