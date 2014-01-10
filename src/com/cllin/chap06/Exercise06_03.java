package com.cllin.chap06;

import com.cllin.main.Exercise;

public class Exercise06_03 implements Exercise {
	private final int MAXIMUM_A = 11;
	private final int MAXIMUM_B = 7;
	private int mJugA = 0;
	private int mJugB = 0;
	
	@Override
	public void runExercise() {
		for(int i = 1; i < MAXIMUM_A; i++){
			System.out.println("------");
			int nSteps = getWater(i);
			System.out.printf("It takes %d steps to get %d%n", nSteps, i);
		}
	}
	
	private int getWater(int goal){
		int nSteps = 0;
		NextStep next = NextStep.A_POUR_TO_B;
		mJugA = MAXIMUM_A;
		mJugB = 0;
		
		while(mJugA != goal && mJugB != goal){
			switch(next){
			case A_POUR_TO_B:
				if(mJugA >= MAXIMUM_B){
					mJugA -= (MAXIMUM_B - mJugB);
					mJugB = MAXIMUM_B;
				}else{
					mJugB += mJugA;
					mJugA = 0;
				}
				next = NextStep.CLEAR_B;
				break;
			case CLEAR_B:
				mJugB = 0;
				next = NextStep.A_POUR_TO_B;
				break;
			case FILL_A:
				mJugA = MAXIMUM_A;
				next = NextStep.A_POUR_TO_B;
				break;
			}
			
			if (mJugA == 0) next = NextStep.FILL_A;
			nSteps++;
			
			printJugs();
			
			if (!isValid()) return -1;
		}
		
		return nSteps;
	}
	
	private void printJugs(){
		System.out.printf("JugA=%d, JugB=%d%n", mJugA, mJugB);
	}
	
	private boolean isValid(){
		return (mJugA <= MAXIMUM_A && mJugB <= MAXIMUM_B);
	}
	
	private enum NextStep {
		A_POUR_TO_B,
		CLEAR_B,
		FILL_A
	}

}
