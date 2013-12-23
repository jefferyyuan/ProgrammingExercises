package com.cllin.chap14;

import com.cllin.main.Exercise;

public class Exercise14_02 implements Exercise {

	@Override
	public void runExercise() {
		try{
			System.out.println("Executing something that might go wrong...");
			System.out.println("...");
			System.out.println("...");
			somethingMightGoWrong();
			return;
		}catch(Exception e){
			System.out.println("An exception is caught: " + e.getMessage());
			return;
		}finally{
			System.out.println("Finally, I'm in the finally block");
		}
	}
	
	private void somethingMightGoWrong() throws Exception{
		if(getRandomBoolean()){
			return;
		}else{
			throw new Exception("Something went wrong!");
		}
	}
	
	private boolean getRandomBoolean(){
		return Math.random() < 0.5;
	}

}
