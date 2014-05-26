package com.cllin.cci.chap01;

import com.cllin.main.Exercise;

/*
 * Implement an algorithm to determine if a string has all unique characters.
 * What if you can not use additional data structures?
 */

public class Exercise01_01 implements Exercise {

	private final String[] testSuite = new String[]{
			null, "     ", "zzzzz", "car", "apple", "banana"};
	
	@Override
	public void runExercise() {
		for(String string : testSuite){
			printResult(string);
		}
	}
	
	/*
	 * Time Complexity = O(n ^ 2)
	 * Space Complexity = O(n)
	 */
	private boolean isAllUnique(String string) {
		if (string == null || string.length() <= 1) return true;
		
		for (int i = 0; i < string.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (string.charAt(i) == string.charAt(j)) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	/*
	 * Bit Vector Solution: Assuming characters are limited to lower-cased alphabets
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	private boolean isAllUnique(String string) {
		if (string == null || string.length() <= 1) return true;
		
		int checker = 0;
		for (int i = 0; i < string.length(); i++) {
			int value = (int) string.charAt(i) - 'a';
			if ((checker & (1 << value)) != 0) return false;
//			If exists duplicate characters, the duplicated digit will be 1 again, making checker & (1 << value) != 0 anymore
			
			checker |= (1 << value);
		}
		
		return true;
	}
	 */
	
	/*
	 * Hashtable Solution
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	private boolean isAllUnique(String string) {
		if (string == null || string.length() <= 1) return true;
		
		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < string.length(); i++) {
			if (set.contains(string.charAt(i))) {
				return false;
			} else {
				set.add(string.charAt(i));
			}
		}
		
		return true;
	}
	*/
	
	private void printResult(String string) {
		System.out.printf("%s has %s characters%n", string, (isAllUnique(string))? "all unique" : "duplicate");
	}

}
