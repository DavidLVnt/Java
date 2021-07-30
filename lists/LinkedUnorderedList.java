package lists;

import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import support.SLNode;

public class LinkedUnorderedList<T> extends LinkedAList<T> implements UnorderedListADT<T> {

	@Override
	public void addToFront(T element) {
		// TODO Auto-generated method stub
		
		SLNode<T> newNode = new SLNode<T>(element);

		if (isEmpty())
			rear = newNode;
		
		newNode.setNextNode(front);
		front = newNode;
		count++;
		modCount++;
		
	}

	@Override
	public void addToRear(T element) {
		// TODO Auto-generated method stub
		SLNode<T> newNode = new SLNode<T>(element);

		if (isEmpty()) {
			rear = newNode;
			front = newNode;
			count++;
			
		}
		
		else {
			rear.setNextNode(newNode);
			rear = newNode;
			count++;
			
		}
		modCount++;
		
	}

	@Override
	public void addAfter(T existingElement, T element) {
		// TODO Auto-generated method stub
		SLNode<T> newNode;
		
		if (isEmpty())
			throw new EmptyCollectionException("Linked List");
		
		SLNode<T> foundNode = findElement(existingElement);
		if (foundNode == null)
			throw new ElementNotFoundException("Linked List");
		
		// no exceptions, the existingElement is there
		
		
		newNode = new SLNode<T>(element);
		newNode.setNextNode(foundNode.getNextNode());
		foundNode.setNextNode(newNode);
		if (foundNode == rear)
			rear = newNode;
		count++;
		modCount++;
			
		
	}

	private SLNode<T> findElement(T existingElement) {
		// TODO Auto-generated method stub
		
		SLNode<T> currNode = front;
		
		while ((currNode != null) && (currNode.getData() != existingElement)) {
			currNode = currNode.getNextNode();
		}
		
		return currNode;
	}

//	@Override
//	public Iterator<T> itorator() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	

	
}
