package com.cllin.main;

import com.cllin.chap19.Exercise19_10;
import com.cllin.trie.TrieExercise;

public class Main {
	public static final int TRIE = 1;
	public static final int EX19_10 = 1910;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = EX19_10;

		switch(option){
			case TRIE:
				exercise = new TrieExercise();
				break;
			case EX19_10:
				exercise = new Exercise19_10();
				break;
		}
		
		exercise.runExercise();
	}
}
