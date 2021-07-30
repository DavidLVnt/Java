/**
 * 
 */
package queues;

import exceptions.EmptyCollectionException;

/**
 * @author perla
 *
 */
public class ArrayQueueTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CircularArrayQueue<String> q = new CircularArrayQueue<String>();
		
		localFirst(q);
		System.out.println("Array size: " + q.size());
		
		System.out.println("Add element W. ");
		q.enqueue("W");
		System.out.print("First[W]: ");
		localFirst(q);
		
		q.enqueue("J");
		System.out.println("Array size: " + q.size());

		q.enqueue("A");
		q.enqueue("B");
		q.enqueue("D");
		
		System.out.println("Array size: " + q.size());
		q.dequeue();
		System.out.print("First [J]: ");  
		localFirst(q); 
		
		q.dequeue();
		System.out.print("First [A]: ");  
		localFirst(q);
		System.out.println("Array size: " + q.size());
		System.out.println(q);

		
		q.enqueue("4");
		System.out.print("First [A]: ");  
		localFirst(q);


		q.enqueue("C");
		q.enqueue("K");
		q.enqueue("M");
		q.enqueue("G");
		System.out.println("Front element: ");  
		localFirst(q);
		

		q.dequeue();
		q.dequeue();
		
		q.enqueue("z");
		q.enqueue("a");
		q.enqueue("b");  // should cause to grow
		
		
		System.out.println(q);
		System.out.println("The position at 2 is: " + q.elementAtPosition(2));

	}
		
		public static void localFirst(CircularArrayQueue<String> q) {
			
			try {
				System.out.println(q.first());
			}
			
			catch (EmptyCollectionException ex) {
				System.out.println("Exception: " + ex.getMessage());
				
			}
		}

	

}
