package com.cllin.cci.chap10;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class Exercise10_07 implements Exercise {
	private final int[] testSuite = {1, 5, 6, 2, 3, 8, 30, 44, 27, 69, 56, 44, 73, 79, 81, 89, 94, 123, 183, 192, 448, 767};
	
	private ArrayList<Integer> dummyList;

	@Override
	public void runExercise() {

//		DUMMY WAY
		int maximum = 1000000;
		buildList(maximum);
		
		for(int i : testSuite){
			try{
				System.out.println("The " + i + "th element is " + dummyList.get(i));
			} catch (Exception e) {
				System.out.println("The " + i + "th element is out of bound");
			}
		}
		
	}
	
	private void buildList(int max){
		dummyList= new ArrayList<Integer>();
		dummyList.add(105);
		for(int i = 105; i < max; i++){
			if (isValid(i)) dummyList.add(i);
		}
	}
	
	private boolean isValid(int i){
		if(i % 105 != 0) return false;
		
		while (i % 3 == 0) i /= 3;
		while (i % 5 == 0) i /= 5;
		while (i % 7 == 0) i /= 7;
		
		return (i == 1)? true : false;
	}

}
