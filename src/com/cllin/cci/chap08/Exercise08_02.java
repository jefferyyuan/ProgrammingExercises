package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

/*
 * Imagine a robot sitting on the upper left hand corner of an NxN grid. 
 * The robot can only move in two directions: right and down.
 * 
 * How many possible paths are there for the robot to reach the lower right corner?
 * 
 * FOLLOW UP
 * Imagine certain squares are "off limits", such that the robot can not step on them. 
 * Design an algorithm to get all possible paths for the robot.
 * 
 */

public class Exercise08_02 extends Exercise {
    private final int[] testSuite = {1, 2, 3, 4, 6, 8, 10, 15, 20};
    
    private static int getRouteNumber(int size) {
        int[][] paths = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            paths[0][i] = 1;
            paths[i][0] = 1;
        }
        
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        return paths[size - 1][size - 1];
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        for (int n : testSuite) {
            int nRoutes = getRouteNumber(n);
            System.out.println("There are " + nRoutes + " routes for a squre grid with size " + n);
        }        
    }

    @Override
    protected boolean test() {
        return true;
    }
}
