package com.cllin.chap05;

import com.cllin.main.Exercise;

public class Exercise05_05 implements Exercise {

	@Override
	public void runExercise() {
		int x;
		int y;
		
		x = 31;
		y = 14;
		System.out.printf("It takes %d bits to convert %d to %d%n", getBitsToConvert(x, y), x, y);
		
		x = 56;
		y = 17;
		System.out.printf("It takes %d bits to convert %d to %d%n", getBitsToConvert(x, y), x, y);
		
		x = 132;
		y = 63;
		System.out.printf("It takes %d bits to convert %d to %d%n", getBitsToConvert(x, y), x, y);
	}
	
	private int getBitsToConvert(int x, int y){
		int count = 0;
		
		while(x != 0 || y != 0){
			if ((x % 2 ^ y % 2) == 1) count++;
			
			x >>= 1;
			y >>= 1;
		}
		
		return count;
	}

}
