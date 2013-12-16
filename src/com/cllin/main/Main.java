package com.cllin.main;

import com.cllin.chap19.Exercise19_01;
import com.cllin.chap19.Exercise19_03;
import com.cllin.chap19.Exercise19_05;
import com.cllin.chap19.Exercise19_08;
import com.cllin.chap19.Exercise19_10;
import com.cllin.list.LinkedListExercise;
import com.cllin.operator.BitwiseOperation;
import com.cllin.operator.ExclusiveOR;
import com.cllin.operator.Ternary;
import com.cllin.thread.Deadlock;
import com.cllin.thread.Synchronization;
import com.cllin.thread.Thread101;
import com.cllin.trie.TrieExercise;

public class Main {
	public static final int TRIE = 1;
	public static final int EXCLUSIVE_OR = 2;
	public static final int TERNARY = 3;
	public static final int BITWISE_OPERATION = 4;
	public static final int THREAD101 = 5;
	public static final int SYNCHRONIZATION = 6;
	public static final int DEADLOCK = 7;
	public static final int LINKEDLIST = 8;
	public static final int EX19_10 = 1910;
	public static final int EX19_08 = 1908;
	public static final int EX19_05 = 1905;
	public static final int EX19_03 = 1903;
	public static final int EX19_01 = 1901;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = LINKEDLIST;

		switch(option){
			case TRIE:
				exercise = new TrieExercise();
				break;
			case EXCLUSIVE_OR:
				exercise = new ExclusiveOR();
				break;
			case TERNARY:
				exercise = new Ternary();
				break;
			case BITWISE_OPERATION:
				exercise = new BitwiseOperation();
				break;
			case THREAD101:
				exercise = new Thread101();
				break;
			case SYNCHRONIZATION:
				exercise = new Synchronization();
				break;
			case DEADLOCK:
				exercise = new Deadlock();
				break;
			case LINKEDLIST:
				exercise = new LinkedListExercise();
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
			case EX19_01:
				exercise = new Exercise19_01();
				break;
		}
		
		exercise.runExercise();
	}
}
