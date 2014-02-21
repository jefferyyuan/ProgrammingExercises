package com.cllin.leetcode;


public class LongestSubstringWithoutRepeatingCharacters implements
		LeetCodeExercise {

	private final String[] testSuite = {
			"abcabcbb",
			"bbbbb",
			"aabcd",
			"wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"
	};
	
	private int index;
	private int length;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			length = lengthOfLongestSubstring(testSuite[index]);
			test();
		}
	}
	
    private int lengthOfLongestSubstring(String string) {
    	if (string == null || string.length() == 0) return 0; 

    	int longestSubstringLength = 0;
    	int length = string.length();
    	String buffer = new String();
    	
    	for (int i = 0; i < length; i++) {
    		char c = string.charAt(i);
    		int index = buffer.indexOf(c);
    		
    		buffer = (index != -1)? buffer.substring(index + 1) + c : buffer + c;
    		longestSubstringLength = Math.max(longestSubstringLength, buffer.length());
    	}
    	
    	return longestSubstringLength;
    }

	@Override
	public boolean test() {
		System.out.printf("The length of longest substring without repeating characters of %s is %d%n", testSuite[index], length);
		return true;
	}

}
