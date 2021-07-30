package trees;

import java.util.Iterator;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class LinkedBinaryTreeTester extends Tester {
	
	public LinkedBinaryTreeTester() {
		// Set name
		testSetName = "Linked Binary Tree Tester";
		
		// Set up list of tests
		tests.add(new Test_GetRootElement("Test_GetRootElement", "getRootElement"));
		tests.add(new Test_GetLeft("Test_GetLeft", "getLeft, getRootElement"));
		tests.add(new Test_GetRight("Test_GetRight", "getRight, getRootElement"));
		tests.add(new Test_IsEmpty("Test_IsEmpty", "isEmpty"));
		tests.add(new Test_Size("Test_Size", "size, numChildren"));
		tests.add(new Test_GetHeight("Test_GetHeight", "getHeight, height"));
		tests.add(new Test_Find("Test_Find", "find, findNode"));
		tests.add(new Test_Contains("Test_Contains", "contains, find, findNode"));
		tests.add(new Test_ToString("Test_toString", "toString"));
		tests.add(new Test_IteratorInOrder("Test_IteratorInOrder", "iteratorInOrder, inOrder"));
		tests.add(new Test_IteratorPreOrder("Test_IteratorPreOrder", "iteratorPreOrder, preOrder"));
		tests.add(new Test_IteratorPostOrder("Test_IteratorPostOrder", "iteratorPostOrder, postOrder"));
	}
	
	public class Test_GetRootElement extends Test {
		public Test_GetRootElement(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String expectedResult, actualResult;
			
			// - Test -------------------------------------------------------------------------------------------
			boolean exceptionThrown = false;
			expectedResult = "exception thrown";
			actualResult = "exception NOT thrown";
			LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<String>();
			try {
				tree1.getRootElement();
			}
			catch (EmptyCollectionException ex) {
				exceptionThrown = true;
				actualResult = "exception thrown";
			}
			finally { }
			
			if (exceptionThrown ) {
				result = "PASS";
			}
			else {
				result = "FAIL";
				allTestsPass = false;
			}
			
			Logger.println("(" + result + ") ... Test 1: Try getRootElement on empty tree; try to catch exception.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("LeftNode");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("RightNode");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("Root", tree2left, tree2right);
			expectedResult = "Root";
			actualResult = tree2root.getRootElement();
			
			if ( !actualResult.contentEquals(expectedResult ) ) {
				result = "FAIL";
				allTestsPass = false;
			} else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Build a simple tree with Root, LeftNode, RightNode. Try to getRootElement.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			
			return allTestsPass;		
		}		
	}
	
	public class Test_GetLeft extends Test {
		public Test_GetLeft(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "";
			String expectedResult;
			String actualResult = "";
			LinkedBinaryTree<String> resultTree;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("LeftNode");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("RightNode");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("Root", tree2left, tree2right);
			expectedResult = "LeftNode";
			resultTree = tree2root.getLeft();
			
			if ( resultTree == null ) {
				result = "FAIL";
				reason = "getLeft returned null";
				allTestsPass = false;
				actualResult = "null";
			}
			else if ( !resultTree.getRootElement().contentEquals( expectedResult ) ) {
				result = "FAIL";
				reason = "getLeft returned the incorrect element.";
				allTestsPass = false;
				actualResult = resultTree.getRootElement();
			} else {
				result = "PASS";
				actualResult = resultTree.getRootElement();
			}
	
			Logger.println("(" + result + ") ... Test 1: Build a simple tree with Root, LeftNode, RightNode. Try to getLeft.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			expectedResult = "LeftLeftNode";
			resultTree = tree3root.getLeft().getLeft();
			
			if ( resultTree == null ) {
				result = "FAIL";
				reason = "getLeft returned null";
				allTestsPass = false;
				actualResult = "null";
			}
			else if ( !resultTree.getRootElement().contentEquals( expectedResult ) ) {
				result = "FAIL";
				reason = "getLeft returned the incorrect element.";
				allTestsPass = false;
				actualResult = resultTree.getRootElement();
			} else {
				result = "PASS";
				actualResult = resultTree.getRootElement();
			}
	
			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Build a tree with Root, Left, LeftLeft, LeftRight, Right, RightLeft, and RightRight. Try to go Left twice.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}
			
			return allTestsPass;			
		}		
	}
	
	public class Test_GetRight extends Test {
		public Test_GetRight(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "";
			String expectedResult;
			String actualResult = "";
			LinkedBinaryTree<String> resultTree;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("LeftNode");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("RightNode");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("Root", tree2left, tree2right);
			expectedResult = "RightNode";
			resultTree = tree2root.getRight();
			
			if ( resultTree == null ) {
				result = "FAIL";
				reason = "getRight returned null";
				allTestsPass = false;
				actualResult = "null";
			}
			else if ( !resultTree.getRootElement().contentEquals( expectedResult ) ) {
				result = "FAIL";
				reason = "getRight returned the incorrect element.";
				allTestsPass = false;
				actualResult = resultTree.getRootElement();
			} else {
				result = "PASS";
				actualResult = resultTree.getRootElement();
			}
	
			Logger.println("(" + result + ") ... Test 1: Build a simple tree with Root, LeftNode, RightNode. Try to getRight.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			expectedResult = "RightRightNode";
			resultTree = tree3root.getRight().getRight();
			
			if ( resultTree == null ) {
				result = "FAIL";
				reason = "getRight returned null";
				allTestsPass = false;
				actualResult = "null";
			}
			else if ( !resultTree.getRootElement().contentEquals( expectedResult ) ) {
				result = "FAIL";
				reason = "getRight returned the incorrect element.";
				allTestsPass = false;
				actualResult = resultTree.getRootElement();
			} else {
				result = "PASS";
				actualResult = resultTree.getRootElement();
			}
	
			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Build a tree with Root, Left, LeftLeft, LeftRight, Right, RightLeft, and RightRight. Try to go Right twice.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}
			
			return allTestsPass;	
		}		
	}
	
	public class Test_IsEmpty extends Test {
		public Test_IsEmpty(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			boolean expectedResult;
			boolean actualResult;

			// - Test -------------------------------------------------------------------------------------------			
			LinkedBinaryTree<String> tree1 = new LinkedBinaryTree<String>("Root");
			expectedResult = false;
			actualResult = tree1.isEmpty();
			
			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("(" + result + ") ... Test 1: Make tree with just the root. Check isEmpty.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);

			// - Test -------------------------------------------------------------------------------------------			
			LinkedBinaryTree<String> tree2 = new LinkedBinaryTree<String>();
			expectedResult = true;
			actualResult = tree2.isEmpty();
			
			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree without a root. Check isEmpty.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			
			return allTestsPass;			
		}		
	}
	
	public class Test_Size extends Test {
		public Test_Size(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			int expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --
			LinkedBinaryTree<String> tree1root = new LinkedBinaryTree<String>("Root");
			expectedResult = 1;
			actualResult = tree1root.size();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			//Logger.println("");
			Logger.println("(" + result + ") ... Test 1: Make tree with root element only. Check size.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("LeftNode");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("RightNode");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("Root", tree2left, tree2right);
			expectedResult = 3;
			actualResult = tree2root.size();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree with three elements. Check size.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			
			expectedResult = 7;
			actualResult = tree3root.size();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 3: Make tree 7 elements. Check size.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			
			return allTestsPass;			
		}		
	}
	
	public class Test_GetHeight extends Test {
		public Test_GetHeight(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			int expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --
			LinkedBinaryTree<String> tree1root = new LinkedBinaryTree<String>("Root");
			expectedResult = 0;
			actualResult = tree1root.getHeight();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			//Logger.println("");
			Logger.println("(" + result + ") ... Test 1: Make tree with root element only. Check height.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("LeftNode");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("RightNode");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("Root", tree2left, tree2right);
			expectedResult = 1;
			actualResult = tree2root.getHeight();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree ROOT with LEFT and RIGHT. Check height.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			
			expectedResult = 2;
			actualResult = tree3root.getHeight();

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 3: Make tree with root, left, left-left, left-right, right, right-left, and right-right. Check height.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
		
			return allTestsPass;			
		}		
	}
	
	public class Test_Contains extends Test {
		public Test_Contains(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			boolean actualResult, expectedResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			
			expectedResult = false;
			actualResult = tree3root.contains("LeftLeftLeftNode");

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 1: Make tree and search for element that doesn't exist.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree4leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree4leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree4left = new LinkedBinaryTree<String>("LeftNode", tree4leftleft, tree4leftright);			
			LinkedBinaryTree<String> tree4rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree4rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree4right = new LinkedBinaryTree<String>("RightNode", tree4rightleft, tree4rightright);
			LinkedBinaryTree<String> tree4root = new LinkedBinaryTree<String>("Root", tree4left, tree4right);
			
			expectedResult = true;
			actualResult = tree4root.contains("LeftLeftNode");

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree and search for element that does exist.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			
			return allTestsPass;			
		}		
	}
	
	public class Test_Find extends Test {
		public Test_Find(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "";
			String expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("LeftNode", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("RightNode", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("Root", tree3left, tree3right);
			
			expectedResult = "ElementNotFoundException thrown";
			actualResult = "No exception thrown";
			try {
				actualResult = tree3root.find("LeftLeftLeftNode");				
			}
			catch( ElementNotFoundException ex ) {
				actualResult = "ElementNotFoundException thrown";
			}
			finally {}

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				reason = "Expected an exception to be thrown when item can't be found.";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			//Logger.println("");
			Logger.println("(" + result + ") ... Test 1: Make tree and search for element that doesn't exist.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree4leftleft = new LinkedBinaryTree<String>("LeftLeftNode");						
			LinkedBinaryTree<String> tree4leftright = new LinkedBinaryTree<String>("LeftRightNode");		
			LinkedBinaryTree<String> tree4left = new LinkedBinaryTree<String>("LeftNode", tree4leftleft, tree4leftright);			
			LinkedBinaryTree<String> tree4rightleft = new LinkedBinaryTree<String>("RightLeftNode");		
			LinkedBinaryTree<String> tree4rightright = new LinkedBinaryTree<String>("RightRightNode");		
			LinkedBinaryTree<String> tree4right = new LinkedBinaryTree<String>("RightNode", tree4rightleft, tree4rightright);
			LinkedBinaryTree<String> tree4root = new LinkedBinaryTree<String>("Root", tree4left, tree4right);
			
			expectedResult = "LeftLeftNode";
			actualResult = tree4root.find("LeftLeftNode");

			if ( expectedResult != actualResult ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree and search for element that does exist.");
			Logger.println("\tExpected result: " + expectedResult + ", actual result: " + actualResult);
			
		
			return allTestsPass;			
		}		
	}
	
	public class Test_ToString extends Test {
		public Test_ToString(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "Note: Make sure your toString has a trailing space at the end; this text expects that to be there.";
			String expectedResult, actualResult;
		

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --
			LinkedBinaryTree<String> tree1root = new LinkedBinaryTree<String>("X");
			expectedResult = "X ";
			actualResult = tree1root.toString();

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			//Logger.println("");
			Logger.println("(" + result + ") ... Test 1: Make tree with root element only. Get toString.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree2left = new LinkedBinaryTree<String>("L");			
			LinkedBinaryTree<String> tree2right = new LinkedBinaryTree<String>("R");
			LinkedBinaryTree<String> tree2root = new LinkedBinaryTree<String>("X", tree2left, tree2right);
			expectedResult = "L X R ";
			actualResult = tree2root.toString();

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 2: Make tree with 3 elements. Get toString.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}
			
			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("LL");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("LR");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("L", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("RL");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("RR");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("R", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("X", tree3left, tree3right);
			
			expectedResult = "LL L LR X RL R RR ";
			actualResult = tree3root.toString();

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("");
			Logger.println("(" + result + ") ... Test 3: Make tree with 7 elements. Get toString.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			
			
			return allTestsPass;			
		}		
	}
	
	public class Test_IteratorInOrder extends Test {
		public Test_IteratorInOrder(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "InOrder traversal means: TRAVERSE LEFT, SELF, TRAVERSE RIGHT";
			String expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("A");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("C");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("B", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("E");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("G");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("F", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("D", tree3left, tree3right);
			
			expectedResult = "A B C D E F G ";
			actualResult  = "";
			
			// Iterate through everything
			Iterator<String> iterator = tree3root.iteratorInOrder();
			while ( iterator.hasNext() ) {
				actualResult += iterator.next() + " ";
			}

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("(" + result + ") ... Test 1: Make tree with 7 elements. Iterate through in-order.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}

			
			return allTestsPass;			
		}		
	}
	
	public class Test_IteratorPreOrder extends Test {
		public Test_IteratorPreOrder(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "PreOrder traversal means: SELF, TRAVERSE LEFT, TRAVERSE RIGHT";
			String expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --		
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("A");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("C");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("B", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("E");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("G");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("F", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("D", tree3left, tree3right);

			expectedResult = "D B A C F E G ";
			actualResult  = "";
			
			// Iterate through everything
			Iterator<String> iterator = tree3root.iteratorPreOrder();
			while ( iterator.hasNext() ) {
				actualResult += iterator.next() + " ";
			}

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("(" + result + ") ... Test 1: Make tree with 7 elements. Iterate through pre-order.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}
			
			return allTestsPass;			
		}		
	}
	
	public class Test_IteratorPostOrder extends Test {
		public Test_IteratorPostOrder(String name, String prereqs) { super(name, prereqs); }		
		public boolean run() {
			super.run();
			boolean allTestsPass = true;
			String result = "";
			String reason = "PostOrder traversal means: TRAVERSE LEFT, TRAVERSE RIGHT, SELF";
			String expectedResult, actualResult;

			// - Test -------------------------------------------------------------------------------------------
			// -- Gotta manually build a tree via nodes because this version doesn't have insert functionality --			
			LinkedBinaryTree<String> tree3leftleft = new LinkedBinaryTree<String>("A");						
			LinkedBinaryTree<String> tree3leftright = new LinkedBinaryTree<String>("C");		
			LinkedBinaryTree<String> tree3left = new LinkedBinaryTree<String>("B", tree3leftleft, tree3leftright);			
			LinkedBinaryTree<String> tree3rightleft = new LinkedBinaryTree<String>("E");		
			LinkedBinaryTree<String> tree3rightright = new LinkedBinaryTree<String>("G");		
			LinkedBinaryTree<String> tree3right = new LinkedBinaryTree<String>("F", tree3rightleft, tree3rightright);
			LinkedBinaryTree<String> tree3root = new LinkedBinaryTree<String>("D", tree3left, tree3right);

			expectedResult = "A C B E G F D ";
			actualResult  = "";
			
			// Iterate through everything
			Iterator<String> iterator = tree3root.iteratorPostOrder();
			while ( iterator.hasNext() ) {
				actualResult += iterator.next() + " ";
			}

			if ( !expectedResult.contentEquals( actualResult ) ) {
				result = "FAIL";
				allTestsPass = false;				
			}
			else {
				result = "PASS";
			}

			Logger.println("(" + result + ") ... Test 1: Make tree with 7 elements. Iterate through post-order.");
			Logger.println("\tExpected result: \"" + expectedResult + "\", actual result: \"" + actualResult + "\"");
			if (result.contentEquals("FAIL")) {
				Logger.println("\tAdditional information: " + reason);
			}
			
			return allTestsPass;			
		}		
	}
}
