package com.cllin.cci.chap11;

import com.cllin.main.Exercise;

public class Exercise11_01 implements Exercise {

	@Override
	public void runExercise() {
		testedMethod();
		System.out.println("Finished");
	}
	
	private void testedMethod(){
		long i;
		for(i = 100; i <= 0; --i){
			System.out.println(i);
		}
	}

}
