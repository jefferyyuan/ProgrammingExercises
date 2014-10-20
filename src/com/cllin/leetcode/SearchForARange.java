package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.Exercise;

/*
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * Source: http://oj.leetcode.com/problems/search-for-a-range/
 */

public class SearchForARange extends Exercise {
    private final int SIZE = 10;
    private final int MAXIMUM = 10;
    
    private int target;
    private int[] numbers;
    private int[] result;

    @Override
    public void initialize() {
        target = (int) (Math.random() * MAXIMUM);
        
        numbers = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            numbers[i] = (int) (Math.random() * MAXIMUM);
        }
        
        Arrays.sort(numbers);
    }

    @Override
    protected void runExercise() {
        for (int i = 0; i < 100; i++) {
            initialize();
            result = searchRange(numbers, target);
            
            if (test()) System.out.println("Success");
            else System.out.println("Failed");
        }
    }
    
    private int[] searchRange(int[] array, int target) {
        int[] range = new int[]{-1, -1};
        int length = array.length;
        
        if (length == 0) return range;
        if (target < array[0] || array[length - 1] < target ) return range;
        
        int index = binarySearch(array, target, 0, length - 1);
        if (index == -1) return range;
        
        int begin = index;
        int end = index;
        
        while (begin >= 0 && array[begin] == target) {
            begin--;
        }
        
        while (end <= length - 1 && array[end] == target) {
            end++;
        }
        
        return new int[]{(begin == -1)? 0 : begin + 1, (end == length)? length - 1 : end - 1};
    }
    
    private int binarySearch(int[] array, int target, int start, int end) {
        if (start == end) return (array[start] == target)? start : -1;
        else if (start > end) return -1;
        
        int mid = (start + end) / 2;
        
        if (target == array[mid]) return mid;
        else if (target < array[mid]) return binarySearch(array, target, start, mid - 1);
        else return binarySearch(array, target, mid + 1, end);
    }

    @Override
    public boolean test() {
        int begin = -1;
        int end = -1;
        ArrayList<Integer> range = new ArrayList<Integer>();
        for (int i = 0; i < SIZE; i++) {
            if (numbers[i] == target) range.add(i);
        }
        
        if (range.size() != 0) {
            begin = range.get(0);
            end = range.get(range.size() - 1);
        }
        
        return (result[0] == begin && result[1] == end)? true : false;
    }

}
