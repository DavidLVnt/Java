package stacks;

import exceptions.EmptyCollectionException;

public class ListStackTester {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListStack<String> ls = new ListStack<String>();
		
		//test empty stack
				
		System.out.println("Test Empty");
		System.out.println("Empty stack()[] : " + ls);
		
		try {
			System.out.println(ls.peek());
		}
		catch (EmptyCollectionException ex) {
			System.out.println("Exception empty stack: " + ex.getMessage());
		}
		
		
		// test push
		System.out.println("\nTest Push");
		ls.push("A");
		System.out.println("Push A [A]: " + ls);
		System.out.println("peek()[A] : " + ls.peek());
		
		ls.push("W");
		System.out.println("Push W [W A]: " + ls);
		System.out.println("peek()[W] : " +ls.peek());
		ls.push("J");
		System.out.println("Push J [J W A]: " + ls);
		System.out.println("peek()[J] : " + ls.peek());
		System.out.println("size()[3] : " + ls.size());
		System.out.println("Stack[J,W,A] : " + ls);
	
		// test pop
		System.out.println("\nTest pop");
		System.out.println("pop()[J] : " + ls.pop());
		System.out.println("pop()[W] : " + ls.pop());
		System.out.println("peek()[A] : " + ls.peek());
		ls.push("B");
		System.out.println("Push B [B A]: " + ls);
		System.out.println("peek()[B] : " + ls.peek());
	
		// have two elements left in stack
		System.out.println("\nPop last two elements [B A] : " + ls);
		System.out.println("pop()[B] : " + ls.pop());
		System.out.println("pop()[A] : " + ls.pop());

		// stack is empty
		System.out.println("isEmpty() [true]: " + ls.isEmpty());
		try {
			System.out.println("pop()[null] : " + ls.pop());
		}
		catch (EmptyCollectionException ex) {
			System.out.println("Exception empty stack: " + ex.getMessage());
		}
		
		System.out.println(ls);
		
		//
	}

}


