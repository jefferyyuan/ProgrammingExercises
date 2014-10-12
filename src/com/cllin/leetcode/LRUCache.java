package com.cllin.leetcode;

import java.util.Hashtable;

import com.cllin.main.LeetCodeExercise;

/*
 * Design and implement a data structure for Least Recently Used (LRU) cache. 
 * It should support the following operations: get and set.
 * 
 * get(key) -             Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * set(key, value) -     Set or insert the value if the key is not already present. 
 *                         When the cache reached its capacity, 
 *                         it should invalidate the least recently used item before inserting a new item.
 * 
 * Source: http://oj.leetcode.com/problems/lru-cache/
 */

public class LRUCache extends LeetCodeExercise {

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
    }

    @Override
    public void run() {
        test();
    }

    @SuppressWarnings("unused")
    @Override
    public boolean test() {
        Cache cache;
        int value;
        
//        TEST 1:
        cache = new Cache(10);
        cache.set(1,1);
        cache.set(2,2);
        cache.set(3,3);
        cache.set(4,4);
        cache.get(4);
        cache.get(3);
        cache.get(2);
        cache.get(1);
        cache.set(5,5);
        cache.get(1);
        cache.get(2);
        cache.get(3);
        cache.get(4);
        cache.get(5);
        
//        TEST 2: (1, -1, 2)
        cache = new Cache(1);
        cache.set(2,1);
        value = cache.get(2);
        cache.set(3,2);
        value = cache.get(2);
        value = cache.get(3);

//        TEST 3: (2, -1)
        cache = new Cache(2);
        cache.set(2,1);
        cache.set(2,2);
        value = cache.get(2);
        cache.set(1,1);
        cache.set(4,1);
        value = cache.get(2);
        
//        TEST 4: (2, 1, 1, -1, 3)
        cache = new Cache(2);
        cache.set(2,1);
        cache.set(3,2);
        value = cache.get(3);
        value = cache.get(2);
        cache.set(4,3);
        value = cache.get(2);
        value = cache.get(3);
        value = cache.get(4);
        
        return true;
    }

    private class Cache {
        private int size = 0;
        private int capacity = Integer.MAX_VALUE;
        private Hashtable<Integer, Node> cache = new Hashtable<Integer, Node>();
        
        private Node head = null;
        private Node tail = null;
        
        private Cache(int capacity) {
            this.capacity = capacity;
            size = 0;
            cache = new Hashtable<Integer, Node>();
        }
        
        private int get(int key) {
            if (!cache.containsKey(key)) return -1;
            
            Node node = cache.get(key);
            removeNode(node);
            setHead(node);
            
            return node.value;
        }
        
        private void set(int key, int value) {
            if (cache.containsKey(key)) {
                Node node = cache.get(key);
                node.value = value;
                
                removeNode(node);
                setHead(node);
            } else {
                Node node = new Node(key, value);
                
                if (size < capacity) {
                    size++;
                } else {
                    cache.remove(tail.key);
                    tail = tail.previous;
                    
                    if (tail != null) {
                        tail.next = null;
                    }
                }
                setHead(node);
                cache.put(key, node);
            }
        }
        
        private void removeNode(Node node) {
            Node prev = node.previous;
            Node post = node.next;
            
            if (prev != null) {
                prev.next = post;
            } else {
                head = post;
            }
            
            if (post != null) {
                post.previous = prev;
            } else {
                tail = prev;
            }
        }
        
        private void setHead(Node node) {
            node.next = head;
            node.previous = null;
            
            if (head != null) {
                head.previous = node;
            }
            
            head = node;
            
            if (tail == null) {
                tail = node;
            }
        }
    }
    
    private class Node {
        int key;
        int value;
        Node previous;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
