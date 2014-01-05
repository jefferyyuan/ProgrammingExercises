package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class LongestCommonSubsequence implements Exercise {
	private final String sequence1 = "how did you do it";
	private final String sequence2 = "zoe, how did you ask jack to do it";
	private final int length1 = sequence1.length();
	private final int length2 = sequence2.length();
	
	private int[][] states;
	private static final int UPPERLEFT = 10;
	private static final int UP = 1;
	private static final int LEFT = 2;
	
	@Override
	public void runExercise() {
		getLCSubsequenceLength();
		
		System.out.println("The Longest Common Subsequence is:");
		printLCS(length1, length2);
		
		String longestCommonSubstring = getLCSubstring();
		System.out.println("\n\nThe Longest Common Substring is:");
		System.out.println(longestCommonSubstring);
	}
	
	private void printLCS(int i, int j){
		if (i < 1 || j < 1) return;
//		if (i < length1 || j < length2) return;
		
		if(states[i][j] == UPPERLEFT){
			printLCS(i - 1, j - 1);
			System.out.print(sequence1.charAt(i - 1));
		}else if(states[i][j] == UP){
			printLCS(i - 1, j);
		}else{
			printLCS(i, j - 1);
		}
	}
	
	private void getLCSubsequenceLength(){
		int[][] length = new int[length1 + 1][length2 + 1];
		states = new int[length1 + 1][length2 + 1];
		
		for(int i = 0; i < length1; i++){
			length[i][0] = 0;
		}
		
		for(int j = 0; j < length2; j++){
			length[0][j] = 0;
		}
		
		for(int i = 1; i < length1 + 1; i++){
			for(int j = 1; j < length2 + 1; j++){
				if(sequence1.charAt(i - 1) ==  sequence2.charAt(j - 1)){
					length[i][j] = length[i - 1][j - 1] + 1;
					states[i][j] = UPPERLEFT;
				}else if(length[i - 1][j] >= length[i][j - 1]){
					length[i][j] = length[i - 1][j];
					states[i][j] = UP;
				}else{
					length[i][j] = length[i][j - 1];
					states[i][j] = LEFT;
				}
			}
		}
	}
	
	private String getLCSubstring(){
		String longestCommonSubstring = new String();
		int longest = 0;
		int[][] length = new int[length1 + 1][length2 + 1];
		states = new int[length1 + 1][length2 + 1];
		
		for(int i = 0; i < length1; i++){
			length[i][0] = 0;
		}
		
		for(int j = 0; j < length2; j++){
			length[0][j] = 0;
		}
		
		for(int i = 1; i < length1 + 1; i++){
			for(int j = 1; j < length2 + 1; j++){
				if(sequence1.charAt(i - 1) ==  sequence2.charAt(j - 1)){
					if(i == 1 || j == 1){
						length[i][j] = 1;
					}else{
						length[i][j] = length[i - 1][j - 1] + 1;
					}
					
					if(length[i][j] > longest){
						longest = length[i][j];
						longestCommonSubstring = sequence1.substring(i - longest, i);
					}else if(length[i][j] == longest){
//						longestCommonSubstring = longestCommonSubstring OR sequence1.substring(i - longest + 1, i);
					}
				}else{
					length[i][j] = 0;
				}
			}
		}
		return longestCommonSubstring;
	}
}
