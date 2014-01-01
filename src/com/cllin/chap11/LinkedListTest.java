package com.cllin.chap11;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.cllin.list.LinkedList;

public class LinkedListTest {
	private LinkedList mLinkedList;
	
	private String apple = "apple";
	private String banana = "banana";
	
	@Before
	public void initialization(){
		mLinkedList = new LinkedList(apple);
	}
	
	@Test
	public void getNodeTest(){
		assertNotNull("Exists an element contains 'apple'", mLinkedList.getNode(apple));
		assertNull("Does not exist an element contains 'banana'", mLinkedList.getNode(banana));
	}
	
	@Test
	public void addNodeTest(){
		int prev = mLinkedList.getSize();
		
		mLinkedList.addNode(mLinkedList.getNode(apple), banana);
		assertNotNull("After inserting, exists an element contains 'banana'", mLinkedList.getNode(banana));
		assertEquals(prev + 1, mLinkedList.getSize());
	}
	
	@Test
	public void deleteNodeTest(){
		assertNull(mLinkedList.getNode(banana));
		
		mLinkedList.addNode(mLinkedList.getNode(apple), banana);
		assertNotNull(mLinkedList.getNode(banana));
		int prev = mLinkedList.getSize();
		
		mLinkedList.deleteNode(mLinkedList.getNode(banana));
		assertNull("After deleting, does not exist an element contains 'banana'", mLinkedList.getNode(banana));
		assertEquals(prev - 1, mLinkedList.getSize());
	}
}
