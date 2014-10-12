package com.cllin.leetcode;

import java.util.ArrayList;

import com.cllin.main.LeetCodeExercise;
import com.cllin.tree.BinarySearchTree;
import com.cllin.tree.Node;

/*
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Source: http://oj.leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal implements
        LeetCodeExercise {

    private final int SIZE = 10;
    
    private BinarySearchTree tree;
    private Node root;
    
    private int[] inorder;
    private int[] postorder;
    
    @Override
    public void initialize() {
        int[] numbers = new int[SIZE];
        for (int i = 1; i <= SIZE; i++) numbers[i - 1] = i;
        
        tree = new BinarySearchTree();
        tree.buildTree(numbers);
        
        inorder = new int[SIZE];
        postorder = new int[SIZE];
        
        ArrayList<Integer> inorderReference = inorderTraversal(tree.root);
        ArrayList<Integer> postorderReference = postorderTraversal(tree.root);
        
        for (int i = 0; i < SIZE; i++) {
            inorder[i] = inorderReference.get(i);
            postorder[i] = postorderReference.get(i);
        }
    }

    @Override
    public void run() {
        initialize();
        root = buildTree(inorder, postorder);

        if (test()) System.out.println("Success");
        else System.out.println("Failed");    
    }

//    Assuming the value of the nodes are unique
//    Memory usage can be improved if the arrays are reused
    private static Node buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) return null;
        if (inorder.length != postorder.length) return null;
        if (inorder.length == 0) return null;
        
        int length = inorder.length;
        int rootValue = postorder[length - 1];
        
        Node root = new Node(rootValue);
        int rootIndex = -1;
        for (int i = 0; i < length; i++) {
            if (inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        
        int[] leftInorder = new int[rootIndex];
        int[] leftPostorder = new int[rootIndex];
        for (int i = 0; i < rootIndex; i++) {
            leftInorder[i] = inorder[i];
            leftPostorder[i] = postorder[i];
        }
        
        int[] rightInorder = new int[length - rootIndex - 1];
        int[] rightPostorder = new int[length - rootIndex - 1];
        for (int i = 0; i < length - rootIndex - 1; i++) {
            rightInorder[i] = inorder[i + rootIndex + 1];
            rightPostorder[i] = postorder[i + rootIndex];
        }
        
        root.left = buildTree(leftInorder, leftPostorder);
        root.right = buildTree(rightInorder, rightPostorder);
        
        return root;
    }
    
    private ArrayList<Integer> postorderTraversal(Node root) {
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        
        if (root == null) return rtn;
        
        rtn.addAll(postorderTraversal(root.left));
        rtn.addAll(postorderTraversal(root.right));
        rtn.add(root.value);
        
        return rtn;
    }
    
    private ArrayList<Integer> inorderTraversal(Node root) {
        ArrayList<Integer> rtn = new ArrayList<Integer>();
        
        if (root == null) return rtn;
        
        rtn.addAll(inorderTraversal(root.left));
        rtn.add(root.value);
        rtn.addAll(inorderTraversal(root.right));
        
        return rtn;
    }

    @Override
    public boolean test() {
        ArrayList<Integer> inorderReference = inorderTraversal(root);
        
        int size = inorderReference.size();
        if (inorder.length != size) return false;
        
        for (int i = 0; i < size; i++) {
            if (inorder[i] != inorderReference.get(i)) return false;
        }
        
        return true;
    }

}
