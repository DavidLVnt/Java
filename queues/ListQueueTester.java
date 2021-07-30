package queues;

import exceptions.EmptyCollectionException;
import queues.LinkedQueue;

public class ListQueueTester {

	public static void main(String args[]) {

		ListQueue<String> lqueue = new ListQueue<String>();

		System.out.println("Test empty queue");
		localFirst(lqueue);
		localDequeue(lqueue);

		System.out.println("Queue[]: " + lqueue);
		System.out.println("Size[0]: " + lqueue.size());

		System.out.println("Empty[true]: " + lqueue.isEmpty());
		
		// test enqueuing
		
		System.out.println("\nTest enqueue ");
		System.out.println("Enqueue A.  ");
		lqueue.enqueue("A");
		System.out.println("Empty[false]: " + lqueue.isEmpty());
		System.out.print("First[A]: ");
		localFirst(lqueue);

		System.out.print("\nEnqueue B.  ");
		lqueue.enqueue("B");
		System.out.print("First[A]: ");
		localFirst(lqueue);

		System.out.print("Enqueue C.  ");
		lqueue.enqueue("C");
		System.out.print("First[A]: ");
		localFirst(lqueue);

		System.out.println("Queue [A B C]: " + lqueue);
		System.out.println("Size[3]: " + lqueue.size());

		System.out.print("\nTest dequeue with elements");
		localDequeue(lqueue);
		System.out.print("First[B]: ");
		localFirst(lqueue);
		System.out.println("Size[2][B C]: " + lqueue.size() + " " + lqueue);
		
		localDequeue(lqueue);
		System.out.print("First[C]: ");
		localFirst(lqueue);
		System.out.println("Size[1][C]: " + lqueue.size() + " " + lqueue);

		localDequeue(lqueue);
		System.out.print("First[]: ");
		localFirst(lqueue);
		System.out.println("Size[0][]: " + lqueue.size() + " " + lqueue);
	}

	public static void localFirst(QueueADT<String> lqueue) {

		try {
			System.out.println(lqueue.first());
		}

		catch (EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());

		}
	}



	public static void localDequeue(QueueADT<String> lqueue) {

		try {
			System.out.println("\nDequeue element " + lqueue.first() + ": " + lqueue.dequeue());
		}

		catch (EmptyCollectionException ex) {
			System.out.println("Exception: " + ex.getMessage());

		}
	}
}


