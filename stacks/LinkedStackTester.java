package stacks;

import exceptions.EmptyCollectionException;

public class LinkedStackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedStack<String> ls = new LinkedStack<String>();
		
		System.out.println("stack()[] : " + ls);
		
		
		try {
		System.out.println("peek on empty: " + ls.peek());
		}
		catch (EmptyCollectionException ex){
			System.out.println("Exception: " + ex.getMessage());
		}
		
		try {
		ls.pop();		
		System.out.println("pop empty stack: " + ls.pop());
		}
		catch(EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		ls.push("A");
		System.out.println("peek()[A] : " + ls.peek());
		
		ls.push("W");
		System.out.println(ls.peek());
		ls.push("J");
		System.out.println(ls.peek());
		ls.push("M");
		ls.push("N");
		System.out.println("size()[5] : " + ls.size());
		System.out.println("Stack[N,M,J,W,A] : " + ls);
	
		// test pop
		System.out.println("\npop()[N] : " + ls.pop());
		System.out.println("pop()[M] : " + ls.pop());
		System.out.println("peek()[J] : " + ls.peek());
		ls.push("B");
		System.out.println("peek()[B] : " + ls.peek());
		System.out.println("size()[4] : " + ls.size());

	
		// have two elements left in stack
		System.out.println("pop()[B] : " + ls.pop());
		System.out.println("pop()[J] : " + ls.pop());
		System.out.println("Checked isEmpty() [false]: " + ls.isEmpty());
		System.out.println("pop()[W] : " + ls.pop());
		System.out.println("pop()[A] : " + ls.pop());


		// stack is empty
		try {
		System.out.println("pop()[null] : " + ls.pop());
		}
		catch(EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());
		}
		System.out.println("Checked isEmpty() [true]: " + ls.isEmpty());
		
		System.out.println(ls);
		
		//
	}

}
