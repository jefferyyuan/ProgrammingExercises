package com.cllin.leetcode;

import com.cllin.main.LeetCodeExercise;

/*
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example:
 * Given 1 -> 2 -> 3 -> 4 -> 5 -> NULL, m = 2 and n = 4,
 * return 1->4->3->2->5->NULL.
 * 
 * Note:
 * Given m, n satisfy the following condition:
 * 1 <= m <= n <= length of list.
 * 
 * Source: http://oj.leetcode.com/problems/reverse-linked-list-ii/
 */

public class ReverseLinkedListII implements LeetCodeExercise {
    private final TestCase[] testSuite = {
            new TestCase(0, 0, 0),
            new TestCase(5, 2, 4),
            new TestCase(2, 1, 2),
            new TestCase(1, 1, 1)
    };
    
    private ListNode head;
    private int M;
    private int N;

    @Override
    public void initialize() {
//        TODO
    }

    @Override
    public void run() {
        initialize();
        
        for (TestCase test : testSuite) {
            M = test.M;
            N = test.N;
            head = reverseBetween(test.head, test.M, test.N);
            if (!test()) System.out.println("Failed");
        }
        
    }
    
    private ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        
        int count = 1;
        ListNode prev = null;
        ListNode node = head;
        ListNode next = null;
        ListNode prevM = null;
        ListNode N = null;
        while (node != null) {
            if (count == m) {
                prevM = prev;
                N = node;
            }
            
            if (m <= count && count <= n) {
                next = node.next;
                node.next = prev;
                prev = node;
                
                if (count == n) {
                    if (prevM == null) head = prev;
                    else prevM.next = prev;
                    
                    N.next = next;
                }
                
                node = next;
            } else {
                prev = node;
                node = node.next;
            }
            
            count++;
        }
        
        return head;
    }

    @Override
    public boolean test() {
        int prev = 0;
        ListNode node = head;
        
        for (int i = 1; node != null; i++) {
            if (M < i && i <= N) {
                if (prev < node.val) return false;
                prev = node.val;
            } else {
                if (prev > node.val) return false;
                prev = node.val;                
            }
            
            if (node.next != null) System.out.printf("%d -> ", node.val);
            else System.out.printf("%d", node.val);
            node = node.next;
        }
        
        System.out.println();
        return true;
    }
    
    private class TestCase {
        int M;
        int N;
        ListNode head;

        TestCase(int length, int m, int n) {
            this.M = m;
            this.N = n;
            head = null;
            
            if (length > 0) {
                head = new ListNode(1);
                ListNode node = head;
                for (int i = 2; i <= length; i++) {
                    node.next = new ListNode(i);
                    node = node.next;
                }
            }
        }
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
