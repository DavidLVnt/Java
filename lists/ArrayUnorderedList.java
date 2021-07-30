package lists;

import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class ArrayUnorderedList<T> extends ArrayAList<T> implements UnorderedListADT<T> {

	/**
	 * Add a new element at the front of the list
	 */
	@Override
	public void addToFront(T element) {
		// call growList if full
		// shift all elements from the front forward
		// add element at front
		
		if (isFull()) {
			growList();
		}	
		
		shiftElements(FRONT);
		rear++;
		list[FRONT] = element;
		count++;
		
	}

	
	/**
	 * Add a new element at the end of the list
	 */
	@Override
	public void addToRear(T element) {
		// call growList if full
		// add element at rear
		
		if (isFull()) {
			growList();
		}
		
		rear++;
		list[rear] = element;
		count++;
		
		
	}

	/**
	 * Add a new element after an existingElement in the list
	 * Throw an EmptyCollectionException if the existingElement is not in the list
	 * Throw an ElementNotFoundException if the element is not found
	 */
	@Override
	public void addAfter(T existingElement, T element) {
		// add an element after an existingElement
		// if empty throw exception
		// if element not found throw exception
		// if full growList
		
		// if element is found in position, shift elements from position+1 (after)
		// insert element at position+1
		
		int position;

		if (isEmpty()) {
			throw new EmptyCollectionException("Array List");
		}
		
		position = findElementIndex(existingElement);

		if (position == -1)
			throw new ElementNotFoundException("Array List");
		
		// shifting and adding from position+1, increase position here
		position++;
		
		if (isFull()) {
			growList();
		}
		
		shiftElements(position);
		
		rear++;
		list[position] = element;
		count++;		
	}



}
