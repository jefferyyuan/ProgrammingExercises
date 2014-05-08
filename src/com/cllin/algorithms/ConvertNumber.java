package com.cllin.algorithms;

import com.cllin.main.Exercise;

/*
 * Microsoft Excel numbers cells as 1 ... 26 and after that AA, AB, ..., AAA, AAB, ..., ZZZ and so on.
 * Given a number, convert it to that format and vice versa.
 * 
 * Source: http://www.careercup.com/question?id=6139456847347712
 */

public class ConvertNumber implements Exercise {

	@Override
	public void runExercise() {
		for (int i = 0; i < 10; i++) {
			int N = (int) (Math.random() * 20000) + 1;
			String string = numberToString(N);
			int number = stringToNumber(string);
			
			System.out.printf("%d -> %s -> %d%n", N, string, number);
		}
	}
	
	private String numberToString(int n) {
		if (n < 1) return "Out of Bound";
		if (n <= 26) return Integer.toString(n);
		n -= 26;
		
		int count = 0;
		StringBuffer buffer = new StringBuffer();
		while (n > 0 && count <= 3) {
			if (count == 3) return "Out of Bound";
			
			buffer.insert(0, mapNumberToString(n % 26));
			n /= 26;
			count++;
		}
		
		return buffer.toString();
	}
	
	private int stringToNumber(String string) {
		try {
			return Integer.parseInt(string, 10);
		} catch (NumberFormatException e) {
			
		}
		
		int index = 0;
		int number = 0;
		while (index < string.length() && index <= 3) {
			if (index == 3) return -1;
			
			number *= 26;
			number += (int) string.charAt(index) - 64;
			index++;
		}
		
		return number + 26;
	}

	private String mapNumberToString(int n) {
		return Character.toString ((char) (n + 64));
	}
}
