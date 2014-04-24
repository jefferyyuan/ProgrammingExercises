package com.cllin.tree;

import java.util.Arrays;


/*
 *	An interface should be implemented between the user and the tree
 *	User should not (and does not want to) access to the tree and the node
 */
public class BinarySearchTree {
	public Node root;
	private int size;
	
	public BinarySearchTree(int key){
		root = new Node(key, null, null, null);
		size = 1;
	}
	
	public BinarySearchTree(){
		root = null;
		size = 0;
	}
	
    /**
     * Build a BST with minimum possible height.
     *
     * @param size the number of nodes in the tree
     * @param maximum the maximum value of nodes in the tree
     */
	public void buildTree(int size, int maximum){
		if (size <= 0) return;
		
		int[] numbers = new int[size];
		for (int i = 0; i < size; i++) {
			numbers[i] = (int)(Math.random() * maximum);
		}
		
		buildTree(numbers);
	}

    /**
     * Build a BST with minimum possible height with the values in an array.
     *
     * @param numbers the array whose elements will be used to build the tree 
     */
	public void buildTree(int[] numbers){
		if (numbers.length == 0) return;
		
		Arrays.sort(numbers);
		
		this.root = buildTree(numbers, 0, numbers.length - 1);
		this.size = numbers.length;
	}
	
	public void insert(Node node){
		Node x = root;
		Node y = null;
		
		while(x != null){
			y = x;
			if(node.value < x.value){
				x = x.left;
			}else{
				x = x.right;
			}
		}
		
		node.parent = y;
		
		if(y == null){
			root = node;
		}else if(node.value < y.value){
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
		if(node == null || node.value == key){
			return node;
		}else if(key > node.value){
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
	
	
	public int getLevel(Node node){
		int level = 0;
		
		while (node.parent != null) {
			level++;
			node = node.parent;
		}
		
		return level;
	}
	
	public String printTree() {
		return inorderTraversal(this.root, new StringBuffer()).toString();
	}
	
	private StringBuffer inorderTraversal(Node node, StringBuffer buffer) {
		if (node == null) return buffer;
		
		buffer = inorderTraversal(node.left, buffer);
		buffer.append(node.value);
		buffer = inorderTraversal(node.right, buffer);
		
		return buffer;
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
	
    private Node buildTree(int[] num, int start, int end) {
    	if (start == end) return new Node(num[start]);
    	else if (start > end) return null;
    	
    	int mid = (start + end) / 2;
    	
    	Node node = new Node(num[mid]);
    	node.left = buildTree(num, start, mid - 1);
    	node.right = buildTree(num, mid + 1, end);
    	
    	return node;
    }
}
