package lists;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.EmptyCollectionException;

public abstract class ArrayAList<T> implements ListADT<T>, Iterable<T> {

	private final static int DEF_CAP = 5;
	protected final static int FRONT = 0;

	protected int rear;
	protected T[] list;
	protected int count;
	protected int modCount;

	public ArrayAList() {

		rear = -1;
		count = 0;
		modCount = 0;
		list = (T[]) (new Object[DEF_CAP]);
	}

	@Override
	public T removeFirst() {
		// TODO Auto-generated method stub
		T retElement;
		if (isEmpty())
			throw new EmptyCollectionException("list");
		
		retElement = list[FRONT];
		
		// shift elements
		for (int i=0; i < count-1; ++i) {
			list[i] = list[i+1];
		}
		
		list[rear] = null;
		count--;
		rear--;
		modCount++;
		
		return retElement;
	}

	@Override
	public T removeLast() {
		// TODO Auto-generated method stub
		T retElement;
		if (isEmpty())
			throw new EmptyCollectionException("list");
		
		// no need to shift elements, we are removing the last element in the list
		// clean the array location in the rear regardless
		retElement = list[rear];
		list[rear] = null;
		count--;
		rear--;
		modCount++;
		
		return retElement;		
	}

	@Override
	public T remove(T element) {
		// TODO Auto-generated method stub
		T retElement;
		int elemIndex;
		
		if (isEmpty())
			throw new EmptyCollectionException("list");
		
		elemIndex = findElementIndex(element);

		
		// hold on to the element to remove
		retElement = list[elemIndex];
		
		// shift elements
		for (int i = elemIndex; i < count-1; ++i) {
			list[i] = list[i+1];
		}
		
		list[rear] = null;
		count--;
		rear--;
		modCount++;
		
		return retElement;	
	}

	@Override
	public T first() {

		if (isEmpty())
			throw new EmptyCollectionException("list");
		
		return list[FRONT];
	}

	@Override
	public T last() {
		
		if (isEmpty())
			throw new EmptyCollectionException("list");
		
		return list[rear];
	}

	@Override
	public boolean contains(T element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {

		return (size() == 0);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}

	protected boolean isFull() {
		return (size() == list.length);
	}

	protected void growList() {
		// create a larger array newList
		// copy all elements of list into newList array
		// update the list reference to point to newList

		T[] newList = (T[]) (new Object[size() + DEF_CAP]);
		
		for (int i = 0; i < size(); i++) {
			newList[i] = list[i];
		}
		
		list = newList;

	}

	protected void shiftElements(int startingIndex) {
		// shift elements so that the index location at
		// starting index is open for the new element

		T temp;
		for (int i = size(); i > startingIndex; i--) {
			list[i] = list[i-1];
		}
		list[startingIndex] = null;
	}

	protected int findElementIndex(T element) {
		// find the index location of element T
		// if the 

		int index = 0;
		if (isEmpty()) {
			return -1;
		}
		else {
			while (index < size() && list[index] != element) {
				index++;				
			}
		}
		if (index >= size()) 
			return -1;
		else
			return index;
	}


	public String toString() {
		String retString = "[";

		for (int i=0; i<size(); i++) {
			retString += list[i];
			retString += " ";
		}

		retString += "]";

		return retString;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new ArrayListIterator();
	}
	
	// private iterator class
	private class ArrayListIterator implements Iterator<T> {
		int iteratorModCount;
		int current;
		
		/**
		 * Sets up this iterator using the specified modCount.
		 * 
		 * @param modCount the current modification count for the ArrayList
		 */
		public ArrayListIterator()
		{
			iteratorModCount = modCount;
			current = 0;
		}
		
		/**
		 * Returns true if this iterator has at least one more element
		 * to deliver in the iteration.
		 *
		 * @return  true if this iterator has at least one more element to deliver
		 *          in the iteration
		 * @throws  ConcurrentModificationException if the collection has changed
		 *          while the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException
		{
			if (iteratorModCount != modCount)
				throw new ConcurrentModificationException();
			
			return (current <= rear);
		}
		
		/**
		 * Returns the next element in the iteration. If there are no
		 * more elements in this iteration, a NoSuchElementException is
		 * thrown.
		 *
		 * @return  the next element in the iteration
		 * @throws  NoSuchElementException if an element not found exception occurs
		 * @throws  ConcurrentModificationException if the collection has changed
		 */
		public T next() throws ConcurrentModificationException
		{
			if (!hasNext())
				throw new NoSuchElementException();
			
			current++;
			
			return list[current - 1];
		}
		
		/**
		 * The remove operation is not supported in this collection.
		 * 
		 * @throws UnsupportedOperationException if the remove method is called
		 */
		public void remove() throws UnsupportedOperationException
		{
			throw new UnsupportedOperationException();
		}
		
	}
}
