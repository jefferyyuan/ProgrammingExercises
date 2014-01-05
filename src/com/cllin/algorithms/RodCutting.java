package com.cllin.algorithms;

import com.cllin.main.Exercise;

public class RodCutting implements Exercise{
	private final int ROD_LENGTH = 10;

//	priceTable[length] = price
	private final int[] priceTable = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
	private int[] revenue = new int[ROD_LENGTH + 1];
	
	private int count = 0;
	
	@Override
	public void runExercise() {
		revenue[0] = 0;
		
		cutRod(ROD_LENGTH);
		printRevenue();
		System.out.println("cutRod(length) made " + count + " computations");
		
		clean();
		
		improvedCutRod(ROD_LENGTH);
		printRevenue();
		System.out.println("improvedCutRod(length) made " + count + " computations, in a price of consumpted more memory");
	}
	
	private int improvedCutRod(int length){
//		One single line changes a lot!
		if (this.revenue[length] >= 0) return this.revenue[length];
		
		count++;
		int revenue = -2147483647;
		if(length == 0){
			revenue = 0;
			this.revenue[0] = revenue;
		}else{
			int l = length + 1;
			for(int i = 1; i < l; i++){
				int price = priceTable[i] + improvedCutRod(length - i);
				if (price > revenue) revenue = price;
			}
		}
		
		this.revenue[length] = revenue;
		return revenue;
	}

	private int cutRod(int length){
		count++;
		if (length == 0) return 0;

		int revenue = -2147483647;
		
		int l = length + 1;
		for(int i = 1; i < l; i++){
			int price = priceTable[i] + cutRod(length - i);
			if (price > revenue) revenue = price;
			this.revenue[i] = revenue;
		}
		
		return revenue;
	}
	
	private void printRevenue(){
		int length = ROD_LENGTH + 1;
		for(int i = 0; i < length; i++){
			System.out.print("MAX_REVENUE(" + i + ") = " + revenue[i] + " ");
			if (i % 5 == 0) System.out.println();
		}
	}
	
	private void clean(){
		int length = ROD_LENGTH + 1;
		for(int i = 0; i < length; i++){
			revenue[i] = -2147483647;
		}
		count = 0;
	}

}
