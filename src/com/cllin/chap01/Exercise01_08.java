package com.cllin.chap01;

import com.cllin.main.Exercise;

public class Exercise01_08 implements Exercise {
	private final String string1 = "renderscript";
	private final String string2 = "scriptrender";
	private final String string3 = "readme";
	private final String string4 = "mreead";

	@Override
	public void runExercise() {
		test(string1, string2);
		test(string3, string4);
	}
	
	private void test(String s1, String s2){
		if(isRotation(s1, s2)){
			System.out.printf("%s is a rotation of %s%n", s2, s1);
		}else{
			System.out.printf("%s is not a rotation of %s%n", s2, s1);
		}		
	}
	
	private boolean isRotation(String s1, String s2){
		String str = s2 + s2;
		return isSubstring(str, s1);
	}
	
	private boolean isSubstring(String s1, String s2){
		return s1.contains(s2);
	}
}
