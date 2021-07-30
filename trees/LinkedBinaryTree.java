package trees;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;
import lists.ArrayUnorderedList;

public class LinkedBinaryTree<T> implements BinaryTreeADT<T>, Iterable<T> {

	protected BinaryTreeNode<T> root;
	protected int modCount;
	public int height;

	public LinkedBinaryTree() {
		root = null;
	}

	public LinkedBinaryTree(BinaryTreeNode<T> root) {
		this.root = root;
	}

	public LinkedBinaryTree(T element) {
		root = new BinaryTreeNode<T>(element);
	}

	public LinkedBinaryTree(T element, LinkedBinaryTree<T> left, LinkedBinaryTree<T> right) {
		root = new BinaryTreeNode<T>(element);
		if (left != null)
			root.setLeft(left.root);
		if (right != null)
			root.setRight(right.root);
	}

	@Override
	public T getRootElement() throws EmptyCollectionException {
		// to be implemented

		if (isEmpty())
			throw new EmptyCollectionException("Tree get root empty ");

		return root.getElement();

	}

	protected LinkedBinaryTree<T> getLeft() {
		// to be implemented

		if (isEmpty())
			throw new EmptyCollectionException("Tree get left empty ");

		LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
		result.root = root.getLeft();

		return result;
	}

	protected LinkedBinaryTree<T> getRight() {
		// to be implemented

		if (isEmpty())
			throw new EmptyCollectionException("Tree get right empty ");

		LinkedBinaryTree<T> result = new LinkedBinaryTree<T>();
		result.root = root.getRight();

		return result;
	}

	protected BinaryTreeNode<T> getLeftNode() {
		return root.getLeft();
	}

	protected BinaryTreeNode<T> getRightNode() {
		return root.getRight();
	}

	public BinaryTreeNode<T> getRootNode() {
		return root;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (root == null);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return root.numChildren() + 1;
	}

	@Override
	public boolean contains(T targetElement) {
		// TODO Auto-generated method stub

		boolean result = false;
		if (find(targetElement) != null) {
			result = true;
		}
		return result;
	}

	@Override
	public T find(T targetElement) {
		// TODO Auto-generated method stub
		BinaryTreeNode<T> current = findNode(targetElement, root);

		if (current == null)
			throw new ElementNotFoundException("LinkedBinaryTree");

		return (current.getElement());
	}

	private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> node) {
		if (node == null)
			return null;

		if (node.getElement().equals(targetElement))
			return node;

		BinaryTreeNode<T> temp = findNode(targetElement, node.getLeft());

		if (temp == null)
			temp = findNode(targetElement, node.getRight());

		return temp;
	}

	/**
	 * Returns the height of this tree.
	 *
	 * @return the height of the tree
	 */
	public int getHeight() {
		// to be implemented
		return height(root);
	}

	/**
	 * Returns the height of the specified node.
	 *
	 * @param node the node from which to calculate the height
	 * @return the height of the tree
	 */
	public int height(BinaryTreeNode<T> node) {
		// to be implemented
		int leftHeight, rightHeight;

		if (node == null)
			return 0;

		leftHeight = height(node.left);
		rightHeight = height(node.right);

		if (leftHeight > rightHeight) {
			return leftHeight + 1;
		} else {
			return rightHeight + 1;
		}

	}

	@Override
	public String toString() {
		{
			String result = " ";
			Iterator<T> iter = iterator();
			while (iter.hasNext()) {
				result += iter.next().toString() + " ";
			}
			return result;
		}

	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return iteratorInOrder();

	}

	@Override
	public Iterator<T> iteratorInOrder() {
		{
			ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
			inOrder(root, tempList);

			return new TreeIterator(tempList.iterator());
		}
	}

	protected void inOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if (node != null) {
			inOrder(node.getLeft(), tempList);
			tempList.addToRear(node.getElement());
			inOrder(node.getRight(), tempList);
		}
	}

	@Override
	public Iterator<T> iteratorPreOrder() {
		{
			ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
			preOrder(root, tempList);

			return new TreeIterator(tempList.iterator());
		}
	}

	protected void preOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if (node != null) {
			tempList.addToRear(node.getElement());
			preOrder(node.getLeft(), tempList);
			preOrder(node.getRight(), tempList);
		}
	}

	@Override
	public Iterator<T> iteratorPostOrder() {
		// TODO Auto-generated method stub
		{
			ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
			postOrder(root, tempList);

			return new TreeIterator(tempList.iterator());
		}
	}

	protected void postOrder(BinaryTreeNode<T> node, ArrayUnorderedList<T> tempList) {
		if (node != null) {
			postOrder(node.getLeft(), tempList);
			postOrder(node.getRight(), tempList);
			tempList.addToRear(node.getElement());

		}
	}

	@Override
	public Iterator<T> iteratorLevelOrder() {
		// TODO Auto-generated method stub
		ArrayUnorderedList<BinaryTreeNode<T>> nodes = new ArrayUnorderedList<BinaryTreeNode<T>>();
		ArrayUnorderedList<T> tempList = new ArrayUnorderedList<T>();
		BinaryTreeNode<T> current;

		nodes.addToRear(root);

		while (!nodes.isEmpty()) {
			current = nodes.removeFirst();

			if (current != null) {
				tempList.addToRear(current.getElement());
				if (current.getLeft() != null)
					nodes.addToRear(current.getLeft());
				if (current.getRight() != null)
					nodes.addToRear(current.getRight());
			} else
				tempList.addToRear(null);
		}

		return new TreeIterator(tempList.iterator());
	}

	/**
	 * Inner class to represent an iterator over the elements of this tree
	 */
	private class TreeIterator implements Iterator<T> {
		private int expectedModCount;
		private Iterator<T> iter;

		/**
		 * Sets up this iterator using the specified iterator.
		 *
		 * @param iter the list iterator created by a tree traversal
		 */
		public TreeIterator(Iterator<T> iter) {
			this.iter = iter;
			expectedModCount = modCount;
		}

		/**
		 * Returns true if this iterator has at least one more element to deliver in the
		 * iteration.
		 *
		 * @return true if this iterator has at least one more element to deliver in the
		 *         iteration
		 * @throws ConcurrentModificationException if the collection has changed while
		 *                                         the iterator is in use
		 */
		public boolean hasNext() throws ConcurrentModificationException {
			if (!(modCount == expectedModCount))
				throw new ConcurrentModificationException();

			return (iter.hasNext());
		}

		/**
		 * Returns the next element in the iteration. If there are no more elements in
		 * this iteration, a NoSuchElementException is thrown.
		 *
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iterator is empty
		 */
		public T next() throws NoSuchElementException {
			if (hasNext())
				return (iter.next());
			else
				throw new NoSuchElementException();
		}

		/**
		 * The remove operation is not supported.
		 * 
		 * @throws UnsupportedOperationException if the remove operation is called
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}

}
