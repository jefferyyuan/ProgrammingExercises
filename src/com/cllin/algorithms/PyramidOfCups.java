package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * There is a pyramid with 1 cup at level 1, 2 at level 2 , 3 at level 3, etc.
 * It looks something like this:
 *         1
 *         2 3
 *         4 5 6
 * 
 * Given a pyramid with M levels, pour L liters of water from top. For each cup, its capacity is C(i).
 * When cup 1 gets filled , it overflows to cup 2 and 3 equally, and so on. 
 * 
 * Given M, C, and L. Find the amount of water in every cup.
 * 
 * Source: http://www.careercup.com/question?id=9820788
 */

public class PyramidOfCups extends Exercise {

    private TestCase test;
    private double[][] pyramid;

    private double[][] getPyramid(int levels, int[] capacity, double water) {
        double[][] pyramid = new double[levels][0];
        for (int i = 0; i < levels; i++) {
            pyramid[i] = new double[i + 1];
        }

        double amount = 0;
        pyramid[0][0] = water;
        for (int i = 0; i < pyramid.length && amount < water; i++) {
            for (int j = 0; j < pyramid[i].length && amount < water; j++) {
                if (pyramid[i][j] > capacity[(i + 1) * i / 2 + j]) {
                    double overflow = pyramid[i][j] - capacity[(i + 1) * i / 2 + j];
                    
                    pyramid[i][j] = capacity[(i + 1) * i / 2 + j];
                    amount += capacity[(i + 1) * i / 2 + j];
                    
                    if (i + 1 < levels) {
                        pyramid[i + 1][j] += overflow / 2;
                        pyramid[i + 1][j + 1] += overflow / 2;
                    }
                } else {
                    amount += pyramid[i][j];
                }
            }
        }
        
        return pyramid;
    }
    
    private class TestCase {
        static final int MAXIMUM_CAPACITY = 30;
        int[] capacity;
        int levels;

        TestCase(int levels) {
            this.levels = levels;

            capacity = new int[(levels + 1) * levels / 2];
            for (int i = 0; i < capacity.length; i++) {
                capacity[i] = (int) (Math.random() * MAXIMUM_CAPACITY) + 1;
            }
        }
    }

    @Override
    protected void initialize() {
        return;
    }

    @Override
    protected void runExercise() {
        int levels = 5;

        test = new TestCase(levels);
        pyramid = getPyramid(test.levels, test.capacity, 100);
    }

    @Override
    protected void test() {
        int count = 0;
        int levels = 1;
        System.out.printf("Capacity = {%n");
        System.out.print("    ");
        for (int capacity : test.capacity) {
            if (count == levels) {
                count = 0;
                levels++;
                System.out.println();
                System.out.print("    ");
            }
            
            System.out.printf("%d ", capacity);
            count++;
        }
        System.out.printf("%n}%n");
        
        double amount = 0;
        System.out.printf("Water = {%n");
        for (double[] level : pyramid) {
            System.out.print("    ");
            for (double water : level) {
                System.out.printf("%f ", water);
                amount += water;
            }
            System.out.println();
        }
        System.out.printf("}, Water in the Pyramid = %f%n", amount);
        
        System.out.println("------------------------------");
    }
}
