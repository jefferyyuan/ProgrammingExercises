package com.cllin.cci.chap08;

import com.cllin.main.Exercise;

public class Exercise08_06 implements Exercise {
	private final int SIZE = 20;
	private Point[][] plane;

	@Override
	public void runExercise() {
		initialize();
		printPlane();
		
		fillPaint(2, 3, Point.BLUE, Point.RED);
		printPlane();
	}
	
	private void fillPaint(int x, int y, int originPaint, int newPaint){
		if(x + 1 < SIZE){
			if(plane[x + 1][y].color == originPaint){
				plane[x + 1][y].color = newPaint;
				fillPaint(x + 1, y, originPaint, newPaint);
			}
		}
		
		if(x - 1 >= 0){
			if(plane[x - 1][y].color == originPaint){
				plane[x - 1][y].color = newPaint;
				fillPaint(x - 1, y, originPaint, newPaint);
			}
		}
		
		if(y + 1 < SIZE){
			if(plane[x][y + 1].color == originPaint){
				plane[x][y + 1].color = newPaint;
				fillPaint(x, y + 1, originPaint, newPaint);
			}
		}
		
		if(y - 1 >= 0){
			if(plane[x][y - 1].color == originPaint){
				plane[x][y - 1].color = newPaint;
				fillPaint(x, y - 1, originPaint, newPaint);
			}
		}
	}
	
	private void initialize(){
		plane = new Point[SIZE][SIZE]; 
		
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				plane[i][j] = new Point();
			}
		}
		
//		Create a blue square
		int x = 2;
		int y = 3;
		int size = 4;
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				plane[x + i][y + j].color = Point.BLUE;
			}
		}
		
		
	}
	
	private void printPlane(){
		System.out.println("------");
		for(int i = 0; i < SIZE; i++){
			for(int j = 0; j < SIZE; j++){
				switch(plane[i][j].color){
				case Point.RED:
					System.out.print("o");
					break;
				case Point.BLUE:
					System.out.print(" ");
					break;
				case Point.GREEN:
					System.out.print("v");
					break;
				}
			}
			System.out.println();
		}
		System.out.println("------");
	}

	private class Point {
		private static final int RED = 1;
		private static final int BLUE = 2;
		private static final int GREEN = 3;
		private int color = 0;
		
		public Point(){
			switch((int)(Math.random() * 3) + 1){
			case RED:
				this.color = RED;
				break;
			case BLUE:
				this.color = BLUE;
				break;
			case GREEN:
				this.color = GREEN;
				break;
				default:
					this.color = GREEN;
					break;
			}
		}
	}
}
