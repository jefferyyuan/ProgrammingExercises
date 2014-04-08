package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. 
 * A gray code sequence must begin with 0.
 * 
 * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 * 		00 - 0
 * 		01 - 1
 * 		11 - 3
 * 		10 - 2
 * Note:
 * For a given n, a gray code sequence is not uniquely defined.
 * 
 * Source: http://oj.leetcode.com/problems/gray-code/
 */

public class GrayCode implements LeetCodeExercise {
	private final int[] testSuite = {0, 1, 2, 3, 4, 5, 6};
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub

	}

	@Override
	public void runExercise() {
		for (int n : testSuite) {
			ArrayList<Integer> result = grayCode(n);
			
			System.out.printf("For n = %d, the Grey Code list is:%n", n);
			for (int code : result) {
				System.out.println(Integer.toBinaryString(code));
			}
			System.out.println("------------");
		}

	}
	
    private ArrayList<Integer> grayCode(int n) {
    	ArrayList<Integer> output = new ArrayList<Integer>();
    	ArrayList<String> string = grayCodeString(n);
    	
    	for (String s : string) {
    		output.add(Integer.parseInt(s, 2));
    	}
    	
    	return output;
    }
    
    private ArrayList<String> grayCodeString(int n) {
    	ArrayList<String> output = new ArrayList<String>();
    	
    	if (n == 0) {
    	    output.add("0");
    	    return output;
    	} else if (n == 1) {
    		output.add("0");
    		output.add("1");
    		return output;
    	}
    	
    	ArrayList<String> previous = grayCodeString(n - 1);
    	int size = previous.size();

    	for (int i = 0; i < size; i++) {
    		output.add("0" + previous.get(i));
    	}
    	
    	for (int i = size - 1; i >= 0; i--) {
    		output.add("1" + previous.get(i));
    	}
    	
    	return output;
    }

	@Override
	public boolean test() {
		// TODO Auto-generated method stub
		return false;
	}

}
