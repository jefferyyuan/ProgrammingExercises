package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Source: http://oj.leetcode.com/problems/insert-interval/
 */

public class InsertInterval implements LeetCodeExercise {

	private ArrayList<ArrayList<Interval>> testSuite;
	private ArrayList<Interval> newIntervals;
	
	private ArrayList<Interval> result;
	
	private int index;
	
	@Override
	public void initialize() {
		testSuite = new ArrayList<ArrayList<Interval>>();
		newIntervals = new ArrayList<Interval>();
		
		ArrayList<Interval> test;
		
//		CASE 1
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 3));
		test.add(new Interval(6, 9));
		newIntervals.add(new Interval(2, 5));
		testSuite.add(test);

//		CASE 2
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 2));
		test.add(new Interval(3, 5));
		test.add(new Interval(6, 7));
		test.add(new Interval(8, 10));
		test.add(new Interval(12, 16));
		newIntervals.add(new Interval(4, 9));
		testSuite.add(test);

//		CASE 3
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 2));
		test.add(new Interval(8, 10));
		test.add(new Interval(12, 16));
		newIntervals.add(new Interval(0, 9));
		testSuite.add(test);
		
//		CASE 4
		test = new ArrayList<Interval>();
		test.add(new Interval(1, 2));
		test.add(new Interval(8, 10));
		test.add(new Interval(12, 16));
		newIntervals.add(new Interval(9, 20));
		testSuite.add(test);
		
//		CASE 5
		test = new ArrayList<Interval>();
		test.add(new Interval(8, 10));
		test.add(new Interval(12, 16));
		newIntervals.add(new Interval(1, 20));
		testSuite.add(test);
		
	}

	@Override
	public void run() {
		initialize();
		
		for (index = 0; index < testSuite.size(); index++) {
			result = insert(new ArrayList<Interval> (testSuite.get(index)), newIntervals.get(index));
			test();
		}
	}

	private ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		if (intervals == null || intervals.size() == 0) {
			intervals = new ArrayList<Interval>();
			intervals.add(newInterval);
			return intervals;
		}
		
		int index = 0;
		while (index < intervals.size() && intervals.get(index).start < newInterval.start) {
			index++;
		}
		
		intervals.add(index, newInterval);
		
//		Merge with the previous interval if needed
		if (index > 0 && intervals.get(index - 1).end >= intervals.get(index).start) {
			int end = Math.max(intervals.get(index - 1).end, intervals.get(index).end);
			
			Interval interval = new Interval(intervals.get(index - 1).start, end);
			intervals.set(index - 1, interval);
			intervals.remove(index--);
		}

//		Merge with the next interval if needed
		int j = index + 1;
		while (j < intervals.size() && intervals.get(j).start <= newInterval.end) {
			int end = Math.max(intervals.get(index).end, intervals.get(j).end);

			Interval interval = new Interval(intervals.get(index).start, end);
			intervals.set(index, interval);
			intervals.remove(j);
		}
		
    	return intervals;
    }
	
	@Override
	public boolean test() {
		System.out.print("For the interval set: ");
		
		for (Interval interval : testSuite.get(index)) {
			System.out.printf("[ %d, %d ] ", interval.start, interval.end);
		}
		
		System.out.printf(", and the new interval: [ %d, %d ], the new set is:%n", 
				newIntervals.get(index).start, newIntervals.get(index).end);
		
		for (Interval interval : result) {
			System.out.printf("[ %d, %d ] ", interval.start, interval.end);
		}
		
		System.out.println("\n------------------");
		
		return true;
	}
	
	private class Interval {
		int start, end;
		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
