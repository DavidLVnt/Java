package queues;

import exceptions.EmptyCollectionException;
import queues.LinkedQueue;

public class LinkedQueueTester {


	public static void main(String args[]) {

		LinkedQueue<String> lqueue = new LinkedQueue<String>();
		
		localFirst(lqueue);
		localDequeue(lqueue);
		
		System.out.println("\nQueue[]: " + lqueue);
		System.out.println("Size[0]: " + lqueue.size());

		System.out.println("Empty[true]: " + lqueue.isEmpty());
		System.out.println("\nEnqueue A.  ");
		lqueue.enqueue("A");
		System.out.println("Empty[false]: " + lqueue.isEmpty());
		System.out.print("First[A]: ");
		localFirst(lqueue);
		
		System.out.print("\nEnqueue B.  ");
		lqueue.enqueue("B");
		System.out.print("First[A]: ");
		localFirst(lqueue);
		
		System.out.print("\nEnqueue C.  ");
		lqueue.enqueue("C");
		System.out.print("First[A]: ");
		localFirst(lqueue);
		
		System.out.println("\nQueue: " + lqueue);
		System.out.println("Size[3]: " + lqueue.size());
		
		localDequeue(lqueue);
		System.out.print("First[B]: ");
		localFirst(lqueue);
		
		System.out.println("Size[2]: " + lqueue.size());
		System.out.println("The position at 2 is: " + lqueue.elementAtPosition(0));

	}
	
	public static void localFirst(LinkedQueue<String> lqueue) {
		
		try {
			System.out.println(lqueue.first());
		}
		
		catch (EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());
			
		}
	}


	
	public static void localDequeue(LinkedQueue<String> lqueue) {
		
		try {
			System.out.println("\nDequeue element " + lqueue.first() + ": " + lqueue.dequeue());
		}
		
		catch (EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());
			
		}
	}
}
