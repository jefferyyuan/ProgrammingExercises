package com.cllin.operator;

import com.cllin.main.Exercise;

public class ExclusiveOR implements Exercise {

	@Override
	public void runExercise() {
		for(int i = 0; i < 10; i++){
			boolean a = getRandomBoolean();
			boolean b = getRandomBoolean();
			if(operator(a, b) != ifStatement(a, b)){
				System.out.println("Failed");
				return;
			}
		}
		System.out.println("Passed");
	}
	
	private boolean operator(boolean a, boolean b){
		return a ^ b;
	}
	
	private boolean ifStatement(boolean a, boolean b){
		return !(a == b);
	}
	
	private boolean getRandomBoolean(){
		return Math.random() < 0.5;
	}

}
