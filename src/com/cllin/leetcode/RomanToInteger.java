package com.cllin.leetcode;

import java.util.ArrayList;

public class RomanToInteger implements LeetCodeExercise {
	private ArrayList<String> testSuites;
	private ArrayList<Integer> answers;
	private ArrayList<Integer> results;

	@Override
	public void initialize() {
		testSuites = new ArrayList<String>();
		answers = new ArrayList<Integer>();
		results = new ArrayList<Integer>();
		
		testSuites.add("I");
		testSuites.add("VI");
		testSuites.add("IV");
		testSuites.add("VII");
		testSuites.add("IX");
		testSuites.add("XI");
		testSuites.add("CXI");
		testSuites.add("XXXVI");
		testSuites.add("CXIV");
		testSuites.add("cXv");
		testSuites.add("dccXI");
		testSuites.add("MdXxxvi");
		testSuites.add("DLXXXI");
		testSuites.add("MCCCXXXIV");
		testSuites.add("MMMDCCCCLXXXXIX");
		testSuites.add("MCMXCVI");
		
		answers.add(1);
		answers.add(6);
		answers.add(4);
		answers.add(7);
		answers.add(9);
		answers.add(11);
		answers.add(111);
		answers.add(36);
		answers.add(114);
		answers.add(115);
		answers.add(711);
		answers.add(1536);
		answers.add(581);
		answers.add(1334);
		answers.add(3999);
		answers.add(1996);
		
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (String string : testSuites) {
			results.add(romanToInt(string));
		}
		
		if (test()) System.out.println("Success");
		else System.out.println("Failed");
	}
	
    private int romanToInt(String s) {
    	int length = s.length();
    	if (length <= 0) return 0;
    	int output = 0;
    	s = s.toUpperCase();
    	
        if (s.contains("CM")) {
        	s = s.replace("CM", "");
        	output += 900;
        }
        
        if (s.contains("CD")) {
        	s = s.replace("CD", "");
        	output += 400;
        }
        
        if (s.contains("XC")) {
        	s = s.replace("XC", "");
        	output += 90;
        }
        
        if (s.contains("XL")) {
        	s = s.replace("XL", "");
        	output += 40;
        }
    	
        if (s.contains("IX")) {
        	s = s.replace("IX", "");
        	output += 9;
        }
        
        if (s.contains("IV")) {
        	s = s.replace("IV", "");
        	output += 4;
        }
        
        int m = s.lastIndexOf('M');
        int d = s.lastIndexOf('D');
        int c = s.lastIndexOf('C');
        int l = s.lastIndexOf('L');
        int x = s.lastIndexOf('X');
        int v = s.lastIndexOf('V');
        int i = s.lastIndexOf('I');
        
        if (m != -1) {
        	if (m != length - 1) output += s.substring(0, m + 1).length() * 1000;
        	else output += s.substring(0).length() * 1000;
        }
        
        if (d != -1) {
        	if (d != length - 1) output += s.substring(s.indexOf('D'), d + 1).length() * 500;
        	else output += s.substring(s.indexOf('D')).length() * 500;
        }
        
        if (c != -1) {
        	if (c != length - 1) output += s.substring(s.indexOf('C'), c + 1).length() * 100;
        	else output += s.substring(s.indexOf('C')).length() * 100;
        }
        
        if (l != -1) {
        	if (l != length - 1) output += s.substring(s.indexOf('L'), l + 1).length() * 50;
        	else output += s.substring(s.indexOf('L')).length() * 50;
        }
        
        if (x != -1) {
        	if (x != length - 1) output += s.substring(s.indexOf('X'), x + 1).length() * 10;
        	else output += s.substring(s.indexOf('X')).length() * 10;
        }
        
        if (v != -1) {
        	if (v != length - 1) output += s.substring(s.indexOf('V'), v + 1).length() * 5;
        	else output += s.substring(s.indexOf('V')).length() * 5;
        }
        
        if (i != -1) {
        	if (i != length - 1) output += s.substring(s.indexOf('I'), i + 1).length();
        	else output += s.substring(s.indexOf('I')).length();
        }
        
        return output;
    }

	@Override
	public boolean test() {
		for (int i = 0; i < results.size(); i++) {
			if (results.get(i).intValue() != answers.get(i).intValue()) {
				System.out.printf("%s is translated to %d, while it should be %d%n", 
						testSuites.get(i), results.get(i), answers.get(i));
				return false; 
			}
			
			System.out.printf("%s is translated to %d, just as expected%n", 
					testSuites.get(i), results.get(i));
		}
		
		return true;
	}

}
