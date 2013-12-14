package com.cllin.chap19;

import com.cllin.main.Exercise;

public class Exercise19_01 implements Exercise {
	private final int shift = 7;
	private final int max = 100;
	
	@Override
	public void runExercise() {
		for(int i = 0; i < 10; i++){
			Pair pair = new Pair((int)(Math.random() * 100), (int)(Math.random() * max));
			int a_buf = pair.a;
			int b_buf = pair.b;
			pair.swap();
			
			if(a_buf != pair.b || b_buf != pair.a){
				System.out.println("Failed!");
				return;
			}
		}
		System.out.println("Passed");
	}

	private class Pair{
		public int a = 0;
		public int b = 0;
		public Pair(int x, int y){
			a = x;
			b = y;
		}
		
		public void swap(){
			exclusiveOr();
		}
		
		@SuppressWarnings("unused")
		private void bitwiseOperation(){
			a = a << shift;
			a = a + b;
			b = a >> shift;
			a = a - (b << shift);			
		}
		
		private void exclusiveOr(){
			a = a ^ b;
			b = a ^ b;
			a = a ^ b;			
		}
	}
}
