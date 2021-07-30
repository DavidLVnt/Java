/**
 * 
 */
package queues;
import support.SLNode;
import exceptions.EmptyCollectionException;
import exceptions.InvalidPositionException;

/**
 * @author Dung Luong
 *
 */
public class LinkedQueue<T> implements QueueADT<T> {
	
	SLNode<T> front;
	SLNode<T> rear;
	int count;
	
	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		
		SLNode<T> newNode = new SLNode<T>(element);
		
		if (isEmpty()) {
			front = newNode;
			rear = newNode;
			
			
		}else {
			rear.setNextNode(newNode);
			rear = newNode;
			
		}	
		count++;
	}
	
	@Override
	public T dequeue() throws EmptyCollectionException{
		// TODO Auto-generated method stub
		
		T retElement;
		if(isEmpty()) {
			throw new EmptyCollectionException("Linked Queue");
			
		}else {
			retElement = front.getData();
			front = front.getNextNode();
				if (front == null) {
					rear = null;
				}
			count--;
						
		}
		return retElement;
	}
	
	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("Linked Queue");
		}
		else {
				return front.getData();
		}
	}
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return count == 0;
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	
	@Override
	public String toString() {
		String reString = "[";
		SLNode<T> currentNode = front;
		
		while(currentNode != null) {
			reString += currentNode.getData();			
			reString += ", ";			
			currentNode = currentNode.getNextNode();
		}
		return reString + "]";
	}
	
	public T elementAtPosition(int position)  throws EmptyCollectionException {
		SLNode<T> currentNode = front;
		int count = 1;

		if (isEmpty()) {
			throw new EmptyCollectionException("Linked Queue");
		}
		if(position < 0 || position > size()){
			throw new InvalidPositionException("Linked Queue");
		} 
		
			while(currentNode != null) {
				if (count == position) {
					return currentNode.getData();
				}else {		

					count++;
					currentNode = currentNode.getNextNode();
				}	
			}
		return currentNode.getData() ;
	}
}
