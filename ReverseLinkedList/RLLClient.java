package com.greatlearning.ReverseLinkedList;

import java.util.NoSuchElementException;

public class RLLClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RLLImplementation ll = new RLLImplementation();
		
		ll.add(10);
		ll.add(20);
		ll.add(30);
		ll.add(40);
		ll.add(45);
		
		ll.display();
		
		ll.getHead();
		
		ll.getTail();
		
		ll.search(20);
		
		ll.search(25);
		
		try {
			System.out.println( ll.remove(35) + " deleted!");
		} catch(NoSuchElementException e) {
			System.out.println( "Error : " + e.getMessage() );
		}
		
		ll.display();
		
		ll.reverse();
		
		ll.display();

	}

}
