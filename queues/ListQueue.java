package queues;

import lists.LinkedUnorderedList;

public class ListQueue<T> implements QueueADT<T> {
	LinkedUnorderedList<T> queue;

	@Override
	public void enqueue(T element) {
		// TODO Auto-generated method stub
		queue.addToRear(element);
		
	}

	@Override
	public T dequeue() {
		// TODO Auto-generated method stub
		
		//T retElement = queue.getData(element);
		//queue.remove(element);
		return queue.removeFirst();
		
		
	}

	@Override
	public T first() {
		// TODO Auto-generated method stub
		return queue.first();
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		
		return queue.size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return queue.size();
	}
	
	public String toString() {
		return queue.toString();
	}

}
