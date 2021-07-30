package stacks;

import exceptions.EmptyCollectionException;

public class ArrayStack<T> implements StackADT<T>{
	
	private int top;
	private T[] stack;
	/**
	 * 
	 */
	public ArrayStack() {
		top = -1;
		stack = (T[]) (new Object[10]); 
	}
	
	@Override
	public void push(T element) {
		
		if (isFull() == true) {
				growStack();
		}
		// add an element at the top of the stack
		top++;
		stack[top] = element;
		
	}
	
	@Override
	public T pop() {
		// check if stack is empty 
		if (isEmpty()) {
			throw new EmptyCollectionException("Stack");
		}
		
		// if stack not empty, hold on to top element
		// null array location, reduce top, return element
		
		T retElement = stack[top];
		stack[top] = null;
		top--;
		return retElement;
	}
	@Override
	public T peek() {
		// check if stack is empty 
		if (isEmpty()) {
			throw new EmptyCollectionException("Stack");
		}
		
		// if stack not empty, hold on to top element
		// return it - do not change the array!
		// Note: could return array location directly but this matches pop() code
		
		T retElement = stack[top];
		return retElement;
	}
	
	
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (top == -1);
	}
	
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return top;
	}
	
	@Override
	public String toString() {
		String retString = "[";
		// your code here
		for (int i = top; i > 0; i--) {
			retString += stack[i];
			retString += ", ";
		}
		
		retString += "]";
		return retString;
	}
	
	private boolean isFull() {
		return (top == 	stack.length - 1);
	}
	
	
	// add the growStack() method here
	public void growStack() {
		T[] newStack = (T[])(new Object[stack.length * 2]);
		
		for (int i = 0; i < stack.length; i++) 
			newStack[i] = stack[i];
		stack = newStack;
		
	}

}
