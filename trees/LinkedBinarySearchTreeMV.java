package trees;

import java.awt.List;
import java.util.ArrayList;
import java.util.Iterator;

import org.w3c.dom.traversal.NodeFilter;

import exceptions.*;

/**
 * LinkedBinarySearchTree implements the BinarySearchTreeADT interface with
 * links.
 * 
 * @author Lewis and Chase
 * @version 4.0
 */
public class LinkedBinarySearchTreeMV<T extends Comparable<T>> extends LinkedBinaryTree<T>
		implements BinarySearchTreeADT<T> {
	BinaryTreeNode<T> root;

	/**
	 * Creates an empty binary search tree.
	 */
	public LinkedBinarySearchTreeMV() {
		super();
	}

	/**
	 * Creates a binary search with the specified element as its root.
	 *
	 * @param element the element that will be the root of the new binary search
	 *                tree
	 */
	public LinkedBinarySearchTreeMV(T element) {
		super(element);

		if (!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedBinarySearchTree");
	}

	/**
	 * Adds the specified object to the binary search tree in the appropriate
	 * position according to its natural order. Note that equal elements are added
	 * to the right.
	 *
	 * @param element the element to be added to the binary search tree
	 */
	public void addElement(T element) {
		if (!(element instanceof Comparable))
			throw new NonComparableElementException("LinkedBinarySearchTree");

		if (isEmpty())
			root = new BinaryTreeNode<T>(element);
		else {
			Comparable<T> comparableElement = (Comparable<T>) element;
			Comparable<T> comparableElement2 = (Comparable<T>) root.getElement();

			int result = comparableElement.compareTo(root.getElement());
			int result2 = comparableElement2.compareTo(element);

			if (result < 0) {
				if (root.getLeft() == null)
					root.setLeft(new BinaryTreeNode<T>(element));
				else
					addElement(element, root.getLeft());
			} else {
				if (root.getRight() == null)
					root.setRight(new BinaryTreeNode<T>(element));
				else
					addElement(element, root.getRight());
			}
		}
		modCount++;
	}

	/**
	 * Adds the specified object to the binary search tree in the appropriate
	 * position according to its natural order. Note that equal elements are added
	 * to the right.
	 *
	 * @param element the element to be added to the binary search tree
	 */
	private void addElement(T element, BinaryTreeNode<T> node) {
		Comparable<T> comparableElement = (Comparable<T>) element;

		if (comparableElement.compareTo(node.getElement()) < 0) {
			if (node.getLeft() == null)
				node.setLeft(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getLeft());
		} else {
			if (node.getRight() == null)
				node.setRight(new BinaryTreeNode<T>(element));
			else
				addElement(element, node.getRight());
		}
	}

	/**
	 * Removes the first element that matches the specified target element from the
	 * binary search tree and returns a reference to it. Throws a
	 * ElementNotFoundException if the specified target element is not found in the
	 * binary search tree.
	 *
	 * @param targetElement the element being sought in the binary search tree
	 * @throws ElementNotFoundException if the target element is not found
	 */
	public T removeElement(T targetElement) throws ElementNotFoundException {
		T result = null;

		if (isEmpty())
			throw new ElementNotFoundException("LinkedBinarySearchTree");
		else {
			BinaryTreeNode<T> parent = null;
			if (((Comparable<T>) targetElement).equals(root.getElement())) {
				result = root.getElement();
				BinaryTreeNode<T> temp = replacement(root);
				if (temp == null)
					root = null;
				else {
					root.setElement(temp.getElement());
					root.setRight(temp.getRight());
					root.setLeft(temp.getLeft());
				}

				modCount++;
			} else {
				parent = root;
				if (((Comparable) targetElement).compareTo(root.getElement()) < 0)
					result = removeElement(targetElement, root.getLeft(), parent);
				else
					result = removeElement(targetElement, root.getRight(), parent);
			}
		}

		return result;
	}

	/**
	 * Removes the first element that matches the specified target element from the
	 * binary search tree and returns a reference to it. Throws a
	 * ElementNotFoundException if the specified target element is not found in the
	 * binary search tree.
	 *
	 * @param targetElement the element being sought in the binary search tree
	 * @param node          the node from which to search
	 * @param parent        the parent of the node from which to search
	 * @throws ElementNotFoundException if the target element is not found
	 */
	private T removeElement(T targetElement, BinaryTreeNode<T> node, BinaryTreeNode<T> parent)
			throws ElementNotFoundException {
		T result = null;

		if (node == null)
			throw new ElementNotFoundException("LinkedBinarySearchTree");
		else {
			if (((Comparable<T>) targetElement).equals(node.getElement())) {
				result = node.getElement();
				BinaryTreeNode<T> temp = replacement(node);
				if (parent.getRight() == node)
					parent.setRight(temp);
				else
					parent.setLeft(temp);

				modCount++;
			} else {
				parent = node;
				if (((Comparable) targetElement).compareTo(node.getElement()) < 0)
					result = removeElement(targetElement, node.getLeft(), parent);
				else
					result = removeElement(targetElement, node.getRight(), parent);
			}
		}

		return result;
	}

	/**
	 * Returns a reference to a node that will replace the one specified for
	 * removal. In the case where the removed node has two children, the inorder
	 * successor is used as its replacement.
	 *
	 * @param node the node to be removed
	 * @return a reference to the replacing node
	 */
	private BinaryTreeNode<T> replacement(BinaryTreeNode<T> node) {
		BinaryTreeNode<T> result = null;

		if ((node.getLeft() == null) && (node.getRight() == null))
			result = null;

		else if ((node.getLeft() != null) && (node.getRight() == null))
			result = node.getLeft();

		else if ((node.getLeft() == null) && (node.getRight() != null))
			result = node.getRight();

		else {
			BinaryTreeNode<T> current = node.getRight();
			BinaryTreeNode<T> parent = node;

			while (current.getLeft() != null) {
				parent = current;
				current = current.getLeft();
			}

			current.setLeft(node.getLeft());
			if (node.getRight() != current) {
				parent.setLeft(current.getRight());
				current.setRight(node.getRight());
			}

			result = current;
		}

		return result;
	}

	/**
	 * Removes elements that match the specified target element from the binary
	 * search tree. Throws a ElementNotFoundException if the sepcified target
	 * element is not found in this tree.
	 *
	 * @param targetElement the element being sought in the binary search tree
	 * @throws ElementNotFoundException if the target element is not found
	 */
	public void removeAllOccurrences(T targetElement) throws ElementNotFoundException {
		removeElement(targetElement);

		try {
			while (contains((T) targetElement))
				removeElement(targetElement);
		}

		catch (Exception ElementNotFoundException) {
		}
	}

	/**
	 * Removes the node with the least value from the binary search tree and returns
	 * a reference to its element. Throws an EmptyCollectionException if this tree
	 * is empty.
	 *
	 * @return a reference to the node with the least value
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T removeMin() throws EmptyCollectionException {
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else {
			if (root.getLeft() == null) {
				result = root.getElement();
				root = root.getRight();
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.getLeft();
				while (current.getLeft() != null) {
					parent = current;
					current = current.getLeft();
				}
				result = current.getElement();
				parent.setLeft(current.getRight());
			}

			modCount++;
		}

		return result;
	}

	/**
	 * Removes the node with the highest value from the binary search tree and
	 * returns a reference to its element. Throws an EmptyCollectionException if
	 * this tree is empty.
	 *
	 * @return a reference to the node with the highest value
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T removeMax() throws EmptyCollectionException {
		// To be completed as a Programming Project
		T result = null;

		if (isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");
		else {
			if (root.getRight() == null) {
				result = root.getElement();
				root = root.getLeft();
			} else {
				BinaryTreeNode<T> parent = root;
				BinaryTreeNode<T> current = root.getRight();
				while (current.getRight() != null) {
					parent = current;
					current = current.getRight();
				}
				result = current.getElement();
				parent.setRight(current.getLeft());
			}

			modCount++;
		}

		return result;
	}

	/**
	 * Returns the element with the least value in the binary search tree. It does
	 * not remove the node from the binary search tree. Throws an
	 * EmptyCollectionException if this tree is empty.
	 *
	 * @return the element with the least value
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T findMin() throws EmptyCollectionException {
		// To be completed as a Programming Project
		BinaryTreeNode<T> currNode = root;
		T element;
		if (isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");

		element = currNode.getElement();
		while (currNode.getLeft() != null) {
			currNode = currNode.getLeft();
			element = currNode.getElement();
		}

		return element;
	}

	/**
	 * Returns the element with the highest value in the binary search tree. It does
	 * not remove the node from the binary search tree. Throws an
	 * EmptyCollectionException if this tree is empty.
	 *
	 * @return the element with the highest value
	 * @throws EmptyCollectionException if the tree is empty
	 */
	public T findMax() throws EmptyCollectionException {
		BinaryTreeNode<T> currNode = root;
		T element;
		if (isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");

		element = currNode.getElement();
		while (currNode.getRight() != null) {
			currNode = currNode.getRight();
			element = currNode.getElement();
		}

		return element;
	}

	/**
	 * Returns a reference to the specified target element if it is found in the
	 * binary tree. Throws a NoSuchElementException if the specified target element
	 * is not found in this tree.
	 *
	 * @param targetElement the element being sought in the binary tree
	 * @throws ElementNotFoundException if the target element is not found
	 */
	public T find(T targetElement) throws ElementNotFoundException {
		// To be completed as a Programming Project
		BinaryTreeNode<T> currNode = root;
		T element;

		if (isEmpty())
			throw new EmptyCollectionException("LinkedBinarySearchTree");

		Comparable<T> currElement;

		while (currNode != null) {
			currElement = (Comparable<T>) currNode.getElement();
			if (currElement.compareTo(targetElement) < 0)
				currNode = currNode.getRight();
			else if (currElement.compareTo(targetElement) > 0)
				currNode = currNode.getLeft();
			else
				break;
		}

		if (currNode != null)
			return currNode.getElement();

		return null;
	}

	/**
	 * Returns whether the tree is currently balanced. A tree is balanced if the
	 * height of the LEFT subtree is the same as the node's RIGHT subtree.
	 * 
	 * @return true if tree is balanced, or false otherwise.
	 */
	public boolean isBalanced() {
		if (isEmpty()) {
			return true;
		}
		int lh = getLeft().getHeight();
		int rh = getRight().getHeight();

		if (Math.abs(lh - rh) <= 1 && getLeft().isBalanced() && getRight().isBalanced())
			return true;
		return false;

		// throw new UnsupportedOperationException( "not yet implemented!" );
	}

	/**
	 * The balance factor of a tree is the result of height( left subtree ) - height
	 * ( right subtree )
	 * 
	 * @return the balance factor
	 */
	public int getBalanceFactor() {
		// To be completed as a Programming Project

		int leftHeight = 0;
		int rightHeight = 0;

		if (getLeft() != null)
			leftHeight = getLeft().getHeight();
		if (getRight() != null)
			rightHeight = getRight().getHeight();

		return rightHeight - leftHeight;

		// throw new UnsupportedOperationException( "not yet implemented!" );
	}

	/**
	 * First, check if the balance factor of the tree is > 1 or < -1 (Which means
	 * it's not height-balanced and needs to be re-balanced.) If there is a balance
	 * issue, make up your own algorithm to re-insert the tree's nodes in an order
	 * that makes it height-balanced (the difference of the left and right subtree
	 * is no more than 1.)
	 */
	public void rebalanceTree(BinaryTreeNode T3) {
		// To be completed as a Programming Project
		int balance = getBalanceFactor();
		if (balance > 1) {
			if (height(T3.right.right) > height(T3.right.left)) {
				T3 = leftRotation(T3);
			} else {
				T3.right = rightRotation(T3.right);
				T3 = leftRotation(T3);
			}
		} else if (balance < -1) {
			if (height(T3.left.left) > height(T3.left.right))
				T3 = rightRotation(T3);
			else {
				T3.left = leftRotation(T3.left);
				T3 = rightRotation(T3);
			}
		}

	}

	public int height(BinaryTreeNode<T> node) {
		if (node == null)
			return 0;

		return node.height;
	}

	public int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public BinaryTreeNode rightRotation(BinaryTreeNode<T> y) {
		BinaryTreeNode<T> x = y.left;
		BinaryTreeNode<T> T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;

		return x;

	}

	public BinaryTreeNode leftRotation(BinaryTreeNode<T> x) {
		BinaryTreeNode<T> y = x.right;
		BinaryTreeNode<T> T2 = y.left;

		x.right = T2;
		y.left = x;

		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;

		return y;
	}

	public BinaryTreeNode addE(BinaryTreeNode<T> node, int key) {

		if (node == null)
			return new BinaryTreeNode(key);

		if (key < node.key)
			node.left = addE(node.left, key);
		else if (key > node.key)
			node.right = addE(node.right, key);
		else
			return node;

		node.height = 1 + max(height(node.left), height(node.right));

		int balance = getBalanceFactor();

		if (balance > 1 && key < node.left.key)
			return rightRotation(node);

		if (balance < -1 && key > node.right.key)
			return leftRotation(node);

		if (balance > 1 && key > node.left.key) {
			node.left = leftRotation(node.left);
			return rightRotation(node);
		}

		if (balance < -1 && key < node.right.key) {
			node.right = rightRotation(node.right);
			return leftRotation(node);
		}

		return node;
	}

	public BinaryTreeNode minValueNode(BinaryTreeNode node) {
		BinaryTreeNode current = node;

		while (current.left != null)
			current = current.left;

		return current;
	}

	public BinaryTreeNode deleteNode(BinaryTreeNode<T> root, int key) {

		if (root == null)
			return root;

		if (key < root.key)
			root.left = deleteNode(root.left, key);

		else if (key > root.key)
			root.right = deleteNode(root.right, key);

		else {

			if ((root.left == null) || (root.right == null)) {
				BinaryTreeNode temp = null;
				if (temp == root.left)
					temp = root.right;
				else
					temp = root.left;

				if (temp == null) {
					temp = root;
					root = null;
				} else
					root = temp;
			} else {

				BinaryTreeNode temp = minValueNode(root.right);
				root.key = temp.key;
				root.right = deleteNode(root.right, temp.key);
			}
		}

		if (root == null)
			return root;

		root.height = max(height(root.left), height(root.right)) + 1;

		int balance = getBalanceFactor();

		// Left Left Case
		if (balance > 1 && getBalanceFactor() >= 0)
			return rightRotation(root);

		// Left Right Case
		if (balance > 1 && getBalanceFactor() < 0) {
			root.left = leftRotation(root.left);
			return rightRotation(root);
		}

		// Right Right Case
		if (balance < -1 && getBalanceFactor() <= 0)
			return leftRotation(root);

		// Right Left Case
		if (balance < -1 && getBalanceFactor() > 0) {
			root.right = rightRotation(root.right);
			return leftRotation(root);
		}

		return root;
	}

	/**
	 * Returns the left subtree of the root of this tree.
	 *
	 * @return a link to the left subtree of the tree
	 */
	public LinkedBinarySearchTree<T> getLeft() {
		// To be completed as a Programming Project
		LinkedBinarySearchTree<T> leftTree = new LinkedBinarySearchTree<T>();
		leftTree.root = root.getLeft();
		return leftTree;
	}

	/**
	 * Returns the right subtree of the root of this tree.
	 *
	 * @return a link to the right subtree of the tree
	 */
	public LinkedBinarySearchTree<T> getRight() {
		// To be completed as a Programming Project
		LinkedBinarySearchTree<T> rightTree = new LinkedBinarySearchTree<T>();
		rightTree.root = root.getRight();
		return rightTree;

	}

	/**
	 * Returns a reference to the specified target element if it is found in this
	 * tree.
	 *
	 * @param targetElement the element being sought in the tree
	 * @param next          the tree node to begin searching on
	 */
	/*
	 * private BinaryTreeNode<T> findNode(T targetElement, BinaryTreeNode<T> next) {
	 * // To be completed as a Programming Project return null; }
	 */
}
