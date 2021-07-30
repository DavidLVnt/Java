package queues;

import exceptions.EmptyCollectionException;
import exceptions.InvalidPositionException;
import support.SLNode;

public class CircularArrayQueue<T> implements QueueADT<T> {

	private static final int DEF_CAP = 5;
	private int front;
	private int rear;
	private int count;
	private T[] queue;

	public CircularArrayQueue() {
		front = -1;
		rear = -1;
		count = 0;
		queue = (T[]) (new Object[DEF_CAP]);
	}

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			// enq the first element
			front = (front + 1) % queue.length;
			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			count++;
		}

		else {
			// enq additional elements
			if (isFull()) {
				System.out.println("calling grow");
				growQueue();
			}

			rear = (rear + 1) % queue.length;
			queue[rear] = element;
			count++;
		}

	}

	private boolean isFull() {
		// TODO Auto-generated method stub
		return (count == queue.length);
	}

	private void growQueue() {
		// create a larger queue
		T[] newQueue = (T[]) (new Object[queue.length + DEF_CAP]);
		int sourceIndex;

		// copy all the elements

		sourceIndex = front;
		for (int i = 0; i < count; i++) // i is destination index
		{
			newQueue[i] = queue[sourceIndex];
			sourceIndex = (sourceIndex + 1) % queue.length;
		}

		front = 0;
		rear = count-1;
		queue = newQueue;
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		
		T retElement;
		
		if (isEmpty())
			throw new EmptyCollectionException("ArrayQueue");
		
		else {
			retElement = queue[front];
			queue[front] = null;
			front = (front + 1) % queue.length;
			count--;
			
			if (isEmpty()) {
				front = -1;
				rear = -1;
			}
			
		}
		
		return retElement;
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			throw new EmptyCollectionException("ArrayQueue");
		}
		
		T retElement = queue[front];
		return retElement;		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (count == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	@Override
	public String toString() {
		String retString = "[";
		// your code here
		for (int i = front; i != rear; i = (i + 1) % queue.length) {
			retString += queue[i] + ", ";
			
		}
		retString += queue[rear] + "]";
		return retString;
	}
	
	public T elementAtPosition(int position) throws EmptyCollectionException {
		T retElement = null ;
		int index;

		if (isEmpty()) {
			throw new EmptyCollectionException("Array Queue");
		}
		
		if (position < 0 || position > size())  {
			throw new InvalidPositionException("index Array Queue");
		} else
			
			index = front;
			for(int i = 1; i < position; i++) {
				index = (index + 1) % queue.length;
			}
					retElement = queue[index];
					return retElement;			
		

	}
}
