package com.cllin.chap08;

import com.cllin.main.Exercise;

public class Exercise08_02 implements Exercise {
	private final int[] testSuite = {2, 4, 6, 8, 10, 15, 20};
	
	@Override
	public void runExercise() {
		for(int n : testSuite){
			int nRoutes = getRouteNumber(n, 0, 0);
			System.out.println("There are " + nRoutes + " routes for a squre grid with size " + n);
		}
		
	}
	
	private int getRouteNumber(int size, int x, int y){
		if (isRestricted(x, y)) return 0;
		if (x == size || y == size) return 1;
		
		int count = 0;
		count += getRouteNumber(size, x + 1, y);
		count += getRouteNumber(size, x, y + 1);
		
		return count;
	}
	
	private boolean isRestricted(int x, int y){
		return false;
	}

}
