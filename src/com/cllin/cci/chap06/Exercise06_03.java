package com.cllin.cci.chap06;

import com.cllin.main.Exercise;

/*
 * You have a five quart jug and a three quart jug, and an unlimited supply of water (but no measuring cups).
 * How would you come up with exactly four quarts of water?
 */

public class Exercise06_03 extends Exercise {
    private final int MAXIMUM_A = 11;
    private final int MAXIMUM_B = 7;
    
    private static int getWater(int goal, int maxA, int maxB) {
        if (goal > maxA && goal > maxB) return Integer.MAX_VALUE;
        
        int nSteps = 0;
        NextStep next = NextStep.A_POUR_TO_B;
        int jugA = maxA;
        int jugB = 0;
        
        while (jugA != goal && jugB != goal) {
            switch(next) {
            case A_POUR_TO_B:
                if (jugA >= maxB) {
                    jugA -= (maxB - jugB);
                    jugB = maxB;
                } else {
                    jugB += jugA;
                    jugA = 0;
                }
                next = NextStep.CLEAR_B;
                break;
            case CLEAR_B:
                jugB = 0;
                next = NextStep.A_POUR_TO_B;
                break;
            case FILL_A:
                jugA = maxA;
                next = NextStep.A_POUR_TO_B;
                break;
            }
            
            if (jugA == 0) next = NextStep.FILL_A;
            nSteps++;
            
            System.out.printf("JugA=%d, JugB=%d%n", jugA, jugB);
        }
        
        return nSteps;
    }
    
    private enum NextStep {
        A_POUR_TO_B,
        CLEAR_B,
        FILL_A
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i <= MAXIMUM_A; i++) {
            int nSteps = getWater(i, MAXIMUM_A, MAXIMUM_B);
            System.out.printf("It takes %d steps to get %d%n", nSteps, i);
            System.out.println("------------------------------");
        }
    }

    @Override
    protected boolean test() {
        return true;
    }

}
