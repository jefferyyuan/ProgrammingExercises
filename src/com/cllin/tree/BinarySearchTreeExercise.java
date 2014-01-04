package com.cllin.tree;

import com.cllin.main.Exercise;

public class BinarySearchTreeExercise implements Exercise{
	private final int MAXIMUM = 10000;
	private final int SIZE = 10000;
	
	private BinarySearchTree tree;
	private int[] keys;
	
	@Override
	public void runExercise() {
		buildTree();
//		The tree is too big to be printed out
//		tree.inOrderTreeWalk(tree.root);
		
		System.out.println();
		System.out.println("The maximum element in the tree is " + tree.getMaximum(tree.root).key);
		System.out.println("The minimum element in the tree is " + tree.getMinimum(tree.root).key);
		System.out.println("The size of the tree is " + tree.getSize());
		
		int searches = (int)(Math.random() * 10) + 1;
		for(int i = 0; i < searches; i++){
			int key = (int)(Math.random() * SIZE);
			Node node = tree.search(tree.root, key);
			if(node != null){
				System.out.print(key + " is found. ");
				
				Node successor = tree.getSuccessor(node);
				Node predecessor = tree.getPredecessor(node);
				if(successor == null){
					System.out.print("It does not have a successor. ");
				}else{
					System.out.print("Its successor is " + successor.key + ". ");
				}
				
				if(predecessor == null){
					System.out.println("It does not have a predecessor. ");
				}else{
					System.out.println("Its predecessor is "+ predecessor.key + ". ");
				}
			}else{
				System.out.println(key + " is not found");
			}
		}

/*		
 * 		XXX
 *		This not a good way to delete random element. 
 *		Duplicate deletion might occur when number of required deletion grows
 *		But it is good enough to prove this tree works :P
 */
		int deletes = (int)(Math.random() * 10) + 1;
		int validDeletes = 0;
		for(int i = 0; i < deletes; i++){
			int	key = (int)(Math.random() * SIZE);
			Node deleted = tree.search(tree.root, keys[key]);
			if(deleted != null){
				tree.delete(deleted);
				validDeletes++;
			}
		}
		System.out.println("After " + validDeletes + " deletion, the size of the tree is " + tree.getSize());
		
	}
	
	private void buildTree(){
		tree = new BinarySearchTree((int)(Math.random() * MAXIMUM));
		keys = new int[SIZE];
		
		for(int i = 0; i < SIZE; i++){
			int key = (int)(Math.random() * MAXIMUM);
			keys[i] = key;
			tree.insert(new Node(key, null, null, null));
		}
	}
	
/*
 *	An interface should be implemented between the user and the tree
 *	User should not (and does not want to) access to the tree and the node
 */
	private class BinarySearchTree{
		private Node root;
		private int size;
		
		public BinarySearchTree(int key){
			root = new Node(key, null, null, null);
			size = 0;
		}
		
		public void insert(Node node){
			Node x = root;
			Node y = null;
			
			while(x != null){
				y = x;
				if(node.key < x.key){
					x = x.left;
				}else{
					x = x.right;
				}
			}
			
			node.parent = y;
			
			if(y == null){
				root = node;
			}else if(node.key < y.key){
				y.left = node;
			}else{
				y.right = node;
			}
			size++;
		}
		
		public void delete(Node node){
			if(node == null){
				return;
			}
			
			if(node.left == null){
				transplant(node, node.right);
			}else if(node.right == null){
				transplant(node, node.left);
			}else{
				Node successor = getSuccessor(node);
				if(successor.parent != node){
					transplant(successor, successor.right);
					successor.right = node.right;
					successor.right.parent = successor;
				}
				
				transplant(node, successor);
				successor.left = node.left;
				successor.left.parent = successor;
			}
			size--;
		}
		
		public int getSize(){
			return size;
		}
		
		@SuppressWarnings("unused")
		public void inOrderTreeWalk(Node node){
			if(node != null){
				inOrderTreeWalk(node.left);
				node.printNode();
				System.out.print(" ");
				inOrderTreeWalk(node.right);
			}
		}
		
		public Node getMinimum(Node node){
			while(node.left != null){
				node = node.left;
			}
			return node;
		}
		
		public Node getMaximum(Node node){
			while(node.right != null){
				node = node.right;
			}
			return node;
		}
		
		public Node search(Node node, int key){
			if(node == null || node.key == key){
				return node;
			}else if(key > node.key){
				return search(node.right, key);
			}else{
				return search(node.left, key);
			}
		}
		
		public Node getSuccessor(Node node){
			if(node.right != null){
				return getMinimum(node.right);
			}
			
			Node parent = node.parent;
			while(parent != null && node == parent.right){
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
		
		public Node getPredecessor(Node node){
			if(node.left != null){
				return getMaximum(node.left);
			}
			
			Node parent = node.parent;
			while(parent != null && node == parent.left){
				node = parent;
				parent = parent.parent;
			}
			return parent;
		}
		
		private void transplant(Node origin, Node newNode){
			if(origin.parent == null){
				root = newNode;
			}else if(origin == origin.parent.left){
				origin.parent.left = newNode;
			}else{
				origin.parent.right = newNode;
			}
			
			if(newNode != null){
				origin.parent = newNode.parent;
			}
		}
	}
	
	private class Node{
		private int key;
		private Node left;
		private Node right;
		private Node parent;
		
		public Node(int key, Node left, Node right, Node parent){
			this.key = key;
			this.left = left;
			this.right = right;
			this.parent = parent;
		}
		
		public void printNode(){
			System.out.print(key);
		}
	}
}
