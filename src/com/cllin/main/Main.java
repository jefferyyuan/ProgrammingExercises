package com.cllin.main;

import com.cllin.chap19.Exercise19_03;
import com.cllin.chap19.Exercise19_05;
import com.cllin.chap19.Exercise19_08;
import com.cllin.chap19.Exercise19_10;
import com.cllin.trie.TrieExercise;

public class Main {
	public static final int TRIE = 1;
	public static final int EX19_10 = 1910;
	public static final int EX19_08 = 1908;
	public static final int EX19_05 = 1905;
	public static final int EX19_03 = 1903;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = EX19_03;

		switch(option){
			case TRIE:
				exercise = new TrieExercise();
				break;
			case EX19_10:
				exercise = new Exercise19_10();
				break;
			case EX19_08:
				exercise = new Exercise19_08();
				break;
			case EX19_05:
				exercise = new Exercise19_05();
				break;
			case EX19_03:
				exercise = new Exercise19_03();
				break;
		}
		
		exercise.runExercise();
	}
}
