package com.cllin.main;

import com.cllin.algorithms.MaximumSubarray;
import com.cllin.chap10.Exercise10_03;
import com.cllin.chap10.Exercise10_07;
import com.cllin.chap11.Exercise11_01;
import com.cllin.chap14.Exercise14_01;
import com.cllin.chap14.Exercise14_02;
import com.cllin.chap14.Exercise14_03;
import com.cllin.chap14.Exercise14_04;
import com.cllin.chap14.Exercise14_05;
import com.cllin.chap19.Exercise19_01;
import com.cllin.chap19.Exercise19_03;
import com.cllin.chap19.Exercise19_05;
import com.cllin.chap19.Exercise19_08;
import com.cllin.chap19.Exercise19_10;
import com.cllin.chap9.Exercise09_07;
import com.cllin.inheritance.ExtendAndSuper;
import com.cllin.list.LinkedListExercise;
import com.cllin.operator.BitwiseOperation;
import com.cllin.operator.ExclusiveOR;
import com.cllin.operator.Ternary;
import com.cllin.sort.CountingSort;
import com.cllin.sort.HeapSort;
import com.cllin.sort.InsertionSort;
import com.cllin.sort.MergeSort;
import com.cllin.sort.QuickSort;
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
	public static final int EXTENDANDSUPER = 9;
	public static final int MAXIMUMSUBARRAY = 10;
	
	public static final int INSERTIONSORT = 3000;
	public static final int MERGESORT = 3001;
	public static final int HEAPSORT = 3002;
	public static final int QUICKSORT = 3003;
	public static final int COUNTINGSORT = 3004;
	
	public static final int EX19_10 = 1910;
	public static final int EX19_08 = 1908;
	public static final int EX19_05 = 1905;
	public static final int EX19_03 = 1903;
	public static final int EX19_01 = 1901;
	public static final int EX14_05 = 1405;
	public static final int EX14_04 = 1404;
	public static final int EX14_03 = 1403;
	public static final int EX14_02 = 1402;
	public static final int EX14_01 = 1401;
	public static final int EX11_01 = 1101;
	public static final int EX10_07 = 1007;
	public static final int EX10_03 = 1003;
	public static final int EX09_07 = 903;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = EX09_07;

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
			case EXTENDANDSUPER:
				exercise = new ExtendAndSuper();
				break;
			case MAXIMUMSUBARRAY:
				exercise = new MaximumSubarray();
				break;
			case INSERTIONSORT:
				exercise = new InsertionSort();
				break;
			case MERGESORT:
				exercise = new MergeSort();
				break;
			case HEAPSORT:
				exercise = new HeapSort();
				break;
			case QUICKSORT:
				exercise = new QuickSort();
				break;
			case COUNTINGSORT:
				exercise = new CountingSort();
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
			case EX14_05:
				exercise = new Exercise14_05();
				break;
			case EX14_04:
				exercise = new Exercise14_04();
				break;
			case EX14_03:
				exercise = new Exercise14_03();
				break;
			case EX14_02:
				exercise = new Exercise14_02();
				break;
			case EX14_01:
				exercise = new Exercise14_01();
				break;
			case EX11_01:
				exercise = new Exercise11_01();
				break;
			case EX10_07:
				exercise = new Exercise10_07();
				break;
			case EX10_03:
				exercise = new Exercise10_03();
				break;
			case EX09_07:
				exercise = new Exercise09_07();
				break;
		}
		
		exercise.runExercise();
	}
}
