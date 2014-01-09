package com.cllin.enumeration;

import com.cllin.main.Exercise;

public class EnumerationExercise implements Exercise {

	@Override
	public void runExercise() {
		for(Day day : Day.values()){
			System.out.printf(day.getMonkeyActivity() + " on %s%n", day.name());
		}
	}
	

	
	private enum Day {
		MONDAY("The monkey wears new clothes"),
		TUESDAY("The monkey is hungary"),
		WEDNESDAY("The monkey goes hiking"),
		THURSDAY("The monkey takes an exam"),
		FRIDAY("The monkey dances"),
		SATURDAY("The monkey does nothing"),
		SUNDAY("It's weekend, dude, the monkey does nothing");
		
		private final String activity;
		
		Day(String activity){
			this.activity = activity;
		}
		
		private String getMonkeyActivity(){
			return activity;
		}
		
	}

}
