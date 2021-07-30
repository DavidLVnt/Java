package trees;

import java.util.Iterator;


import trees.Logger;
import trees.LinkedBinarySearchTreeMV;

public class LinkedBinarySearchTreeMVTester extends Tester {
	
	public LinkedBinarySearchTreeMVTester() {
		// Set name
		testSetName = "Linked Binary Search Tree MV Tester";
		
		// Set up list of tests
		tests.add(new Test_AddElement("Test_AddElement", "addElement"));
		//tests.add(new Test_RemoveElement("Test_RemoveElement", "removeElement" ));
		//tests.add(new Test_RemoveAllOccurrences("Test_RemoveAllOccurrences", "contains, removeElement" ));
		//tests.add(new Test_RemoveMin("Test_RemoveMin", "removeMin" ));
		//tests.add(new Test_RemoveMax("Test_RemoveMax", "removeMax" ));
		//tests.add(new Test_FindMin("Test_FindMin", "findMin" ));
		//tests.add(new Test_FindMax("Test_FindMax", "findMax" ));
		//tests.add(new Test_Find("Test_Find", "find" ));
		tests.add(new Test_IsBalanced("Test_IsBalanced", "isBalanced" ));
		tests.add(new Test_GetBalanceFactor("Test_GetBalanceFactor", "getBalanceFactor" ));
		tests.add(new Test_RebalanceTree("Test_RebalanceTree", "rebalanceTree" ));
	}
	
	public class Test_AddElement extends Test {
		public Test_AddElement(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String expectedResult, actualResult;
			
			// - Test -------------------------------------------------------------------------------------------	
			LinkedBinarySearchTreeMV<Integer> tree1 = new LinkedBinarySearchTreeMV<Integer>();	
			tree1.addElement(10);
			tree1.addElement(5);  // should go left
			tree1.addElement(15); // should go right
			tree1.addElement(0);  // should go left-left
			tree1.addElement(8);  // should go left-right
			tree1.addElement(12); // should go right-left
			tree1.addElement(20); // should go right-right
			
			expectedResult = "0 5 8 10 12 15 20 ";
			actualResult = "";
			Iterator<Integer> it = tree1.iteratorInOrder();
			while ( it.hasNext() ) {
				actualResult += it.next().toString() + " ";
			}
			
			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("(" + result + ") ... Test 1: Create simple tree, check order of nodes. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);

			return allTestsPass;		
		}		
	}
	
	public class Test_IsBalanced extends Test {
		public Test_IsBalanced(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			boolean expectedResult, actualResult;
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \    /  \
			//         0   8  12  20
			LinkedBinarySearchTreeMV<Integer> tree1 = new LinkedBinarySearchTreeMV<Integer>();	
			tree1.addElement(10);
			tree1.addElement(5);  // should go left
			tree1.addElement(15); // should go right
			tree1.addElement(0);  // should go left-left
			tree1.addElement(8);  // should go left-right
			tree1.addElement(12); // should go right-left
			tree1.addElement(20); // should go right-right
			
			expectedResult = true;
			actualResult = tree1.isBalanced();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("(" + result + ") ... Test 1: Create a tree, insert elements so it's balanced, check isBalanced. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree1.toString());
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \   
			//         0   8  
			LinkedBinarySearchTreeMV<Integer> tree2 = new LinkedBinarySearchTreeMV<Integer>();	
			tree2.addElement(10);
			tree2.addElement(5);  // should go left
			tree2.addElement(15); // should go right
			tree2.addElement(0);  // should go left-left
			tree2.addElement(8);  // should go left-right
			
			expectedResult = false;
			actualResult = tree2.isBalanced();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("(" + result + ") ... Test 1: Create a tree, insert elements so it's balanced, check isBalanced. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree2.toString());
			

			return allTestsPass;		
		}		
	}
	
	public class Test_GetBalanceFactor extends Test {
		public Test_GetBalanceFactor(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			int expectedResult, actualResult;
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \    /  \
			//         0   8  12  20
			LinkedBinarySearchTreeMV<Integer> tree1 = new LinkedBinarySearchTreeMV<Integer>();	
			tree1.addElement(10);
			tree1.addElement(5);  // should go left
			tree1.addElement(15); // should go right
			tree1.addElement(0);  // should go left-left
			tree1.addElement(8);  // should go left-right
			tree1.addElement(12); // should go right-left
			tree1.addElement(20); // should go right-right
			
			expectedResult = 0;
			actualResult = tree1.getBalanceFactor();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("(" + result + ") ... Test 1: Create a tree, insert elements so it's balanced, check balance factor. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree1.toString());
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \   
			//         0   8  
			LinkedBinarySearchTreeMV<Integer> tree2 = new LinkedBinarySearchTreeMV<Integer>();	
			tree2.addElement(10);
			tree2.addElement(5);  // should go left
			tree2.addElement(15); // should go right
			tree2.addElement(0);  // should go left-left
			tree2.addElement(8);  // should go left-right
			
			expectedResult = 1;
			actualResult = tree2.getBalanceFactor();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Create a tree, insert elements more to one side, check balance factor. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree2.toString());
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \   
			//         0   8  
			//			\	\
			//			 2   9
			LinkedBinarySearchTreeMV<Integer> tree3 = new LinkedBinarySearchTreeMV<Integer>();	
			tree3.addElement(10);
			tree3.addElement(5);  // should go left
			tree3.addElement(15); // should go right
			tree3.addElement(0);  // should go left-left
			tree3.addElement(8);  // should go left-right
			tree3.addElement(2);  // should go left-left-right
			tree3.addElement(9);  // should go left-right-right
			
			expectedResult = 2;
			actualResult = tree3.getBalanceFactor();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("");
			Logger.println("(" + result + ") ... Test 3: Create a tree, insert elements more to one side, check balance factor. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree3.toString());

			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//             	   /  \
			//                12   20
			LinkedBinarySearchTreeMV<Integer> tree4 = new LinkedBinarySearchTreeMV<Integer>();	
			tree4.addElement(10);
			tree4.addElement(5);  // should go left
			tree4.addElement(15); // should go right
			tree4.addElement(12);  // should go right-left
			tree4.addElement(20);  // should go right-right
			
			expectedResult = -1;
			actualResult = tree4.getBalanceFactor();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 4: Create a tree, insert elements more to one side, check balance factor. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree4.toString());
			
			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//             	   /  \
			//                12   20
			//			     /       \
			//			    11        21
			LinkedBinarySearchTreeMV<Integer> tree5 = new LinkedBinarySearchTreeMV<Integer>();	
			tree5.addElement(10);
			tree5.addElement(5);  // should go left
			tree5.addElement(15); // should go right
			tree5.addElement(12);  // should go right-left
			tree5.addElement(20);  // should go right-right
			tree5.addElement(11);  // should go right-left-left
			tree5.addElement(21);  // should go right-right-right
			
			expectedResult = -2;
			actualResult = tree5.getBalanceFactor();
			
			if ( actualResult != expectedResult ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("");
			Logger.println("(" + result + ") ... Test 5: Create a tree, insert elements more to one side, check balance factor. ");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree5.toString());

			return allTestsPass;		
		}		
	}
	
	public class Test_RebalanceTree extends Test {
		public Test_RebalanceTree(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			int actualResult;

			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \   
			//         0   8  
			//			\	\
			//			 2   9
			LinkedBinarySearchTreeMV<Integer> tree3 = new LinkedBinarySearchTreeMV<Integer>();	
			tree3.addElement(10);
			tree3.addElement(5);  // should go left
			tree3.addElement(15); // should go right
			tree3.addElement(0);  // should go left-left
			tree3.addElement(8);  // should go left-right
			tree3.addElement(2);  // should go left-left-right
			tree3.addElement(9);  // should go left-right-right

			tree3.rebalanceTree();
			
			actualResult = tree3.getBalanceFactor();

			// Result should be -1, 0, or 1 as acceptable results.
			if ( actualResult < -1 || actualResult > 1 ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("(" + result + ") ... Test 1: Create an unbalanced tree, call rebalance, check balance factor.");
			Logger.println("\tExpected result: -1, 0, or 1, actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree3.toString());


			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//             	   /  \
			//                12   20
			//			     /       \
			//			    11        21
			LinkedBinarySearchTreeMV<Integer> tree5 = new LinkedBinarySearchTreeMV<Integer>();	
			tree5.addElement(10);
			tree5.addElement(5);  // should go left
			tree5.addElement(15); // should go right
			tree5.addElement(12);  // should go right-left
			tree5.addElement(20);  // should go right-right
			tree5.addElement(11);  // should go right-left-left
			tree5.addElement(21);  // should go right-right-right

			tree5.rebalanceTree();
			
			actualResult = tree5.getBalanceFactor();

			if ( actualResult < -1 || actualResult > 1 ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Create an unbalanced tree, call rebalance, check balance factor. ");
			Logger.println("\tExpected result: -1, 0, or 1, actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree5.toString());

			// - Test -------------------------------------------------------------------------
			//				10
			//			  /    \
			//			 5      15
			//          / \    /  \
			//         0   8  12  20
			LinkedBinarySearchTreeMV<Integer> tree1 = new LinkedBinarySearchTreeMV<Integer>();	
			tree1.addElement(10);
			tree1.addElement(5);  // should go left
			tree1.addElement(15); // should go right
			tree1.addElement(0);  // should go left-left
			tree1.addElement(8);  // should go left-right
			tree1.addElement(12); // should go right-left
			tree1.addElement(20); // should go right-right
			
			tree1.rebalanceTree();
			
			actualResult = tree1.getBalanceFactor();

			if ( actualResult < -1 || actualResult > 1 ) {
				result = "FAIL";
				allTestsPass = false;
			}
			else {
				result = "PASS";
			}
			
			Logger.println("");
			Logger.println("(" + result + ") ... Test 3: Create a balanced tree, call rebalance, check balance factor. ");
			Logger.println("\tExpected result: -1, 0, or 1, actual result: " + actualResult);
			Logger.println("\tTree in-order traversal: " + tree1.toString());
			
			return allTestsPass;		
		}		
	}
}
