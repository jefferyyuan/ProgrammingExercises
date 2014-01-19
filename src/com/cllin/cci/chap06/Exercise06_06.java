package com.cllin.cci.chap06;

import java.util.ArrayList;

import com.cllin.main.Exercise;

public class Exercise06_06 implements Exercise {
	private ArrayList<Integer> mOpenedLocker;

	@Override
	public void runExercise() {
		findOpenedLocker();
		printResult();
	}
	
	private void findOpenedLocker(){
		mOpenedLocker = new ArrayList<Integer>();
		
		for(int i = 1; i <= 100; i++){
			int count = 0;
			
			for(int j = i; j >= 1; j--){
				if (i % j == 0) count++;
			}
			
			if (count % 2 == 1) mOpenedLocker.add(i);
		}
	}
	
	private void printResult(){
		for(int n : mOpenedLocker){
			System.out.printf("The %dth locker is open%n", n);
		}
	}

}
