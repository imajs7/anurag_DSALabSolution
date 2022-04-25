package com.greatlearning.ReverseLinkedList;

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
		
		System.out.println( ll.remove(45) + " deleted!");
		
		ll.display();
		
		ll.reverse();
		
		ll.display();

	}

}
