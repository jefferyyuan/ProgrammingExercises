package com.cllin.leetcode;

public class RemoveElement implements LeetCodeExercise {
	private final int MAXIMUM = 1000;
	private final int SIZE = 1000;
	
	private int[] array;
	private int newLength;
	private int value;
	
	@Override
	public void initialize() {
		array = new int[SIZE];
		newLength = 0;
		value = (int)(Math.random() * MAXIMUM);

		for (int i = 0; i < SIZE; i++) {
			int value = (int)(Math.random() * MAXIMUM);
			array[i] = value;
		}
	}

	@Override
	public void runExercise() {
		initialize();
		newLength = removeElement(array, value);
		if (test()) System.out.println("Success");
		else System.out.println("Failed");
	}
	
    private int removeElement(int[] A, int elem) {
        int length = A.length;
        int newLength = A.length;
        
        for (int i = 0; i < length; i++) {
        	if (A[i] == elem) {
        		
//        		Swap with the last valid element
        		for (int j = length - 1; j >= i; j--) {
        			if (A[j] == elem) {
        				A[j] = -2147483648;
        				newLength--;
        			}
        			
        			if (A[j] != -2147483648) {
        				A[i] = A[j]; 
        				A[j] = -2147483648;
        				newLength--;
        				break;
        			}
        		}
        	}
        }
        
        return newLength;
    }
    

	@Override
	public boolean test() {
		int count = 0;
		for (int i = 0; i < SIZE; i++) {
			if (array[i] == -2147483648) break;
			if (array[i] == value) return false;
			
			count++;
		}
		
		return (count == newLength)? true : false;
	}

}
