package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class MaximumSubarray extends Exercise {
    private final int MAXIMUM = 10000;
    private final int SIZE = 10000;
    private int[] numbers = new int[SIZE];
    
    private Solution findMaximumSubarray(int[] array, int low, int high) {
        if (high == low) return new Solution(low, high, array[low]);
        
        int mid = (low + high) / 2;
        Solution left = findMaximumSubarray(array, low, mid);
        Solution right = findMaximumSubarray(array, mid + 1, high);
        Solution cross = findMaximumCrossingArray(array, low, mid, high);
        
        if (left.sum > right.sum && left.sum > cross.sum) {
            return left;
        } else if (right.sum > left.sum && right.sum > cross.sum) {
            return right;
        } else {
            return cross;
        }
    }
    
    private Solution findMaximumCrossingArray(int[] array, int low, int mid, int high) {
        int leftSum = 0;
        int rightSum = 0;
        int leftMax = array[mid];
        int rightMax = array[mid + 1];
        int sum = 0;
        int maxLeftIndex = mid;
        int maxRightIndex = mid + 1;
        
        for (int i = mid; i >= low; i--) {
            leftSum += array[i];
            if(leftSum > leftMax){
                leftMax = leftSum;
                maxLeftIndex = i;
            }
        }
        
        for (int i = mid + 1; i <= high; i++) {
            rightSum += array[i];
            if (rightSum > rightMax) {
                rightMax = rightSum;
                maxRightIndex = i;
            }        
        }

        sum = Math.max(Math.max(leftMax, rightMax), leftMax + rightMax);
        
        return new Solution(maxLeftIndex, maxRightIndex, sum);
    }
    
    private static boolean getRandomBoolean(){
        return Math.random() < 0.5;
    }
    
    private class Solution {
        private int leftIndex = 0;
        private int rightIndex = 0;
        private int sum = 0;
        
        public Solution(int leftIndex, int rightIndex, int sum) {
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
            this.sum = sum;
        }
        
        public void printSolution() {
            System.out.println("The sum of maximum subarray is " + sum 
                    + ", which starts from element #" + leftIndex + " to #" + rightIndex);
        }
    }

    @Override
    protected void initialize() {
        int length = numbers.length;
        for (int i = 0; i < length; i++) {
            numbers[i] = (int) (Math.random() * MAXIMUM);
            if (getRandomBoolean()) numbers[i] *= (-1);
        }        
    }

    @Override
    protected void runExercise() {
        return;
    }

    @Override
    protected boolean test() {
        findMaximumSubarray(numbers, 0, numbers.length - 1).printSolution();
        return true;
    }

}
