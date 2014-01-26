package com.cllin.main;

import com.cllin.algorithms.BreadthFirstTraversal;
import com.cllin.algorithms.LongestCommonSubsequence;
import com.cllin.algorithms.MaximumSubarray;
import com.cllin.algorithms.RodCutting;
import com.cllin.cci.chap01.Exercise01_01;
import com.cllin.cci.chap01.Exercise01_02;
import com.cllin.cci.chap01.Exercise01_03;
import com.cllin.cci.chap01.Exercise01_04;
import com.cllin.cci.chap01.Exercise01_05;
import com.cllin.cci.chap01.Exercise01_06;
import com.cllin.cci.chap01.Exercise01_07;
import com.cllin.cci.chap01.Exercise01_08;
import com.cllin.cci.chap02.Exercise02_01;
import com.cllin.cci.chap02.Exercise02_02;
import com.cllin.cci.chap02.Exercise02_03;
import com.cllin.cci.chap02.Exercise02_04;
import com.cllin.cci.chap02.Exercise02_05;
import com.cllin.cci.chap03.Exercise03_01;
import com.cllin.cci.chap03.Exercise03_02;
import com.cllin.cci.chap03.Exercise03_03;
import com.cllin.cci.chap03.Exercise03_04;
import com.cllin.cci.chap03.Exercise03_05;
import com.cllin.cci.chap03.Exercise03_06;
import com.cllin.cci.chap04.Exercise04_03;
import com.cllin.cci.chap04.Exercise04_04;
import com.cllin.cci.chap04.Exercise04_05;
import com.cllin.cci.chap04.Exercise04_06;
import com.cllin.cci.chap04.Exercise04_07;
import com.cllin.cci.chap04.Exercise04_08;
import com.cllin.cci.chap05.Exercise05_01;
import com.cllin.cci.chap05.Exercise05_02;
import com.cllin.cci.chap05.Exercise05_03;
import com.cllin.cci.chap05.Exercise05_05;
import com.cllin.cci.chap05.Exercise05_06;
import com.cllin.cci.chap06.Exercise06_03;
import com.cllin.cci.chap06.Exercise06_06;
import com.cllin.cci.chap07.Exercise07_02;
import com.cllin.cci.chap07.Exercise07_05;
import com.cllin.cci.chap08.Exercise08_01;
import com.cllin.cci.chap08.Exercise08_02;
import com.cllin.cci.chap08.Exercise08_03;
import com.cllin.cci.chap08.Exercise08_04;
import com.cllin.cci.chap08.Exercise08_05;
import com.cllin.cci.chap08.Exercise08_06;
import com.cllin.cci.chap08.Exercise08_07;
import com.cllin.cci.chap08.Exercise08_08;
import com.cllin.cci.chap09.Exercise09_01;
import com.cllin.cci.chap09.Exercise09_02;
import com.cllin.cci.chap09.Exercise09_03;
import com.cllin.cci.chap09.Exercise09_05;
import com.cllin.cci.chap09.Exercise09_06;
import com.cllin.cci.chap09.Exercise09_07;
import com.cllin.cci.chap10.Exercise10_03;
import com.cllin.cci.chap10.Exercise10_07;
import com.cllin.cci.chap11.Exercise11_01;
import com.cllin.cci.chap14.Exercise14_01;
import com.cllin.cci.chap14.Exercise14_02;
import com.cllin.cci.chap14.Exercise14_03;
import com.cllin.cci.chap14.Exercise14_04;
import com.cllin.cci.chap14.Exercise14_05;
import com.cllin.cci.chap19.Exercise19_01;
import com.cllin.cci.chap19.Exercise19_03;
import com.cllin.cci.chap19.Exercise19_05;
import com.cllin.cci.chap19.Exercise19_08;
import com.cllin.cci.chap19.Exercise19_10;
import com.cllin.enumeration.EnumerationExercise;
import com.cllin.inheritance.ExtendAndSuper;
import com.cllin.leetcode.BalancedBinaryTree;
import com.cllin.leetcode.BestTimeToBuyAndSellStock;
import com.cllin.leetcode.BestTimetoBuyandSellStockII;
import com.cllin.leetcode.BinaryTreeInorderTraversal;
import com.cllin.leetcode.ClimbingStairs;
import com.cllin.leetcode.ConvertSortedArrayToBinarySearchTree;
import com.cllin.leetcode.GrayCode;
import com.cllin.leetcode.IntegerToRoman;
import com.cllin.leetcode.LinkedListCycle;
import com.cllin.leetcode.MaximumDepthOfBinaryTree;
import com.cllin.leetcode.MergeSortedArray;
import com.cllin.leetcode.MergeTwoSortedLists;
import com.cllin.leetcode.PascalsTriangle;
import com.cllin.leetcode.Permutations;
import com.cllin.leetcode.PopulatingNextRightPointers;
import com.cllin.leetcode.RemoveDuplicatesFromSortedArray;
import com.cllin.leetcode.RemoveDuplicatesFromSortedList;
import com.cllin.leetcode.RemoveElement;
import com.cllin.leetcode.ReverseInteger;
import com.cllin.leetcode.RomanToInteger;
import com.cllin.leetcode.SameTree;
import com.cllin.leetcode.SearchInsertPosition;
import com.cllin.leetcode.SingleNumber;
import com.cllin.leetcode.SingleNumberII;
import com.cllin.leetcode.SwapNodesInPairs;
import com.cllin.leetcode.SymmetricTree;
import com.cllin.leetcode.UniqueBinarySearchTrees;
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
	public static final int ENUMERATION = 11;
	public static final int Breadth_First_Traversal = 12;
	
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
	public static final int EX06_06 = 606;
	public static final int EX06_03 = 603;
	public static final int EX05_06 = 506;
	public static final int EX05_05 = 505;
	public static final int EX05_03 = 503;
	public static final int EX05_02 = 502;
	public static final int EX05_01 = 501;
	public static final int EX04_08 = 408;
	public static final int EX04_07 = 407;
	public static final int EX04_06 = 406;
	public static final int EX04_05 = 405;
	public static final int EX04_04 = 404;
	public static final int EX04_03 = 403;
	public static final int EX03_06 = 306;
	public static final int EX03_05 = 305;
	public static final int EX03_04 = 304;
	public static final int EX03_03 = 303;
	public static final int EX03_02 = 302;
	public static final int EX03_01 = 301;
	public static final int EX02_05 = 205;
	public static final int EX02_04 = 204;
	public static final int EX02_03 = 203;
	public static final int EX02_02 = 202;
	public static final int EX02_01 = 201;
	public static final int EX01_08 = 108;
	public static final int EX01_07 = 107;
	public static final int EX01_06 = 106;
	public static final int EX01_05 = 105;
	public static final int EX01_04 = 104;
	public static final int EX01_03 = 103;
	public static final int EX01_02 = 102;
	public static final int EX01_01 = 101;
	
//	EXERCISES FROM LEETCODE
	public static final int MaximumDepthOfBinaryTree = 5001;
	public static final int SingleNumber = 5002;
	public static final int SameTree = 5003;
	public static final int ReverseInteger = 5004;
	public static final int BestTimetoBuyandSellStockII = 5005;
	public static final int UniqueBinarySearchTrees = 5006;
	public static final int LinkedListCycle = 5007;
	public static final int PopulatingNextRightPointers = 5008;
	public static final int SearchInsertPosition = 5009;
	public static final int RemoveDuplicatesFromSortedList = 5010;
	public static final int BinaryTreeInorderTraversal = 5011;
	public static final int RemoveElement = 5012;
	public static final int RemoveDuplicatesFromSortedArray = 5013;
	public static final int MaximumSubarray = 5014;
	public static final int ClimbingStairs = 5015;
	public static final int RomanToInteger = 5016;
	public static final int MergeTwoSortedLists = 5017;
	public static final int SymmetricTree = 5018;
	public static final int MergeSortedArray = 5019;
	public static final int ConvertSortedArrayToBinarySearchTree = 5020;
	public static final int SwapNodesInPairs = 5021;
	public static final int IntegerToRoman = 5022;
	public static final int PascalsTriangle = 5023;
	public static final int BalancedBinaryTree = 5024;
	public static final int SingleNumberII = 5025;
	public static final int BestTimeToBuyAndSellStock = 5026;
	public static final int GrayCode = 5027;
	public static final int Permutations = 5028;
	
	public static void main(String args[]){
		Exercise exercise = null;;
		
		int option = Permutations;

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
			case ENUMERATION:
				exercise = new EnumerationExercise();
				break;
			case Breadth_First_Traversal:
				exercise = new BreadthFirstTraversal();
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
			case EX06_06:
				exercise = new Exercise06_06();
				break;
			case EX06_03:
				exercise = new Exercise06_03();
				break;
			case EX05_06:
				exercise = new Exercise05_06();
				break;
			case EX05_05:
				exercise = new Exercise05_05();
				break;
			case EX05_03:
				exercise = new Exercise05_03();
				break;
			case EX05_02:
				exercise = new Exercise05_02();
				break;
			case EX05_01:
				exercise = new Exercise05_01();
				break;
			case EX04_08:
				exercise = new Exercise04_08();
				break;
			case EX04_07:
				exercise = new Exercise04_07();
				break;
			case EX04_06:
				exercise = new Exercise04_06();
				break;
			case EX04_05:
				exercise = new Exercise04_05();
				break;
			case EX04_04:
				exercise = new Exercise04_04();
				break;
			case EX04_03:
				exercise = new Exercise04_03();
				break;
			case EX03_06:
				exercise = new Exercise03_06();
				break;
			case EX03_05:
				exercise = new Exercise03_05();
				break;
			case EX03_04:
				exercise = new Exercise03_04();
				break;
			case EX03_03:
				exercise = new Exercise03_03();
				break;
			case EX03_02:
				exercise = new Exercise03_02();
				break;
			case EX03_01:
				exercise = new Exercise03_01();
				break;
			case EX02_05:
				exercise = new Exercise02_05();
				break;
			case EX02_04:
				exercise = new Exercise02_04();
				break;
			case EX02_03:
				exercise = new Exercise02_03();
				break;
			case EX02_02:
				exercise = new Exercise02_02();
				break;
			case EX02_01:
				exercise = new Exercise02_01();
				break;
			case EX01_08:
				exercise = new Exercise01_08();
				break;
			case EX01_07:
				exercise = new Exercise01_07();
				break;
			case EX01_06:
				exercise = new Exercise01_06();
				break;
			case EX01_05:
				exercise = new Exercise01_05();
				break;
			case EX01_04:
				exercise = new Exercise01_04();
				break;
			case EX01_03:
				exercise = new Exercise01_03();
				break;
			case EX01_02:
				exercise = new Exercise01_02();
				break;
			case EX01_01:
				exercise = new Exercise01_01();
				break;
			case MaximumDepthOfBinaryTree:
				exercise = new MaximumDepthOfBinaryTree();
				break;
			case SingleNumber:
				exercise = new SingleNumber();
				break;
			case SameTree:
				exercise = new SameTree();
				break;
			case ReverseInteger:
				exercise = new ReverseInteger();
				break;
			case BestTimetoBuyandSellStockII:
				exercise = new BestTimetoBuyandSellStockII();
				break;
			case UniqueBinarySearchTrees:
				exercise = new UniqueBinarySearchTrees();
				break;
			case LinkedListCycle:
				exercise = new LinkedListCycle();
				break;
			case PopulatingNextRightPointers:
				exercise = new PopulatingNextRightPointers();
				break;
			case SearchInsertPosition:
				exercise = new SearchInsertPosition();
				break;
			case RemoveDuplicatesFromSortedList:
				exercise = new RemoveDuplicatesFromSortedList();
				break;
			case BinaryTreeInorderTraversal:
				exercise = new BinaryTreeInorderTraversal();
				break;
			case RemoveElement:
				exercise = new RemoveElement();
				break;
			case RemoveDuplicatesFromSortedArray:
				exercise = new RemoveDuplicatesFromSortedArray();
				break;
			case MaximumSubarray:
				exercise = new com.cllin.leetcode.MaximumSubarray();
				break;
			case ClimbingStairs:
				exercise = new ClimbingStairs();
				break;
			case RomanToInteger:
				exercise = new RomanToInteger();
				break;
			case MergeTwoSortedLists:
				exercise = new MergeTwoSortedLists();
				break;
			case SymmetricTree:
				exercise = new SymmetricTree();
				break;
			case MergeSortedArray:
				exercise = new MergeSortedArray();
				break;
			case ConvertSortedArrayToBinarySearchTree:
				exercise = new ConvertSortedArrayToBinarySearchTree();
				break;
			case SwapNodesInPairs:
				exercise = new SwapNodesInPairs();
				break;
			case IntegerToRoman:
				exercise = new IntegerToRoman();
				break;
			case PascalsTriangle:
				exercise = new PascalsTriangle();
				break;
			case BalancedBinaryTree:
				exercise = new BalancedBinaryTree();
				break;
			case SingleNumberII:
				exercise = new SingleNumberII();
				break;
			case BestTimeToBuyAndSellStock:
				exercise = new BestTimeToBuyAndSellStock();
				break;
			case GrayCode:
				exercise = new GrayCode();
				break;
			case Permutations:
				exercise = new Permutations();
				break;
		}
		
		exercise.runExercise();
	}
}
