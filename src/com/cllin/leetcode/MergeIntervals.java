package com.cllin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import com.cllin.main.LeetCodeExercise;

/*
 * Description
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * http://oj.leetcode.com/problems/merge-intervals/
 */

public class MergeIntervals implements LeetCodeExercise {

	private ArrayList<ArrayList<Interval>> testSuite;
	
	private int index;
	private ArrayList<Interval> result;
	
	@Override
	public void initialize() {
		testSuite = new ArrayList<ArrayList<Interval>>();
		
		ArrayList<Interval> test;
		
//		CASE 1
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 3));
		test.add(new Interval(2, 6));
		test.add(new Interval(8, 10));
		test.add(new Interval(15, 18));
		testSuite.add(test);
		
//		CASE 2
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 4));
		test.add(new Interval(5, 5));
		testSuite.add(test);
		
//		CASE 3
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 4));
		test.add(new Interval(0, 1));
		testSuite.add(test);
	}

	@Override
	public void runExercise() {
		initialize();
		
		for (index = 0; index < testSuite.size(); index++) {
			result = merge(new ArrayList<Interval> (testSuite.get(index)));
			test();
		}
	}
	
	/************************************************
	 * The keys of this question are:
	 * 1) Implementing a comparator that support Interval
	 * 2) Merge and delete intervals if needed
	 */
	private ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		if (intervals == null) return new ArrayList<Interval>();
		if (intervals.size() <= 1) return intervals;
		
		Collections.sort(intervals, new IntervalComparator());
		
		int i = 0;
		while (i < intervals.size()) {
			int j = i + 1;
			while (j < intervals.size() && intervals.get(j).start <= intervals.get(i).end) {
				int start = intervals.get(i).start;
				int end = Math.max(intervals.get(i).end, intervals.get(j).end);
				
				Interval interval = new Interval(start, end);
				intervals.set(i, interval);
				intervals.remove(j);
			}
			i++;
		}
		
    	return intervals;
    }
	
	private class Interval {
		int start, end;
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
	
	private class IntervalComparator implements Comparator<Interval> {
		@Override
		public int compare(Interval i1, Interval i2) {
			if (i1.start < i2.start) return -1;
			if (i1.start > i2.start) return 1;
			
			return 0;
		}
	}
	
	@Override
	public boolean test() {
		System.out.print("For the interval set: ");
		
		for (Interval interval : testSuite.get(index)) {
			System.out.printf("[ %d, %d ] ", interval.start, interval.end);
		}
		
		System.out.print("The new set without overlap is:\n");
		
		for (Interval interval : result) {
			System.out.printf("[ %d, %d ] ", interval.start, interval.end);
		}
		
		System.out.println("\n------------------");
		
		return true;
	}
}
