package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

import com.cllin.main.LeetCodeExercise;

/*
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array
 * 
 * Source: http://oj.leetcode.com/problems/search-in-rotated-sorted-array/
 */

public class SearchInRotatedSortedArray implements LeetCodeExercise {
    private final int MAXIMUM = 20;
    private final int SIZE = 10;
    
    private int[] numbers;
    private int target;
    private int result;
    
    @Override
    public void initialize() {
        result = -1;
        target = (int) (Math.random() * MAXIMUM);
        
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        for (int i = 0; i < SIZE; i++) {
            tmp.add((int) (Math.random() * MAXIMUM));
        }
        
        for (int i = 0; i < tmp.size(); i++) {
            for (int j = i + 1; j < tmp.size(); j++) {
                if (tmp.get(i).intValue() == tmp.get(j).intValue()) tmp.remove(j);
            }
        }
        
        int size = tmp.size();
        int[] buf = new int[size];
        for (int i = 0; i < size; i++) {
            buf[i] = tmp.get(i).intValue();
        }
        
        Arrays.sort(buf);
        
        int pivot = (int) (Math.random() * size);
        numbers = new int[size];
        
        for (int i = 0; i < size; i++) {
            if (i < size - pivot) numbers[i] = buf[i + pivot];
            else numbers[i] = buf[i - size + pivot];
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            initialize();
            
            numbers = new int[]{1, 3, 5};
            target = 1;
            
            result = search(numbers, target);
            if (test()) System.out.println("Success");
            else System.out.println("Failed");    
        }
    }
    
    private int search(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            
            if (numbers[mid] == target) return mid;
            
            if (numbers[start] <= numbers[mid]) {
                if (numbers[start] <= target && target < numbers[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (numbers[mid] < target && target <= numbers[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        
        return -1;
    }

    @Override
    public boolean test() {
        int index = -1;
        int length = numbers.length;
        
        for (int i = 0; i < length; i++) {
            if (numbers[i] == target) {
                index = i;
                break;
            }
        }
        
        return (index == result)? true : false;
    }
}
