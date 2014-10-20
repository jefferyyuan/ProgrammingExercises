package com.cllin.tree;

import com.cllin.main.Exercise;

public class BinarySearchTreeExercise extends Exercise{
    private final int MAXIMUM = 10000;
    private final int SIZE = 10000;
    
    private BinarySearchTree tree;
    private int[] keys;

    @Override
    protected void initialize() {
        tree = new BinarySearchTree((int)(Math.random() * MAXIMUM));
        keys = new int[SIZE];
        
        for (int i = 0; i < SIZE; i++) {
            int key = (int) (Math.random() * MAXIMUM);
            keys[i] = key;
            tree.insert(new Node(key, null, null, null));
        }
    }

    @Override
    protected void runExercise() {
//    The tree is too big to be printed out
//    tree.inOrderTreeWalk(tree.root);
      
      System.out.println();
      System.out.println("The maximum element in the tree is " + tree.getMaximum(tree.root).value);
      System.out.println("The minimum element in the tree is " + tree.getMinimum(tree.root).value);
      System.out.println("The size of the tree is " + tree.getSize());
      
      int searches = (int) (Math.random() * 10) + 1;
      for (int i = 0; i < searches; i++) {
          int key = (int) (Math.random() * SIZE);
          Node node = tree.search(tree.root, key);
          if (node != null) {
              System.out.print(key + " is found. ");
              
              Node successor = tree.getSuccessor(node);
              Node predecessor = tree.getPredecessor(node);
              if (successor == null) {
                  System.out.print("It does not have a successor. ");
              } else {
                  System.out.print("Its successor is " + successor.value + ". ");
              }
              
              if (predecessor == null) {
                  System.out.println("It does not have a predecessor. ");
              } else {
                  System.out.println("Its predecessor is "+ predecessor.value + ". ");
              }
          } else {
              System.out.println(key + " is not found");
          }
      }

//    XXX
//    This not a good way to delete random element. 
//    Duplicate deletion might occur when number of required deletion grows
//    But it is good enough to prove this tree works :P
      int deletes = (int)(Math.random() * 10) + 1;
      int validDeletes = 0;
      for (int i = 0; i < deletes; i++) {
          int key = (int) (Math.random() * SIZE);
          Node deleted = tree.search(tree.root, keys[key]);
          if (deleted != null) {
              tree.delete(deleted);
              validDeletes++;
          }
      }
      
      System.out.println("After " + validDeletes + " deletion, the size of the tree is " + tree.getSize());
    }

    @Override
    protected boolean test() {
        return true;
    }
}
