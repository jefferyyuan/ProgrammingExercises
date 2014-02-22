package com.cllin.leetcode;

public class ZigZagConversion implements LeetCodeExercise {

	private final TestCase[] testSuite = {
			new TestCase("PAYPALISHIRING", "PAHNAPLSIIGYIR", 3),
			new TestCase("PAYPALISHIRING", "PINALSIGYAHRPI", 4),
			new TestCase("A", "A", 1),
			new TestCase("ABCDEFG", "ABCDEFG", 1),
	};
	
	private int index;
	private String result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			TestCase test = testSuite[index];
			result = convert(test.input, test.nRows);

			if (test()) System.out.println("Success");
			else System.out.println("Failed");
		}
	}
	
	private String convert(String string, int nRows) {
		if (string == null) return null;
		
		int length = string.length();
		StringBuffer buffer = new StringBuffer();
		if (length == 0 || nRows == 0) return buffer.toString();
		
		int nCols = 0;
		if (nRows == 1) {
			nCols = length;
		} else if (nRows == 2) {
			nCols = length / 2;
			if (length % 2 == 1) nCols++;
		} else {
			for (int i = 0; i < length;) {
				i = (nCols % (nRows - 1) == 0)? i + nRows : i + 1;
				nCols++;
			}
		}
		
		int count = 0;
		char[][] map = new char[nRows][nCols];
		
		for (int j = 0; j < nCols; j++) {
			if (nRows == 1 || j % (nRows - 1) == 0) {
				for (int i = 0; i < nRows && count < length; i++) {
					map[i][j] = string.charAt(count);
					count++;
				}
			} else {
				for (int i = 0; i < nRows && count < length; i++) {
					if (((nRows - 1) - i) == j % (nRows - 1)) {
						map[i][j] = string.charAt(count);
						count++;
					} else {
						map[i][j] = '\0';	
					}
				}				
			} 
		}
		
		for (int i = 0; i < nRows; i++) {
			for (int j = 0; j < nCols; j++) {
				if (map[i][j] != '\0') buffer.append(map[i][j]);
			}
		}
		
		return buffer.toString();
    }

	@Override
	public boolean test() {
		return testSuite[index].output.equals(result);
	}
	
	private class TestCase {
		String input;
		String output;
		int nRows;
		
		TestCase(String input, String output, int nRows) {
			this.input = input;
			this.output = output;
			this.nRows = nRows;
		}
	}

}
