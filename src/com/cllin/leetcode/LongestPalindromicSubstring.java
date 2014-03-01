package com.cllin.leetcode;


public class LongestPalindromicSubstring implements LeetCodeExercise {

	private String[] testSuite = {
		"ccc",
		"sos",
		"abba",
		"apple",
		"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
		"bb",
		"adam",
		"aaabaaaa",
		"azwdzwmwcqzgcobeeiphemqbjtxzwkhiqpbrprocbppbxrnsxnwgikiaqutwpftbiinlnpyqstkiqzbggcsdzzjbrkfmhgtnbujzszxsycmvipjtktpebaafycngqasbbhxaeawwmkjcziybxowkaibqnndcjbsoehtamhspnidjylyisiaewmypfyiqtwlmejkpzlieolfdjnxntonnzfgcqlcfpoxcwqctalwrgwhvqvtrpwemxhirpgizjffqgntsmvzldpjfijdncexbwtxnmbnoykxshkqbounzrewkpqjxocvaufnhunsmsazgibxedtopnccriwcfzeomsrrangufkjfzipkmwfbmkarnyyrgdsooosgqlkzvorrrsaveuoxjeajvbdpgxlcrtqomliphnlehgrzgwujogxteyulphhuhwyoyvcxqatfkboahfqhjgujcaapoyqtsdqfwnijlkknuralezqmcryvkankszmzpgqutojoyzsnyfwsyeqqzrlhzbc",
		"aaaa",
		"banana",
		"ffffffggggggg",
		"321012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210012321001232100123210123210012321001232100123210123"
		};
	
	private int index;
	private String longest;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			longest = longestPalindrome(testSuite[index]);
			test();
		}
	}
	
	private String longestPalindrome(String string) {
		if (string == null) return null;
		if (string.length() == 0) return new String();
		
    	return getLongestPalindrome(string, 0, string.length() - 1);
    }
	
	private String getLongestPalindrome(String string, int start, int end) {
		if (start > end) return new String();
		if (start == end) return Character.toString(string.charAt(start));
		
		int mid = (start + end) / 2;
		
		String a1 = getLongestPalindromeAcross(string, mid);
		String a2 = getLongestPalindromeAcross(string, mid - 1);
		
		String longestAcross = (a1.length() > a2.length())? a1 : a2;
		
		if (longestAcross.length() == string.length()) return longestAcross;
		
		String longestFromLeft = getLongestPalindrome(string, start, mid);
		String longestFromRight = getLongestPalindrome(string, mid + 1, end);

		if (longestFromLeft.length() > longestFromRight.length()) {
			return (longestFromLeft.length() > longestAcross.length())? longestFromLeft : longestAcross;
		} else {
			return (longestFromRight.length() > longestAcross.length())? longestFromRight : longestAcross;
		}
	}
	
	private String getLongestPalindromeAcross(String string, int mid) {
		int length = string.length();
		if (mid < 0 || mid >= length) return new String();
		
		StringBuffer both1 = new StringBuffer(Character.toString(string.charAt(mid)));
		for (int i = 1; mid - i >= 0 && mid + i < length; i++) {
			if (string.charAt(mid - i) != string.charAt(mid + i)) break;
			
			both1.insert(0, string.charAt(mid - i));
			both1.append(string.charAt(mid - i));
		}
		
		StringBuffer both2 = new StringBuffer();
		for (int i = 0; mid - i >= 0 && mid + 1 + i < length; i++) {
			if (string.charAt(mid - i) != string.charAt(mid + 1 + i)) {
				break;
			}
			
			both2.insert(0, string.charAt(mid - i));
			both2.append(string.charAt(mid - i));
		}
		
		return (both1.length() > both2.length())? both1.toString() : both2.toString();
	}

	@Override
	public boolean test() {
		System.out.printf("The longest palindromic substring of '%s' is '%s'%n", testSuite[index], longest);
		return true;
	}

}
