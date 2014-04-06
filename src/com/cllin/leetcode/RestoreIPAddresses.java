package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * 
 * Source: http://oj.leetcode.com/problems/restore-ip-addresses/
 */

public class RestoreIPAddresses implements LeetCodeExercise {

	private final String[] testSuite = {
			"25525511135",
			"010010"
	};
	
	private int index;
	private ArrayList<String> result;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			result = restoreIpAddresses(testSuite[index]);
			test();
		}
	}
	
	private ArrayList<String> restoreIpAddresses(String string) {
		if (string == null || string.length() < 4 || string.length() > 12) return new ArrayList<String>();
    	return getAddresses(string, 1);
    }
	
	private ArrayList<String> getAddresses(String string, int level) {
		ArrayList<String> addresses = new ArrayList<String>();
		if (level > 4 || string.length() < 1) return addresses;
		
		if (level == 4) {
			if (isValidAddress(string)) {
				addresses.add(string);
			}
			return addresses;
		}
		
		for (int i = 1; i <= 3 && i <= string.length(); i++) {
			ArrayList<String> addr = new ArrayList<String>();
			String address = string.substring(0, i);
			
			if (isValidAddress(address)) {
				addr = getAddresses(string.substring(i), level + 1);
				
				int size = addr.size();
				for (int p = 0; p < size; p++) {
					String s = address + "." + addr.get(p);
					addr.set(p, s);
				}
				
				addresses.addAll(addr);
			}
		}
		
		return addresses;
	}
	
	private boolean isValidAddress(String address) {
		int addr = Integer.parseInt(address, 10);
		
//		Ruling out the leading zeros
		if (address.length() != Integer.toString(addr).length()) return false;
		
		return (0 <= addr && addr < 256);
	}

	@Override
	public boolean test() {
		System.out.printf("For the string %s, possible IP addresses are:%n", testSuite[index]);
		
		for (String address : result) {
			System.out.println("\t" + address);
		}
		
		System.out.println("------------------");
		
		return true;
	}

}
