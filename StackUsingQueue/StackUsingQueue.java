package com.greatlearning.StackUsingQueue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class StackUsingQueue {
	
	Queue<Integer> q1;
	Queue<Integer> q2;
	
	StackUsingQueue(){
		q1 = new LinkedList<Integer>();
		q2 = new LinkedList<Integer>();
	}
	
	public void push(int data) {
		if( q1.isEmpty() )
			q1.add(data);
		else {
			
			int sizeOfq1 = q1.size();
			
			for(int i = 0; i < sizeOfq1; i++) {
				q2.add( q1.remove() );
			}
			
			q1.add(data);
			
			int sizeOfq2 = q2.size();
			
			for(int i = 0; i < sizeOfq2; i++) {
				q1.add( q2.remove() );
			}
		}
	}
	
	public boolean isEmpty() {
		return q1.isEmpty();
	}
	
	public int getSize() {
		return q1.size();
	}
	
	public void display() {
		Iterator<Integer> itr = q1.iterator();
		
		while ( itr.hasNext() )
			System.out.print(itr.next() + " ");
	}
	
	public int pop() {
		if( q1.isEmpty())
			throw new NoSuchElementException("Cannot pop. The stack is empty!");
		
		return q1.remove();
	}

}
