package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

public class MaximalRectangle implements LeetCodeExercise {

	private char[][][] testSuite = {
			{{'1'}},
			{{'1', '0'}},
			{{'0', '1'}},
			{{'1', '1'}},
			{{'1', '1'}, {'1', '1'}},
			{{'1', '1'}, {'1', '0'}},
			{{'0', '1', '1', '0', '1'}, {'1', '1', '0', '1', '0'}, 
				{'0', '1', '1' ,'1', '0'}, {'1', '1', '1', '1', '0'},
				{'1', '1', '1', '1', '1'}, {'0', '0', '0', '0', '0'}},
			{{'0', '0', '0', '0', '1', '1', '1', '0', '1'},
					{'0', '0', '1', '1', '1', '1', '1', '0', '1'},
					{'0', '0', '0', '1', '1', '1', '1', '1', '0'}}
	};
	
	private int index;
	private int maximum;	
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			maximum = maximalRectangle(testSuite[index]);
			test();
		}
	}
	
	private int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) return 0;
		
		ArrayList<ArrayList<Integer>> histogram = buildHistogram(matrix);
		int maximum = getMaximumFromHistogram(histogram);

		return maximum;
    }
	
	private int getMaximumFromHistogram(ArrayList<ArrayList<Integer>> histogram) {
		int size = histogram.size();
		int maximum = 0;
		for (int i = 0; i < size; i++) {
			int s = histogram.get(i).size();
			int localMaximum = 0;
			
			for (int j = 0; j < s; j++) {
				if (histogram.get(i).get(j) != 0) {
					
					int localHeight = histogram.get(i).get(j);
					for (int height = localHeight; height > 0; height--) {
						int width = 0;
						for (int p = j; p < s && histogram.get(i).get(p) >= height; p++) {
							width++;
						}
						
						localMaximum = Math.max(localMaximum, width * height);
					}
					
				}
			}
			maximum = Math.max(maximum, localMaximum);
		}
		
		return maximum;
	}
	
	private ArrayList<ArrayList<Integer>> buildHistogram(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		ArrayList<ArrayList<Integer>> histogram = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < m; i++) {
			ArrayList<Integer> h = new ArrayList<Integer>();
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '0') {
					h.add(0);
				} else {
					int count = 0;
					for (int p = i; p >= 0 && matrix[p][j] == '1'; p--) count++;
					h.add(count);
				}
			}
			histogram.add(h);
		}
		
		return histogram;
	}

	@Override
	public boolean test() {
		System.out.printf("The area of the maximum rectangle of the below grid is %d%n", maximum);
		
		for (int i = 0; i < testSuite[index].length; i++) {
			for (int j = 0; j < testSuite[index][0].length; j++) {
				System.out.printf("%c ", testSuite[index][i][j]);
			}
			System.out.println();
		}
		
		System.out.println("------------------");
		
		return true;
	}

}
