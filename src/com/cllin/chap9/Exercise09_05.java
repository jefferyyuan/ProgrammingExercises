package com.cllin.chap9;

import com.cllin.main.Exercise;

public class Exercise09_05 implements Exercise {
	private final String empty = "";
	private final String apple = "apple";
	private final String banana = "banana";
	private final String book = "book";
	private final String candy = "candy";
	private final String car = "car";
	private final String dog = "dog";
	private final String elephant = "elephant";
	private final String[] array = {apple, empty, empty, empty, banana, candy, empty, dog, empty, empty, elephant, empty};
	private final String[] testSuites = {apple, banana, book, candy, car, dog, elephant};
	
	@Override
	public void runExercise() {
		for(String string : testSuites){
			int key = findString(string);
			if(key == -1){
				System.out.println(string + " cannot be found");
			}else{
				System.out.println(string + " is found at #" + key);
			}
		}

	}
	
	private int findString(String string){
		int length = array.length;
		for(int i = 0; i < length; i++){
			if(array[i].equals(string)) return i;
		}
		return -1;
	}

}
