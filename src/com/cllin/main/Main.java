package com.cllin.main;

import com.cllin.algorithms.LongestCommonSubsequence;
import com.cllin.algorithms.MaximumSubarray;
import com.cllin.algorithms.RodCutting;
import com.cllin.chap07.Exercise07_02;
import com.cllin.chap07.Exercise07_05;
import com.cllin.chap08.Exercise08_01;
import com.cllin.chap08.Exercise08_02;
import com.cllin.chap08.Exercise08_03;
import com.cllin.chap08.Exercise08_04;
import com.cllin.chap08.Exercise08_05;
import com.cllin.chap08.Exercise08_06;
import com.cllin.chap08.Exercise08_07;
import com.cllin.chap08.Exercise08_08;
import com.cllin.chap09.Exercise09_01;
import com.cllin.chap09.Exercise09_02;
import com.cllin.chap09.Exercise09_03;
import com.cllin.chap09.Exercise09_05;
import com.cllin.chap09.Exercise09_06;
import com.cllin.chap09.Exercise09_07;
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
import com.cllin.tree.BinarySearchTreeExercise;
import com.cllin.trie.TrieExercise;

public class Main {
//	OPERATORS AND GENERAL PROBLEMS
	public static final int EXCLUSIVE_OR = 2;
	public static final int TERNARY = 3;
	public static final int BITWISE_OPERATION = 4;
	public static final int THREAD101 = 5;
	public static final int SYNCHRONIZATION = 6;
	public static final int DEADLOCK = 7;
	public static final int LINKEDLIST = 8;
	public static final int EXTEND_AND_SUPER = 9;
	public static final int MAXIMUM_SUBARRAY = 10;
	
//	SORTING
	public static final int INSERTIONSORT = 3000;
	public static final int MERGESORT = 3001;
	public static final int HEAPSORT = 3002;
	public static final int QUICKSORT = 3003;
	public static final int COUNTINGSORT = 3004;
	
//	DATA STRUCTURES
	public static final int TRIE = 4000;
	public static final int BINARY_SEARCH_TREE = 4001;
	public static final int ROD_CUTTING = 4002;
	public static final int LONGEST_COMMON_SUBSEQUENCE = 4003;
	
//	EXERCISES FROM "CRACKING CODING INTERVIEW"
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
	public static final int EX09_07 = 907;
	public static final int EX09_06 = 906;
	public static final int EX09_05 = 905;
	public static final int EX09_03 = 903;
	public static final int EX09_02 = 902;
	public static final int EX09_01 = 901;
	public static final int EX08_08 = 808;
	public static final int EX08_07 = 807;
	public static final int EX08_06 = 806;
	public static final int EX08_05 = 805;
	public static final int EX08_04 = 804;
	public static final int EX08_03 = 803;
	public static final int EX08_02 = 802;
	public static final int EX08_01 = 801;
	public static final int EX07_05 = 705;
	public static final int EX07_02 = 702;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = EX07_02;

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
			case EXTEND_AND_SUPER:
				exercise = new ExtendAndSuper();
				break;
			case MAXIMUM_SUBARRAY:
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
			case BINARY_SEARCH_TREE:
				exercise = new BinarySearchTreeExercise();
				break;
			case ROD_CUTTING:
				exercise = new RodCutting();
				break;
			case LONGEST_COMMON_SUBSEQUENCE:
				exercise = new LongestCommonSubsequence();
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
			case EX09_06:
				exercise = new Exercise09_06();
			case EX09_05:
				exercise = new Exercise09_05();
				break;
			case EX09_03:
				exercise = new Exercise09_03();
				break;
			case EX09_02:
				exercise = new Exercise09_02();
				break;
			case EX09_01:
				exercise = new Exercise09_01();
				break;
			case EX08_08:
				exercise = new Exercise08_08();
				break;
			case EX08_07:
				exercise = new Exercise08_07();
				break;
			case EX08_06:
				exercise = new Exercise08_06();
				break;
			case EX08_05:
				exercise = new Exercise08_05();
				break;
			case EX08_04:
				exercise = new Exercise08_04();
				break;
			case EX08_03:
				exercise = new Exercise08_03();
				break;
			case EX08_02:
				exercise = new Exercise08_02();
				break;
			case EX08_01:
				exercise = new Exercise08_01();
				break;
			case EX07_05:
				exercise = new Exercise07_05();
				break;
			case EX07_02:
				exercise = new Exercise07_02();
				break;
		}
		
		exercise.runExercise();
	}
}
