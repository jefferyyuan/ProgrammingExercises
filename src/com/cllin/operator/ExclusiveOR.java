package com.cllin.operator;

import com.cllin.main.Exercise;

public class ExclusiveOR extends Exercise {
    
    private boolean operator(boolean a, boolean b){
        return a ^ b;
    }
    
    private boolean ifStatement(boolean a, boolean b){
        return !(a == b);
    }
    
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
            boolean a = getRandomBoolean();
            boolean b = getRandomBoolean();
            
            boolean result = operator(a, b);
            if (result != ifStatement(a, b)) {
                System.out.println("Failed");
                return;
            } else {
            System.out.println(a + " ^ " + b + " = " + result);    
            }
        }
    }

    @Override
    protected boolean test() {
        return true;
    }

}
