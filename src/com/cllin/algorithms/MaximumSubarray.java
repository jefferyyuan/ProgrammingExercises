package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class MaximumSubarray implements Exercise {
	private final int MAXIMUM = 10000;
	private final int SIZE = 10000;
	private int[] numbers = new int[SIZE];

	@Override
	public void runExercise() {
		Solution solution;
		
		initialization();
		solution = findMaximumSubarray(numbers, 0, numbers.length - 1);
		
		solution.printSolution();
	}
	
	private Solution findMaximumSubarray(int[] array, int low, int high){
		if (high == low) return new Solution(low, high, array[low]);
		
		int mid = (low + high) / 2;
		Solution left = findMaximumSubarray(array, low, mid);
		Solution right = findMaximumSubarray(array, mid + 1, high);
		Solution cross = findMaximumCrossingArray(array, low, mid, high);
		
		if(left.sum > right.sum && left.sum > cross.sum){
			return left;
		}else if(right.sum > left.sum && right.sum > cross.sum){
			return right;
		}else{
			return cross;
		}
	}
	
	private Solution findMaximumCrossingArray(int[] array, int low, int mid, int high){
		int leftSum = -2147483647;
		int rightSum = -2147483647;
		int sum = 0;
		int maxLeftIndex = 0;
		int maxRightIndex = 0;
		
		for(int i = mid; i > low - 1; i--){
			sum += array[i];
			if(sum > leftSum){
				leftSum = sum;
				maxLeftIndex = i;
			}
		}
		
		for(int i = mid + 1; i < high + 1; i++){
			sum += array[i];
			if(sum > rightSum){
				rightSum = sum;
				maxRightIndex = i;
			}			
		}
		
		return new Solution(maxLeftIndex, maxRightIndex, leftSum + rightSum);
	}
	
	private void initialization(){
		int length = numbers.length;
		for(int i = 0; i < length; i++){
			numbers[i] = (int)(Math.random() * MAXIMUM);
			if(getRandomBoolean()) numbers[i] *= (-1);
		}
	}
	
	private boolean getRandomBoolean(){
		return Math.random() < 0.5;
	}
	
	private class Solution{
		private int leftIndex = 0;
		private int rightIndex = 0;
		private int sum = 0;
		
		public Solution(int leftIndex, int rightIndex, int sum){
			this.leftIndex = leftIndex;
			this.rightIndex = rightIndex;
			this.sum = sum;
		}
		
		public void printSolution(){
			System.out.println("The sum of maximum subarray is " + sum 
					+ ", which starts from element #" + leftIndex + " to #" + rightIndex);
		}
	}

}
