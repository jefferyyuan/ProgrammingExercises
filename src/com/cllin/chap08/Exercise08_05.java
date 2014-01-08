package com.cllin.chap08;

import com.cllin.main.Exercise;

public class Exercise08_05 implements Exercise {
	private final int[] testSuite = {0, 1, 2, 3, 4, 5};
	
	@Override
	public void runExercise() {
		for(int n : testSuite){
			System.out.println("For " + n + " parenthese,");
			char[] string = new char[2 * n];
			printParenthese(n, n, string, 0);
		}
	}
	
	private void printParenthese(int left, int right, char[] string, int count){
		if (left < 0 || right < left) return;
		
		if(left == 0 && right == 0){
			System.out.println("\t" + new String(string));
			return;
		}else{
			if(left > 0){
				string[count] = '(';
				printParenthese(left - 1, right, string, count + 1);
			}
			if(right > left){
				string[count] = ')';
				printParenthese(left, right - 1, string, count + 1);
			}
		}
	}


}
