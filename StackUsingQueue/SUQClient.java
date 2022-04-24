package com.greatlearning.StackUsingQueue;

import java.util.Scanner;

public class SUQClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
StackUsingQueue stack = new StackUsingQueue();
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Stack Implementation Using Two Queues\n");
		
		char choice;
		
		do {
			System.out.println("Stack Operations");
			System.out.println("1. push");
			System.out.println("2. pop");
			System.out.println("3. check empty");
			System.out.println("4. size");
			int opt = input.nextInt();
			
			switch(opt) {
			
				case 1: System.out.print("Enter the value to be pushed: ");
						stack.push(input.nextInt());
						break;
						
				case 2: try {
							System.out.println( "Popped Element = " + stack.pop() );
						} catch (Exception e) {
							System.out.println( "Error : " + e.getMessage() );
						}
						break;
						
				case 3:	System.out.println( "Empty status = " + stack.isEmpty() );
						break;
						
				case 4:	System.out.println( "Size = " + stack.getSize() );
						break;
						
				default:System.out.println("Enter a valid option!");
			
			}
			
			
			System.out.print("Do you want to continue (Type y or n) ");
			choice = input.next().charAt(0);
			
		} while(choice == 'Y' || choice == 'y');
		
		input.close();

	}

}
