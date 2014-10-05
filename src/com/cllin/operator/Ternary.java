package com.cllin.operator;

import com.cllin.main.Exercise;

public class Ternary implements Exercise {

	@Override
	public void run() {
		for(int i = 0; i < 10; i++){
			boolean randomBoolean = getRandomBoolean();
			String output =	randomBoolean ? "Got true" : "Got false";
			System.out.println(output);
		}
	}

	private boolean getRandomBoolean(){
		return Math.random() < 0.5;
	}
	
}
