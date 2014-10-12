package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). 
 * You begin the journey with an empty tank at one of the gas stations.
 * 
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * 
 * Note:
 * The solution is guaranteed to be unique.
 * 
 * Source: http://oj.leetcode.com/problems/gas-station/
 */

public class GasStation implements LeetCodeExercise {

    private final TestCase[] testSuite = {
            new TestCase(new int[]{3, 0, 0, 0}, new int[]{0, 1, 1, 1}),
            new TestCase(new int[]{1}, new int[]{10}),
            new TestCase(new int[]{5}, new int[]{4}),
            new TestCase(new int[]{1, 10, 1, 1, 1}, new int[]{2, 1, 1, 1, 2}), 
            new TestCase(new int[]{1, 1, 1, 1, 1}, new int[]{1, 1, 2, 1, 1}),
            new TestCase(new int[]{1, 2, 3, 3}, new int[]{2, 1, 5, 1}),
            new TestCase(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}),
            new TestCase(
                    new int[]{
                        67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 
                        87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 
                        7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,    37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 
                        47, 48, 49, 50, 51, 52, 53, 54, 55, 56,    57, 58, 59, 60, 61, 62, 63, 64, 65, 66}, 
                    new int[]{
                        27, 28, 29, 30, 31, 32, 33, 34, 35, 36,    37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 
                        47, 48, 49, 50, 51, 52, 53, 54, 55, 56,    57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 
                        67, 68, 69, 70, 71, 72, 73, 74, 75, 76,    77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 
                        87, 88, 89, 90, 91, 92, 93, 94, 95, 96,    97, 98, 99, 100, 1, 2, 3, 4, 5, 6, 
                        7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26})
    };
    
    private int index;
    private int startingIndex;
    
    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        for (index = 6; index < testSuite.length; index++) {
            TestCase testCase = testSuite[index];
            startingIndex = canCompleteCircuit(testCase.gas, testCase.cost);
            test();
        }
    }
    
    private int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || cost == null) return -1;
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) return -1;

        int start = 0;
        int tank = 0;
        int length = gas.length;
        
        for (int i = 0; i < length * 2; i++) {
            tank += (gas[i % length] - cost[i % length]);
            
            if (tank < 0) {
                tank = 0;
                start = i + 1;
            }
        }
        
        return (start < length)? start : -1;
    }

    @Override
    public boolean test() {
        System.out.print("Given the gas and cost on the route,\n");
        
        System.out.print("Gas = \t{ ");
        for (int gas : testSuite[index].gas) System.out.printf("%d ", gas);
        System.out.print("}\n");
        
        System.out.print("Cost = \t{ ");
        for (int gas : testSuite[index].cost) System.out.printf("%d ", gas);
        System.out.print("}\n");
        
        System.out.printf("We can travel around the route only if we start from station #%d%n", startingIndex);
        System.out.println("------------------");
        
        return true;
    }

    private class TestCase {
        int[] gas;
        int[] cost;
        
        TestCase(int[] gas, int[] cost) {
            this.gas = gas;
            this.cost = cost;
        }
    }
}
