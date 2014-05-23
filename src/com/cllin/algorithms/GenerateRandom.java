package com.cllin.algorithms;

import java.util.HashMap;
import java.util.HashSet;

import com.cllin.main.Exercise;

/*
 * Implement this function: int getRandom(int N, int K[]) 
 * 
 * Constraints:
 * 	1) K is sorted and contains elements in range [0, N)
 * 	2) Output should be a random number between [0, N) excluding elements from K
 * 	3) Probability of generated number should be 1 / (N - K.length) and not 1 / N
 * 	4) int uniform(int N) is given which returns random number [0, N) with 1 / N probability for each number
 * 	5) No more than O(1) memory
 * 	6) No more than O(N) time 
 * 
 * Source: http://www.careercup.com/question?id=6065702117048320
 */

public class GenerateRandom implements Exercise {

	private int N;
	private int[] array;
	
	@Override
	public void runExercise() {
		N = 30;
		initialize();
		
		System.out.printf("N = %d%n", N);
		
		System.out.print("K = { ");
		for (int n : array) {
			System.out.printf("%d ", n);
		}
		System.out.printf("}%n");
		
		test();
	}
	
	private int getRandom(int N, int K[]) {
		int target = uniform(N - K.length);
		
		int i = 0;
		int j = 0;
		int valid = 0;
		while (valid <= target) {
			while (j < K.length && K[j] == i) {
				i++;
				j++;
			}
			
			if (valid == target) break;
			i++;
			valid++;
		}
		
		return i;
	}
	
	private void initialize() {
		int k = (int) (Math.random() * N);
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < k; i++) {
			set.add((int) (Math.random() * N));
		}
		
		array = new int[set.size()];
		int i = 0;
		for (int n : set) {
			array[i++] = n;
		}
	}

	private final int uniform(int n) {
		return (int) (Math.random() * n);
	}
	
	private void test() {
		final int TRIALS = 10000;
		HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
		for (int i = 0; i < TRIALS; i++) {
			int random = getRandom(N, array);
			
			int count = (counts.containsKey(random))? counts.get(random) + 1 : 1;
			counts.put(random, count);
		}
		
		for (Integer key : counts.keySet()) {
			double probability = (double) counts.get(key) / (double) TRIALS;
			System.out.printf("P(%d) = %f%n", key.intValue(), probability);
		}
	}
}