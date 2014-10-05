package com.cllin.leetcode;

import java.util.Collections;
import java.util.LinkedList;

import com.cllin.main.LeetCodeExercise;

/*
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Source: http://oj.leetcode.com/problems/max-points-on-a-line/
 */

public class MaxPointsOnALine implements LeetCodeExercise {
	
	private final Point[][] testSuite = {
			{new Point(0, 0)},
			{new Point(0, 0), new Point(-1, -1), new Point(2, 2)}
	};
	
	private int index;
	private int maximum;

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
	}

	@Override
	public void run() {
		for (index = 0; index < testSuite.length; index++) {
			maximum = maxPoints(testSuite[index]);
			test();
		}
	}
	
	private int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;
		
		int output = 0;
		int nPoints = points.length;
		LinkedList<Double> slopes = new LinkedList<Double>();
		
//		For every point,
		for (int i = 0; i < nPoints; i++) {
			int nDuplicates = 1;
			Point point = points[i];
			slopes = new LinkedList<Double>();
			
//			considering every other point
			for (int j = 0; j < nPoints; j++) {
				if (j == i) continue;
				
				Point p = points[j];
				if (p.x == point.x) {
					if (p.y == point.y) {
//						Duplicate point
						nDuplicates++;
					} else {
//						Vertical line
						slopes.push(Double.MAX_VALUE);
					}
				} else {
//					Ordinary line
					slopes.push((double) (p.y - point.y) / (double) (p.x - point.x));
				}
			}
			
//			Now we have the slope of this point and every other point
			Collections.sort(slopes);
			int count = 1;
			
			if (slopes.size() <= 1) output = Math.max(output, slopes.size() + nDuplicates);
			for (int p = 1; p < slopes.size(); p++) {
				if (slopes.get(p).equals(slopes.get(p - 1))) {
//					If duplicate slope exists, which means multiple points on the same line
					count++;
				} else {
//					Update if needed, refresh the count
					count = 1;
				}
				output = Math.max(output, count + nDuplicates);
			}
		}
		
    	return output;
    }

	@Override
	public boolean test() {
		System.out.print("For the set { ");
		for (Point point : testSuite[index]) {
			System.out.printf("(%d, %d) ", point.x, point.y);
		}
		
		System.out.printf("}, the maximum number of points on the same line is %d%n", maximum);
		
		return true;
	}
	
	class Point {
		int x;
		int y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		Point() {
			this(0, 0);
		}
	}

}
