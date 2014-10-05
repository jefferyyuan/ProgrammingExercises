package com.cllin.operator;

import com.cllin.main.Exercise;

public class BitwiseOperation implements Exercise {

	@Override
	public void run() {
		int integer = 0x00FF;
		int shift = 2;
		
		System.out.println("shift = " + shift);
		System.out.println("integer = " + integer + ", shown in binary: " 
				+ getBinary(integer));
		System.out.println("integer >> shift = " + (integer >> shift) 
				+ ", shown in binary: " + getBinary(integer >> shift));
		System.out.println("integer << shift = " + (integer << shift) 
				+ ", shown in binary: " + getBinary(integer << shift));
		System.out.println("integer >>> shift = " + (integer >>> shift) 
				+ ", shown in binary: " + getBinary(integer >>> shift));
		
	}
	
//	Integer.toBinaryString(integer)
	private String getBinary(int input){
		
		if(input < 0){
			input *= (-1);
		}
		
		String output = new String();
		int power = 0;
		int copyInput = input;
		
		while(input > 0){
			if(input / 2 > 0){
				power++;
				input /= 2;
			}else{
				break;
			}
		}
		
		while(power > -1){
			if(copyInput >= Math.pow(2, power)){
				output += "1";
				copyInput -= Math.pow(2, power);
				power--;
			}else{
				output += "0";
				power--;
			}
		}
		
		return output;
	}

}
