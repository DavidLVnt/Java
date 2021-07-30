package lists;


import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import support.SLNode;

public abstract class LinkedAList<T> implements ListADT<T> {

	SLNode<T> front;
	SLNode<T> rear;
	int count;
	protected int modCount;

	public LinkedAList() {
		front = null;
		rear = null;
		count = 0;
		modCount = 0;
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub

		if (isEmpty()) 
			throw new EmptyCollectionException("Linked List");

		T remElement = front.getData();
		front = front.getNextNode();
		count--;
		modCount++;

		if (isEmpty())
			rear = null;

		return remElement;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		SLNode<T> prev;

		if (isEmpty()) 
			throw new EmptyCollectionException("Linked List");

		T remElement = rear.getData();
		count--;
		modCount++;

		if (isEmpty()) {
			front = null;
			rear = null;
		}
		else {
			prev = findPrevious(remElement);
			rear = prev;
			rear.setNextNode(null);
		}
		return remElement;
	}


	@Override
	public T remove(T element) {
		// 
		SLNode<T> prev;
		SLNode<T> rem;
		T remElement;

		if (isEmpty()) 
			throw new EmptyCollectionException("Linked List");

		if (front.getData().equals(element))
			return removeFirst();

		if (rear.getData().equals(element))
			return removeLast();

		prev = findPrevious(element);

		if (prev == null) 
			throw new ElementNotFoundException("Linked List");

		rem = prev.getNextNode();
		remElement = rem.getData();
		prev.setNextNode(rem.getNextNode());
		count--;
		modCount++;

		return remElement;
	}


	protected SLNode<T> findPrevious(T element) {
		// TODO Auto-generated method stub

		SLNode<T> currNode = front;
		SLNode<T> prevNode = null;

		while ((currNode != null) && (currNode.getData() != element)) {
			prevNode = currNode;
			currNode = currNode.getNextNode();
		}

		if (currNode == null)
			return null;

		return prevNode;
	}


	@Override
	public T first() {
		// 
		if (isEmpty()) 
			throw new EmptyCollectionException("Linked List");

		return front.getData();
	}

	@Override
	public T last() {
		//
		if (isEmpty()) 
			throw new EmptyCollectionException("Linked List");

		return rear.getData();
	}

	@Override
	public boolean contains(T element) {
		// 
		boolean found = false;

		SLNode<T> curr = front;

		while (curr != null) {
			if (curr.getData().equals(element))
				found = true;
			curr = curr.getNextNode();
		}

		return found;
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

	public String toString() {
		String retString = "[";

		SLNode<T> currNode = front;

		while (currNode != null) {
			retString += currNode.getData();
			retString += " ";
			currNode = currNode.getNextNode();
		}

		retString += "]";

		return retString;
	}
	
	@Override
	public Iterator<T> iterator(){
		return new LinkedListIterator();
		
	}

	private class LinkedListIterator implements Iterator<T> {
		int iteratorModCount;
		SLNode<T> current = front;
		
		public LinkedListIterator() {
			iteratorModCount = modCount;
			
			
		}
		
		public boolean hasNext() throws ConcurrentModificationException {
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (current != null);
		}

		@Override
		public T next() throws ConcurrentModificationException {
			// TODO Auto-generated method stub
			if (!hasNext()) throw new NoSuchElementException();
			
			T retElement= current.getData();
			current = current.getNextNode();
			
			return retElement;
		}
		
		public void remove() throws UnsupportedOperationException{
			throw new UnsupportedOperationException();
		
		}
	}
}
