package com.cllin.chap04;

import com.cllin.main.Exercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

public class Exercise04_08 implements Exercise {
	private final int MAXIMUM = 100;
	private final int SIZE = 1000;
	
	private int[] copy = new int[SIZE];
	
	private BinarySearchTree tree;

	@Override
	public void runExercise() {
		initialize();
		
		for(int n = 10; n < 30; n++){
			findPath(tree.root, n);
		}
		
		System.out.println("All paths are found");
	}
	
	private void findPath(Node node, int sum){
		if (node == null) return;
		
		Node head = node;
		int distance = 0;
		int tmp = sum;
		while(head != null){
			tmp -= head.key;
			
			if(tmp == 0){
				printPath(node, distance, sum);
				break;
			}else{
				distance++;
				head = head.parent;
			}
		}
		
		findPath(node.right, sum);
		findPath(node.left, sum);
		
	}
	
	private void printPath(Node node, int distance, int sum){
		while(distance >= 0 && node != null){
			System.out.printf("%d -> ", node.key);
			node = node.parent;
			distance--;
		}
		System.out.printf("sum = %d%n", sum);
	}

	private void initialize(){
		tree = new BinarySearchTree((int)(Math.random() * MAXIMUM));
		
		for(int i = 0; i < SIZE; i++){
			int key = (int)(Math.random() * MAXIMUM);
			copy[i] = key;
			tree.insert(new Node(key, null, null, null));
		}
	}

}
