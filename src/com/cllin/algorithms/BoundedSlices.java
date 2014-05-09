package com.cllin.algorithms;

import java.util.ArrayList;

import com.cllin.main.Exercise;

/*
 * Consider the array 3 5 7 6 3. 
 * Return the pair of indices that forms the slice where the difference between the maximum and minimum in the slice <= 2. 
 * 
 * Output:
 * (0,0) (1,1) (2,2) (3,3) (4,4) (0,1) (1,2) (1,3) (2,3) 
 *
 * Source: http://www.careercup.com/question?id=5090693043191808
 */

public class BoundedSlices implements Exercise {

	private final int[][] testSuite = {
			{3, 5, 7, 6, 3},
			{4, 1, 2, 3, 4, 5, 6, 10, 12}
	};
	
	private int index;
	private ArrayList<ArrayList<Integer>> slices;
	
	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			slices = boundedSlices(testSuite[index]);
			test();
		}
	}
	
	private ArrayList<ArrayList<Integer>> boundedSlices(int[] array) {
		ArrayList<ArrayList<Integer>> slices = new ArrayList<ArrayList<Integer>>();
		if (array == null || array.length == 0) return slices;
		
		for (int i = 0; i < array.length; i++) {
			int j = i;
			int min = i, max = i;
			while (j < array.length && Math.abs(array[j] - array[min]) <= 2 && Math.abs(array[j] - array[max]) <= 2) {
				if (array[j] < array[min]) min = j;
				if (array[j] > array[max]) max = j;
				
				ArrayList<Integer> slice = new ArrayList<Integer>();
				slice.add(i);
				slice.add(j);
				slices.add(slice);
				j++;
			}
		}
		
		return slices;
	}

	private void test() {
		System.out.print("A = { ");
		for (int n : testSuite[index]) {
			System.out.printf("%d ", n);
		}
		System.out.print("}\n");
		
		System.out.println("Slices whose difference between minimum and maximum is smaller than 2 are:");
		for (ArrayList<Integer> slice : slices) {
			for (int n : slice) {
				System.out.printf("A[%d] = %d ", n, testSuite[index][n]);
			}
			System.out.println();
		}
		
		System.out.println("------------------------------");
	}
}
