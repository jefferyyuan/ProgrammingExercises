package com.cllin.algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import com.cllin.main.Exercise;

/*
 * Divide a list of numbers into group of consecutive numbers but their original order should be preserved.
 * 
 * For example,
 * Input = {8, 2, 4, 7, 1, 0, 3, 6}
 * Output = {{2, 4, 1, 0, 3}, {8, 7, 6}} 
 * 
 * Source: http://www.careercup.com/question?id=65732
 */

public class ConsecutiveGroups implements Exercise {

	private final int[][] testSuite = new int[][]{
			new int[]{8, 2, 4, 7, 1, 0, 3, 6},
			new int[]{0},
			new int[]{100, 4, 200, 1, 3, 2},
			new int[]{2147483646, -2147483647, 0, 2, 2147483644, -2147483645, 2147483645},
	};
	
	private int index;
	private ArrayList<ArrayList<Integer>> output;
	
	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			output = getGroup(testSuite[index]);
			test();
			
		}
	}
	
//	Assuming there are no duplicates in the array. If so, valueToIndex should be HashMap<Integer, ArrayList<Integer>>, etc.
	private ArrayList<ArrayList<Integer>> getGroup(int[] array) {
		int minimum = Integer.MAX_VALUE;
		int maximum = Integer.MIN_VALUE;
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		HashMap<Integer, Integer> valueToIndex = new HashMap<Integer, Integer>();
		ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < array.length; i++) {
			valueToIndex.put(array[i], i);
			values.add(array[i]);
			minimum = Math.min(minimum, array[i]);
			maximum = Math.max(maximum, array[i]);
		}
		
		while (!values.isEmpty()) {
			int value = values.get(0);
			int left = value - 1;
			int right = value + 1;
			int first = valueToIndex.get(value);
			int last = valueToIndex.get(value);
			
			HashMap<Integer, Integer> indexToValue = new HashMap<Integer, Integer>();
			indexToValue.put(valueToIndex.get(value), value);
			valueToIndex.remove(value);
			values.remove(0);
			
			while (valueToIndex.containsKey(left)) {
				first = Math.min(first, valueToIndex.get(left));
				last = Math.max(last, valueToIndex.get(left));
				indexToValue.put(valueToIndex.get(left), left);
				values.remove(values.indexOf(left));
				valueToIndex.remove(left--);
			}
			
			while (valueToIndex.containsKey(right)) {
				first = Math.min(first, valueToIndex.get(right));
				last = Math.max(last, valueToIndex.get(right));
				indexToValue.put(valueToIndex.get(right), right);
				values.remove(values.indexOf(right));
				valueToIndex.remove(right++);
			}
			
			ArrayList<Integer> group = new ArrayList<Integer>();
			int index = first;
			while (index <= last) {
				if (indexToValue.containsKey(index)) {
					group.add(indexToValue.get(index));
				}
				index++;
			}
			
			output.add(group);
		}
		
		return output;
	}
	
	private void test() {
		System.out.print("Input = { ");
		for (int n : testSuite[index]) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		System.out.print("Output = { ");
		for (ArrayList<Integer> group : output) {
			System.out.printf("{ ");
			for (Integer n : group) {
				System.out.printf("%d ", n.intValue());
			}
			System.out.printf("} ");
		}
		System.out.printf("}%n");
		System.out.println("------------------------------");
	}

}
