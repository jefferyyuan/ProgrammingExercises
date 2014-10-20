package com.cllin.leetcode;

import java.util.LinkedList;

import com.cllin.main.Exercise;

/*
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * Source: http://oj.leetcode.com/problems/copy-list-with-random-pointer/
 */

public class CopyListWithRandomPointer extends Exercise {
    
    private RandomListNode[] testSuite = {
            null,
            new RandomListNode(1),
            new RandomListNode(1),
            new RandomListNode(1),
    };

    @Override
    public void initialize() {
        RandomListNode n1;
        RandomListNode n2;
        RandomListNode n3;
        RandomListNode n4;
        RandomListNode n5;
        
        // CASE 0: null list
        
        // CASE 1
        n1 = testSuite[1];
        n2 = new RandomListNode(2);
        n3 = new RandomListNode(3);
        n4 = new RandomListNode(4);
        n5 = new RandomListNode(5);
        
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        
        n1.random = n3;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n2;
        
        // CASE 2: NODE WITH SINGLE ELEMENT
        
        // CASE 3: NODES WITH NULLRANDOM POINTERS
        n1 = testSuite[3];
        n2 = new RandomListNode(2);
        
        n1.next = n2;
        n2.next = null;
        
        n1.random = null;
        n2.random = null;
    }

    @Override
    protected void runExercise() {
        return;
    }
    
    private static RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        
        RandomListNode node, newNode, originNext;
        RandomListNode dummyNewHead = new RandomListNode(-1);
        
        /*
         * Initialize the new list,
         * 1) newNode.next = NEW_NODE(OLD.next)
         * 2) newNode.random = OLD
         */
        node = head;
        newNode = dummyNewHead;
        while (node != null) {
            newNode.next = new RandomListNode(node.label);
            newNode.next.random = node;
            
            newNode = newNode.next;
            node = node.next;
        }
        
        // Link OLD.next to NEW
        node = head;
        newNode = dummyNewHead.next;
        while (node != null) {
            originNext = node.next;
            node.next = newNode;
            
            node = originNext;
            newNode = newNode.next;
        }
        
        /*
         * Set NEW.random and be ready to restore the old list
         * 1) NEW.random = OLD.random.next
         *         - OLD.random.next = The copy of OLD.random, which is what NEW.random should link to
         *         - OLD = NEW.random
         * 2) Store the pointers of NEXT for each OLD in a queue
         */
        newNode = dummyNewHead.next;
        LinkedList<RandomListNode> originNexts = new LinkedList<RandomListNode>();
        while (newNode != null) {
            originNext = (newNode.next == null)? null : newNode.next.random;
            originNexts.add(originNext);
            
            newNode.random = (newNode.random.random == null)?  null : newNode.random.random.next;
            newNode = newNode.next;
        }
        
        // Restore the origin list
        node = head;
        while (node != null) {
            node.next = originNexts.poll();
            node = node.next;
        }
        
        return dummyNewHead.next;
    }

    @Override
    public boolean test() {
        for (int index = 0; index < testSuite.length; index++) {
            RandomListNode newHead = copyRandomList(testSuite[index]);
            
            RandomListNode node = testSuite[index];
            RandomListNode newNode = newHead;
            
            while (node != null) {
                if (node.label != newNode.label)
                    return false;

                if ((node.random == null && newNode.random != null)
                        || (node.random != null && newNode.random == null)) {
                    System.out.println("Failed");
                    return false;
                } else if (node.random == null && newNode.random == null) {
                    // do nothing
                } else if (node.random.label != newNode.random.label) {
                    System.out.println("Failed");
                    return false;
                }

                node = node.next;
                newNode = newNode.next;
            }
        }

        return true;
    }

    private static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) {
            this.label = x;
        }
    }
}
