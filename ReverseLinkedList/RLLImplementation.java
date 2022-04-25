package com.greatlearning.ReverseLinkedList;

import java.util.NoSuchElementException;

public class RLLImplementation {
	
	CustomLinkedList head, tail;
	
	RLLImplementation() {
		this.head = null;
	}
	
	public void add(int data) {
		this.head = add(this.head, data);	
	}

	private CustomLinkedList add(CustomLinkedList node, int data) {
		
		if(node == null) {
			CustomLinkedList newNode = new CustomLinkedList(data);
			this.tail = newNode;
			return newNode;
		} else {
			node.next = add(node.next, data);
		}
		
		return node;
	}
	
	public void reverse() {
		
		CustomLinkedList current = this.head;
		CustomLinkedList previous = null;
		CustomLinkedList temp;
		
		while(current.next != null) {
			temp = current.next;
			current.next = previous;
			previous = current;
			current = temp;
		}
		
		this.head = current;
		this.head.next = previous;
		
	}

	public int remove(int data) {
		
		if(this.head.data == data) {
			this.head = this.head.next;
			if(this.tail.data == data)
				this.tail = null;
		} else {
			
			CustomLinkedList currentNode, previousNode;
			currentNode = previousNode = this.head;
			
			while(currentNode != null && currentNode.data != data) {	
				previousNode = currentNode;
				currentNode = currentNode.next;
			}
			
			if(currentNode == null)
				throw new NoSuchElementException("Cannot delete " + data + ". Element not found!");
			
			if(this.tail.data == data)
				this.tail = previousNode;
			
			previousNode.next = currentNode.next;
			
		}
		
		return data;
	}
	
	public void search(int data) {
		CustomLinkedList node = search(this.head, data);
		if(node == null) {
			System.out.println(data + " not found in list!");
		} else {
			System.out.println(data + " found in list!");
		}
	}
	
	private CustomLinkedList search(CustomLinkedList node, int data) {
		
		if(node == null)
			return null;
		
		if(node.data == data)
			return node;
		else
			return search(node.next, data);
		
	}
	
	public void display() {
		CustomLinkedList node = this.head;
		while(node != null) {
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		
		System.out.print("X\n");
	}
	
	public void getHead() {
		if(this.head != null)
			System.out.println("LinkedList Head = " + this.head.data);
	}
	
	public void getTail() {
		if(this.tail != null)
			System.out.println("LinkedList Tail = " + this.tail.data);
	}

}
