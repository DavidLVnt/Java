/**
 * 
 */
package stacks;

import exceptions.EmptyCollectionException;
import support.SLNode;
/**
 * @author congd
 *
 */
public class LinkedStack<T> implements StackADT<T>{
	
	private SLNode<T> top;
	private int count;
	
	public LinkedStack() {
		top = null;
		count = 0;
	}

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		SLNode<T> newNode = new SLNode<T>(element);
		
		//check if empty
		if (isEmpty()) {
			top = newNode;
			count++;
		}
		else {
			newNode.setNextNode(top);
			top = newNode;
			count++;
		}
		
	}

	@Override
	public T pop() throws EmptyCollectionException{
		// TODO Auto-generated method stub
		
		T retElement;
		if (isEmpty()) {
			throw new EmptyCollectionException("Linked Stack");
		} else {
			if (size() == 1 ) {
				//stack will be empty
				retElement = top.getData();
				top = null;
				count = 0;				
			} else {
				retElement = top.getData();
				SLNode<T> oldNode = top;
				top = top.getNextNode();
				oldNode.setNextNode(null);
				count--;
			}
				
		}
		return retElement;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyCollectionException("Linked Stack");
		}
		else {
				return top.getData();
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
		String retString = "[";
		SLNode<T> currentNode = top;
		
		while(currentNode != null) {
			retString += currentNode.getData();
			retString += ", ";
			currentNode = currentNode.getNextNode();
		}	
		
		return retString + "]";
	}

}
