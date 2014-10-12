package com.cllin.operator;

import com.cllin.main.Exercise;

public class Ternary extends Exercise {

    private static boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }

    @Override
    protected void initialize() {
    return;
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < 10; i++) {
            boolean randomBoolean = getRandomBoolean();
            String output = randomBoolean ? "Got true" : "Got false";
            
            System.out.println(output);
        }    
    }

    @Override
    protected void test() {
    return;
    }
    
}
