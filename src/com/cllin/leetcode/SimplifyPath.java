package com.cllin.leetcode;

import java.util.LinkedList;

import com.cllin.main.LeetCodeExercise;

public class SimplifyPath implements LeetCodeExercise {

	private final String[] testSuite = {
			"/home/",
			"/a/./b/../../c/",
			"/..", 
			"/", 
			"///", 
			"/.", 
			"/...",
			"/home/foo/.ssh/../.ssh2/authorized_keys/"
	};
	
	private int index;
	private String simplifiedPath;
	
	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void runExercise() {
		for (index = 0; index < testSuite.length; index++) {
			simplifiedPath = simplifyPath(testSuite[index]);
			test();
		}
	}
	
	private String simplifyPath(String path) {
		if (path == null || path.length() == 0) return new String();

		LinkedList<String> directories = new LinkedList<String>();
		int i = 0;
		while (i < path.length()) {
			if (path.charAt(i) == '/') {
				i++;
			} else {
				int index = path.indexOf("/", i);
				String d = (index == -1)? path.substring(i) : path.substring(i, index);
				i = (index == -1)? path.length() : index + 1;
				
				if (d.equals("..")) {
					if (!directories.isEmpty()) directories.removeLast();
				} else if (!d.equals(".")) {
					directories.add(d);
				}
			}
		}
		
		StringBuffer buffer = new StringBuffer();
		while (!directories.isEmpty()) {
			buffer.append("/").append(directories.poll());
		}
		
		if (buffer.length() == 0) return "/";
		if (buffer.charAt(buffer.length() - 1) == '/') return buffer.substring(0, buffer.length() - 1);
		
    	return buffer.toString();
    }

	@Override
	public boolean test() {
		System.out.printf("The simplified path of {%s} is {%s}%n", testSuite[index], simplifiedPath);
		return true;
	}

}
