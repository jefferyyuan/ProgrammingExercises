package com.cllin.chap19;

import com.cllin.main.Exercise;

public class Exercise19_05 implements Exercise {
	private static final char[] slots = {'R', 'R', 'G', 'B'};
	
	@Override
	public void runExercise() {
		char[] guess_1 = {'B', 'R', 'G', 'B'};
		char[] guess_2 = {'B', 'R', 'G', 'Y'};
		char[] guess_3 = {'B', 'G', 'Y', 'B'};
		char[] guess_4 = {'B', 'B', 'B', 'R'};
		System.out.println(guess(guess_1));
		System.out.println(guess(guess_2));
		System.out.println(guess(guess_3));
		System.out.println(guess(guess_4));
	}
	
	private String guess(char[] guess){
		String output = "The guess {" + new String(guess) + "} ";
		int hits = 0;
		int pseudoHits = 0;
		
		boolean[] hit = new boolean[4];
		boolean[] isHit = new boolean[4];
		
		for(int i = 0; i < guess.length; i++){
			if(guess[i] == slots[i]){
				hits++;
				hit[i] = true;
				isHit[i] = true;
			}
		}
		
//		XXX O(n^2) BAD PERFORMANCE
		for(int i = 0; i < guess.length; i++){
			for(int j = 0; j < guess.length; j++){
				if(!hit[i] && !isHit[j] && guess[i] == slots[j]){
					hit[i] = true;
					isHit[j] = true;
					pseudoHits++;
				}
			}
		}
		
		output += hits + " hits and " + pseudoHits + " pseudo hits";
		
		return output;
	}

}
