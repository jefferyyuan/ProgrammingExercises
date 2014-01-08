package com.cllin.chap09;

import com.cllin.main.Exercise;

public class Exercise09_07 implements Exercise {
	private final int CIRCUS_SIZE = 10;
	private Person[] circus;
	
	
	@Override
	public void runExercise() {
		initialization();
//		TODO
	}
	
	private void initialization(){
		circus = new Person[CIRCUS_SIZE];
		for(int i = 0; i < CIRCUS_SIZE; i++){
			circus[i] = new Person();
		}
	}

	private int personID = 0;
	private class Person{
		private static final int MAXIMUM_HEIGHT = 200;
		private static final int MINIMUM_HEIGHT = 160;
		private static final int MAXIMUM_WEIGHT = 100;
		private static final int MINIMUM_WEIGHT = 60;
		
		private int height;
		private int weight;
		private int id;
		
		public Person(){
			height = (int)(Math.random() * (MAXIMUM_HEIGHT - MINIMUM_HEIGHT)) + MINIMUM_HEIGHT;
			weight = (int)(Math.random() * (MAXIMUM_WEIGHT - MINIMUM_WEIGHT)) + MINIMUM_WEIGHT;
			id = personID;
			
			personID++;
		}
	}
}
