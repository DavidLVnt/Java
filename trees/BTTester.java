package trees;

import java.util.Iterator;

import exceptions.ElementNotFoundException;

public class BTTester {

	public static void main(String[] args) {
		/*
		 * // Build a tree a / \ b c / \ / \ d e f g
		 * 
		 */

		// create leaf nodes d, e, f, g
		LinkedBinaryTree<Character> dt = new LinkedBinaryTree<Character>('d');
		LinkedBinaryTree<Character> et = new LinkedBinaryTree<Character>('e');
		LinkedBinaryTree<Character> ft = new LinkedBinaryTree<Character>('f');
		LinkedBinaryTree<Character> gt = new LinkedBinaryTree<Character>('g');

		// create tree with parent b and children d,e
		LinkedBinaryTree<Character> bt = new LinkedBinaryTree<Character>('b', dt, et);

		// create tree with parent c and children f,g
		LinkedBinaryTree<Character> ct = new LinkedBinaryTree<Character>('c', ft, gt);

		// create tree with parent a and children b,c

		LinkedBinaryTree<Character> at = new LinkedBinaryTree<Character>('a', bt, ct);

		System.out.println(at);
		

		// test find function

		System.out.println("Find [e]: " + at.find('e'));
		System.out.println("Find [c]: " + at.find('c'));
		System.out.println("Find [g]: " + at.find('g'));
		try {
			System.out.println("Find [w]: " + at.find('w'));
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}

		// test iterator order level
		Iterator<Character> loit = at.iteratorLevelOrder();

		System.out.print("Nodes by level traversal: ");
		while (loit.hasNext()) {
			System.out.print(loit.next());
		}

		// test iterator order level
		Iterator<Character> init = at.iteratorInOrder();

		System.out.print("\n\nNodes by inorder traversal: ");
		while (init.hasNext()) {
			System.out.print(init.next());
		}

		Iterator<Character> preit = at.iteratorPreOrder();

		System.out.print("\n\nNodes by preorder traversal: ");
		while (preit.hasNext()) {
			System.out.print(preit.next());
		}
		System.out.println("");
		// test additional methods (size, contains, isEmpty(),height(), toString
		System.out.println("Tree at: " + at);
		System.out.println("Check empty: " + at.isEmpty());
		System.out.println("Size: " + at.size());
		System.out.println("Contains: " + at.contains('e'));
		System.out.println("Height: " + at.getHeight());

	}

}
