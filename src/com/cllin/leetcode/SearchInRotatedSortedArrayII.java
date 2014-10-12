package com.cllin.leetcode;

import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Follow up for "Search in Rotated Sorted Array":
 * What if duplicates are allowed? Would this affect the run-time complexity? How and why?
 * 
 * Source: http://oj.leetcode.com/problems/search-in-rotated-sorted-array-ii/
 */

public class SearchInRotatedSortedArrayII extends LeetCodeExercise {
    private final int MAXIMUM = 200;
    private final int SIZE = 100;
    
    private int[] numbers;
    private int target;
    private boolean result;

    @Override
    public void initialize() {
        result = false;
        target = (int) (Math.random() * MAXIMUM);
        
        int[] tmp = new int[SIZE];
        for (int i = 0; i < SIZE; i++) {
            tmp[i] = (int) (Math.random() * MAXIMUM);
        }
        
        Arrays.sort(tmp);
        
        int pivot = (int) (Math.random() * SIZE);
        numbers = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            if (i < SIZE - pivot) numbers[i] = tmp[i + pivot];
            else numbers[i] = tmp[i - SIZE + pivot];
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            initialize();
            
            result = search(numbers, target);
            if (test()) System.out.println("Success");
            else System.out.println("Failed");    
        }
    }
    
    private boolean search(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (numbers[mid] == target) return true;
            
            if (numbers[start] < numbers[mid]) {
                if (numbers[start] <= target && target < numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (numbers[start] > numbers[mid]) {
                if (numbers[mid] < target && target <= numbers[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                start++;
            }
        }
        
        return false;
    }
    
    @Override
    public boolean test() {
        boolean found = false;
        int length = numbers.length;
        
        for (int i = 0; i < length; i++) {
            if (numbers[i] == target) {
                found = true;
                break;
            }
        }
        
        return (found == result);
    }

}
