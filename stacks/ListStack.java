package stacks;

import lists.LinkedUnorderedList;

public class ListStack<T> implements StackADT<T> {
	LinkedUnorderedList<T> stack;

	@Override
	public void push(T element) {
		// TODO Auto-generated method stub
		stack.addToFront(element);
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return stack.removeFirst();
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return stack.first();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return stack.size() == 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return stack.size();
	}
	
	public String toString() {
		return stack.toString();
	}

}
