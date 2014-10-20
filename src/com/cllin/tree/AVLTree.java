package com.cllin.tree;

import java.util.ArrayList;

public class AVLTree {
    private AVLNode root;
    private int size;

    /************************************************************
     * Public Functions
     ************************************************************/
    public AVLTree() {
        this.root = null;
        this.size = 0;
    }

    /**
     * Insert a new node to the tree.
     * @param key the value to be inserted
     */
    public void insert(int key) {
        this.root = insertAVL(this.root, key);
        size++;
    }
    
    /**
     * Delete a node from the tree.
     * @param key the value to be deleted
     */
    public void delete(int key) {
//        TODO To be implemented
    }
    
    /**
     * Clear the tree.
     */
    public void makeEmpty() {
        this.root = null;
    }

    /**
     * Find the node with a specific key.
     * @param key the expected key
     */
    public int find(int key) {
        AVLNode result = find(this.root, key);
        return (result == null)? -1 : result.key;
    }
    
    /**
     * Find if the tree contains a specific key.
     * @param key the expected key
     */
    public boolean contains(int key) {
        return (find(this.root, key) != null);
    }
    
    /**
     * @return An ArrayList<Integer> that contains every element on the tree
     */
    public ArrayList<Integer> printTree() {
        ArrayList<Integer> keys = new ArrayList<Integer>();
        
        printTree(root, keys);
        return keys;
    }
    
    public int getSize() {
        return this.size;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public int getMinimum() {
        AVLNode node = this.root;
        
        if (node == null) return -1;
        while (node.left != null) {
            node = node.left;
        }
        
        return node.key;
    }
    
    public int getMaximum() {
        AVLNode node = this.root;
        
        if (node == null) return -1;
        while (node.right != null) {
            node = node.right;
        }
        
        return node.key;
    }
    
    /************************************************************
     * Core Functions
     ************************************************************/
    private AVLNode insertAVL(AVLNode root, int key) {
        if (root == null) {
            root = new AVLNode(key);
            return root;
        }
        
        if (key < root.key) {
            root.left = insertAVL(root.left, key);
            
            if (getHeight(root.left) - getHeight(root.right) == 2) {
                if (key < root.left.key) {
                    root = rotateWithLeftChild(root);
                } else {
                    root = doubleWithLeftChild(root);
                }
            }
        } else {
            root.right = insertAVL(root.right, key);
            
            if (getHeight(root.right) - getHeight(root.left) == 2) {
                if (key > root.right.key) {
                    root = rotateWithRightChild(root);
                } else {
                    root = doubleWithRightChild(root);
                }
            }
        }
        
        root.height = 1 + Math.max(getHeight(root.left), getHeight(root.right));
        return root;
    }

    private static AVLNode rotateWithLeftChild(AVLNode n2) {
        if (n2.left == null) return n2;
        
        AVLNode n1 = n2.left;
        n2.left = n1.right;
        n1.right = n2;
        
        n2.height = 1 + Math.max(getHeight(n2.left), getHeight(n2.right));
        n1.height = 1 + Math.max(getHeight(n2.left), getHeight(n2));
        
        return n1;
    }
    
    private static AVLNode rotateWithRightChild(AVLNode n1) {
        if (n1.right == null) return n1;
        
        AVLNode n2 = n1.right;
        n1.right = n2.left;
        n2.left = n1;
        
        n1.height = 1 + Math.max(getHeight(n1.left), getHeight(n1.right));
        n2.height = 1 + Math.max(getHeight(n2.left), getHeight(n1));
        
        return n2;
    }
    
    private static AVLNode doubleWithLeftChild(AVLNode n3) {
        n3.left = rotateWithRightChild(n3.left);
        return rotateWithLeftChild(n3);
    }
    
    private static AVLNode doubleWithRightChild(AVLNode n1) {
        n1.right = rotateWithRightChild(n1.right);
        return rotateWithLeftChild(n1);
    }

    /************************************************************
     * Helper Functions
     ************************************************************/
    private ArrayList<Integer> printTree(AVLNode node, ArrayList<Integer> keys) {
        if (node == null) return keys;
        
        printTree(node.left, keys);
        keys.add(node.key);
        printTree(node.right, keys);
        
        return keys;
    }
    
    private AVLNode find(AVLNode node, int key) {
        if (node == null) return null;
        if (node.key == key) return node;
        
        return (key < node.key)? find(node.left, key) : find(node.right, key);
    }
    
    private static int getHeight(AVLNode node) {
        return (node == null)? -1 : node.height;
    }
    
    /************************************************************
     * Node Class
     ************************************************************/
    public class AVLNode {
        AVLNode left;
        AVLNode right;
        AVLNode parent;
        int key;
        int height;
        
        public AVLNode(int key) {
            this.left = null;
            this.right = null;
            this.parent = null;
            this.key = key;
            height = 0;
        }
        
    }
}
