package trees;

import exceptions.ElementNotFoundException;

public class BSTTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedBinarySearchTreeMV<String> bst = new LinkedBinarySearchTreeMV<String>();
		System.out.println("******ADD******\nAdd GDAFB");
		bst.addElement("G");
		bst.addElement("D");
		bst.addElement("A");
		bst.addElement("F");
		bst.addElement("B");
		System.out.println("BST[ABDFG]: " + bst);
		

		System.out.println("\n*****OPERATIONS******");
		System.out.println("Size[5]: " + bst.size());
		System.out.println("Contains D [true]: " + bst.contains("D"));
		System.out.println("Contains W [false]: " + bst.contains("W"));
		System.out.println("Get D [D]: " + bst.find("D"));
		try {
			bst.find("W");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.print("Get W [exception]: " + e.getMessage());
		}
		

		System.out.println("\nGet A [A]: " + bst.find("A"));
		System.out.println("BST[ABDFG]: " + bst);

		System.out.println("\n******HEIGHT******");
		System.out.println("Height of tree [3]: " + bst.getHeight());
		bst.addElement("H");
		bst.addElement("I");
		bst.addElement("J");
		bst.addElement("K");
		bst.addElement("L");	
		bst.addElement("M");
		bst.addElement("N");
		bst.addElement("O");
		bst.addElement("P");
		bst.addElement("Q");
		bst.addElement("L");
		System.out.print("After adding HIJKLMNL[ABDFGHIJKLLMN]: ");
		System.out.println(bst);
		System.out.println("Max: " + bst.findMax());

		System.out.println("\nHeight of tree before balance: " + bst.getHeight());

		System.out.println("balance factor: " + bst.getBalanceFactor());
		System.out.println("is balanced: " + bst.isBalanced());
		bst.rebalanceTree();

		System.out.println("Root: " + bst.getRootElement());
		System.out.println("\nHeight of tree after balance: " + bst.getHeight());
		System.out.println("balance factor: " + bst.getBalanceFactor());

		// balance tree tests

		System.out.println("\n******REMOVE******");
		System.out.println(bst);
		System.out.println("Remove G: " + bst.removeElement("G"));
		System.out.println("Root [H]: " + bst.getRootElement());
		System.out.println(bst);
		System.out.println("Remove A: " + bst.removeElement("A"));
		System.out.println(bst);
		System.out.println("Remove N: " + bst.removeElement("N"));
		System.out.println(bst);
		System.out.println("Remove J: " + bst.removeElement("J"));
		System.out.println(bst);
		
		System.out.println("Max: " + bst.findMax());

		try {
			System.out.print(bst.removeElement("Q"));
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Remove Q expect exception: " + e.getMessage());
		}
		
		System.out.println(bst);




		

	}

}
