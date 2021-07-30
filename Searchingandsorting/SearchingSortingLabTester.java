package Searchingandsorting;

import java.util.Iterator;

import Searchingandsorting.Menu;

public class SearchingSortingLabTester {
	
	public void runAllTests() {
		String failedMethods = "";
		String unimplementedMethods = "";
		String testName = "";
		
		// Run tests
		testName = "selectionSort";
		try { if ( !test_selectionSort() ) { failedMethods += "\n* " + testName; } }
		catch( UnsupportedOperationException ex ) { unimplementedMethods += "\n* " + testName; }
		finally {}

		testName = "insertionSort";
		try { if ( !test_insertionSort() ) { failedMethods += "\n* " + testName; } }
		catch( UnsupportedOperationException ex ) { unimplementedMethods += "\n* " + testName; }
		finally {}

		testName = "bubbleSort";
		try { if ( !test_bubbleSort() ) { failedMethods += "\n* " + testName; } }
		catch( UnsupportedOperationException ex ) { unimplementedMethods += "\n* " + testName; }
		finally {}

		testName = "binarySearch";
		try { if ( !test_binarySearch() ) { failedMethods += "\n* " + testName; } }
		catch( UnsupportedOperationException ex ) { unimplementedMethods += "\n* " + testName; }
		finally {}
				
		
		System.out.println("\n\nTEST RESULS:" );
		// Display results
		if ( failedMethods.equals( "" ) && unimplementedMethods.equals("") ) {
			System.out.println( "All tests passed!" );
		}
		else {
			System.out.printf( "\nFailed tests: %s %n", (failedMethods.contentEquals("")) ? "none" : failedMethods);
			System.out.printf( "\nTests that threw unimplemented exceptions: %s %n", (unimplementedMethods.contentEquals("") ? "none" : unimplementedMethods));
		}
	}
	
	public boolean test_selectionSort() {
		Menu.Header( "TEST SET: test_selectionSort" );
        System.out.println( "   * Prerequisites: add(), selectionSort() \n" );
		boolean allTestsPass = true;
		String result = "";
		
		String expectedValue, actualValue;
		
		// Test 1
		SortableArrayList list1 = new SortableArrayList();
		list1.add(3.0);
		list1.add(5.0);
		list1.add(1.0);		
		list1.selectionSort();
		
		// Check first
		expectedValue = "[1.0, 3.0, 5.0]";
		actualValue = list1.toString();

		if ( !actualValue.contentEquals( expectedValue ) ) { 
			result = "FAIL";
			allTestsPass = false;	
			allTestsPass = false;
			
		}
		else {
			result = "PASS";
		}		
		System.out.printf(" (%s) ... Test 1: Test 1: Add 3.0, 5.0, 1.0, sort \n", result);
		System.out.printf( "\tExpected list: %s \n\tReturned list: %s \n\n", expectedValue, actualValue );
		
		return allTestsPass;
	}

	public boolean test_insertionSort() {
		Menu.Header( "TEST SET: test_insertionSort" );
        System.out.println( "   * Prerequisites: add(), insertionSort() \n" );
		boolean allTestsPass = true;
		String result = "";
		
		String expectedValue, actualValue;
		
		// Test 1
		SortableArrayList list1 = new SortableArrayList();
		list1.add(3.0);
		list1.add(5.0);
		list1.add(1.0);		
		list1.insertionSort();
		
		// Check first
		expectedValue = "[1.0, 3.0, 5.0]";
		actualValue = list1.toString();

		if ( !actualValue.contentEquals( expectedValue ) ) { 
			result = "FAIL";
			allTestsPass = false;	
			allTestsPass = false;
			
		}
		else {
			result = "PASS";
		}		
		System.out.printf(" (%s) ... Test 1: Test 1: Add 3.0, 5.0, 1.0, sort \n", result);
		System.out.printf( "\tExpected list: %s \n\tReturned list: %s \n\n", expectedValue, actualValue );	
		
		return allTestsPass;
	}

	public boolean test_bubbleSort() {
		Menu.Header( "TEST SET: test_bubbleSort" );
        System.out.println( "   * Prerequisites: add(), bubbleSort() \n" );
		boolean allTestsPass = true;
		String result = "";
		
		String expectedValue, actualValue;
		
		// Test 1
		SortableArrayList list1 = new SortableArrayList();
		list1.add(3.0);
		list1.add(5.0);
		list1.add(1.0);		
		list1.bubbleSort();
		
		// Check first
		expectedValue = "[1.0, 3.0, 5.0]";
		actualValue = list1.toString();
		
		if ( !actualValue.contentEquals( expectedValue ) ) { 
			result = "FAIL";
			allTestsPass = false;	
			allTestsPass = false;
			
		}
		else {
			result = "PASS";
		}		
		System.out.printf(" (%s) ... Test 1: Test 1: Add 3.0, 5.0, 1.0, sort \n", result);
		System.out.printf( "\tExpected list: %s \n\tReturned list: %s \n\n", expectedValue, actualValue );		
		
		return allTestsPass;
	}
	
	public boolean test_binarySearch() {
		Menu.Header( "TEST SET: test_binarySearch" );
        System.out.println( "   * Prerequisites: add(), binarySearch() \n" );
		boolean allTestsPass = true;
		String result = "";
		
		int expectedValue, actualValue;
		
		// Test 1
		SortableArrayList list1 = new SortableArrayList();
		
		for ( double d = 0.0; d < 20.0; d += 5.0 ) {
			list1.add( d );
		}
		
		// Check first
		expectedValue = 3;
		actualValue = list1.binarySearch( 15.0 );
		
		if ( actualValue != expectedValue ) { 
			result = "FAIL";
			allTestsPass = false;			
		}
		else {
			result = "PASS";
		}
		System.out.printf(" (%s) ... Test 1: Add numbers, search for an element \n", result);

		System.out.printf( "\tList: %s \n", list1.toString() );
		System.out.printf( "\tSearched for: %f \n", 15.0 );
		System.out.printf( "\tExpected index: %d \n\tReturned index: %d \n\n", expectedValue, actualValue );
		
		return allTestsPass;
	}
}
