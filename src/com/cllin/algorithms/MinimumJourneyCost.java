package com.cllin.algorithms;

import java.util.HashMap;
import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * Given the mileages of each stop of a journey. For example: {0, 10, 15, 30, 70, 100, 110, 125, 130, 200}
 * The cost of a trip is calculated as the summation of |travel distance - 50|
 * For example, a traveler traveled 100 kilometers then stopped, the cost would be |100 - 50|
 * 
 * Calculate the path the produce minimum cost of a journey.
 * 
 */

public class MinimumJourneyCost implements Exercise {

	private final int SIZE = 100;
	private final int MAXIMUM = 10;
	
	private HashMap<Integer, String> reference;
	private int[] mileages;
	
	@Override
	public void run() {
		initialize();
		
		System.out.printf("For journey J = { ");
		for (int i = 0; i < mileages.length; i++) {
			System.out.printf("%s = %d ", reference.get(mileages[i]), mileages[i]);
		}
		System.out.printf("}%n");
		
		int minimumCost = getJourney(mileages);
		
		System.out.printf("Minimum Cost = %d%n", minimumCost);
		System.out.printf("Minimum Journey = {%n");
		while (!shortestJourney.isEmpty()) {
			int index = shortestJourney.poll();
			System.out.printf("    %s = %d%n", reference.get(mileages[index]), mileages[index]);
		}
		System.out.println("}");
	}
	
	/*
	 * C(i, j) = Cost from i to j
	 * C(i, n) = Minimum(C(i, j) + C(j, n)), i + 1 <= j < n
	 * 
	 * Return C(0, n)
	 */
	private static LinkedList<Integer> shortestJourney;
	private static int getJourney(int[] mileages) {
		shortestJourney = new LinkedList<Integer>();
		
		int[] path = new int[mileages.length];
		int[] costs = new int[mileages.length];
		costs[mileages.length - 1] = 0;
		path[mileages.length - 1] = mileages.length;
		
		for (int i = mileages.length - 2; i >= 0; i--) {
			int min = Integer.MAX_VALUE;
			int minIndex = i + 1;
			for (int j = i + 1; j < mileages.length; j++) {
				int cost = costs[j] + Math.abs(mileages[j] - mileages[i] - 50);
				if (cost < min) {
					min = cost;
					minIndex = j;
				}
			}
			
			costs[i] = min;
			path[i] = minIndex;
		}
		
		int index = 0;
		while (index < mileages.length - 1) {
			shortestJourney.add(index);
			index = path[index];
		}
		
		return costs[0];
	}
	
	private void initialize() {
		mileages = new int[SIZE];
		reference = new HashMap<Integer, String>();
		
		mileages[0] = 0;
		reference.put(0, getMark(0));
		
		for (int i = 1; i < mileages.length; i++) {
			int mileage = (int) (Math.random() * MAXIMUM + 1) * 5 + mileages[i - 1];
			
			mileages[i] = mileage;
			reference.put(mileage, getMark(i));
		}
	}

	private static String getMark(int n) {
		if (n == 0) return "A";
		
		StringBuffer buffer = new StringBuffer();
		while (n > 0) {
			buffer.insert(0, mapNumberToString(n % 26));
			n /= 26;
		}
		
		return buffer.toString();
	}
	
	private static String mapNumberToString(int n) {
		return Character.toString ((char) (n + (int) 'A'));
	}
}
