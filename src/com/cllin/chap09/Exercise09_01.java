package com.cllin.chap09;

import java.util.Arrays;

import com.cllin.main.Exercise;

public class Exercise09_01 implements Exercise {

	private final int MAXIMUM = 10000;
	protected final int SIZE_A = 10000;
	protected final int SIZE_ACTUAL_A = 3000;
	protected final int SIZE_B = 4000;
	protected int[] a = new int[SIZE_A];
	protected int[] b = new int[SIZE_B];
	
	@Override
	public void runExercise() {
		initialize();
		a = merge(a, b);
		check();
	}
	
	private void check(){
		int size = SIZE_ACTUAL_A + SIZE_B;
		for(int i = 1; i < size; i++){
			if(a[i] < a[i - 1]){
				System.out.println("Failed");
				return;
			}
		}
		
		for(int i = size; i < SIZE_A; i++){
			if(a[i] != 0){
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("Passed");
	}
	
	private int[] merge(int[] a, int[] b){
		int idxA = SIZE_ACTUAL_A - 1;
		int idxB = b.length - 1;
		int idx = idxA + idxB + 1;
		
		while(idxA >= 0 && idxB >= 0){
			if(a[idxA] > b[idxB]){
				a[idx] = a[idxA];
				idx--;
				idxA--;
			}else{
				a[idx] = b[idxB];
				idx--;
				idxB--;
			}
		}
		
		while(idxB >= 0){
			a[idx] = b[idxB];
			idx--;
			idxB--;
		}
		
		return a;
	}
	
	private void initialize(){
		Arrays.fill(a, 0);
		
		for(int i = 0; i < SIZE_ACTUAL_A; i++){
			a[i] = (int)(Math.random() * MAXIMUM);
		}
		
		for(int i = 0; i < SIZE_B; i++){
			b[i] = (int)(Math.random() * MAXIMUM);
		}
		
		Arrays.sort(a, 0, SIZE_ACTUAL_A);
		Arrays.sort(b);
	}

}
