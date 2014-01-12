package com.cllin.chap04;

import com.cllin.main.Exercise;

public class Exercise04_08 implements Exercise {

	@Override
	public void runExercise() {
		// TODO Auto-generated method stub
	}
	
//	private void findPath(TreeNode head, int sum, ArrayList<Integer> buffer, int level){
//		if (head == null) return;
//		
//		int tmp = sum;
//		buffer.add(head.getValue());
//		
//		for(int i = level; i >= 0; i--){
//			sum -= buffer.get(i);
//			if (sum == 0) print(buffer, i, level);
//		}
//		
//		ArrayList<Integer> clone1 = (ArrayList<Integer>) buffer.clone();
//		ArrayList<Integer> clone2 = (ArrayList<Integer>) buffer.clone();
//		
//		findPath(head.getLeftNode(), tmp, clone1, level + 1);
//		findPath(head.getRightChild(), tmp, clone2, level + 1);
//	}
//	
//	private void print(ArrayList<Integer> buffer, int level, int totalLevel){
//		for (int i = level; i <= totalLevel; i++) {
//			System.out.print(buffer.get(i) + " ");
//		}
//		System.out.println();
//	}

}
