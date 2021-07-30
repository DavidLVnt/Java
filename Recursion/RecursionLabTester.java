package Recursion;


public class RecursionLabTester {
	public void runAllTests() {
		if (!test_countUp())
				System.out.println("CountUp test failed");
	
		if (!test_countSpaces())
			System.out.println("CountSpaces test failed");
		
		if (!test_factorial())
			System.out.println("Factorial test failed");
		
		if (!test_fibonacci())
				System.out.println("Fibonacci test failed");
	
	}
	
	public boolean test_countUp() {
		System.out.println( "\n[TEST SET: countUp]" );
 
		boolean allTestsPass = true;
		RecursionLabProblems problems = new RecursionLabProblems();
		
		String expectedResult;
		String actualResult;
		String result = "";
		String notes = "";

		// Test
		expectedResult = "1 2 3 ";
		actualResult = problems.countUp( 1,  3 );

		if ( actualResult.equals(expectedResult ) ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + expectedResult + " \n\t Actual value: " + actualResult + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 1: countUp( 1, 3 ) return \"%s\"\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = "5 6 7 8 9 10 ";
		actualResult = problems.countUp( 5, 10 );
		if ( actualResult.equals(expectedResult ) ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + expectedResult + " \n\t Actual value: " + actualResult + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 2: countUp( 5, 10 ) return \"%s\"\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }
		
	
		return allTestsPass;
	}
	
	public boolean test_factorial() {
		System.out.println( "\n[TEST SET: factorial]" );

		boolean allTestsPass = true;
		RecursionLabProblems problems = new RecursionLabProblems();
		
		int expectedResult;
		int actualResult;
		String result = "";
		String notes = "";

		// Test
		expectedResult = 120;
		actualResult = problems.factorial( 5 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 1: factorial( 5 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 1;
		actualResult = problems.factorial( 1 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 2: factorial( 1 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		return allTestsPass;
	}
	
	public boolean test_fibonacci() {
		System.out.println( "\n[TEST SET: fibonacci]" );
 
		boolean allTestsPass = true;
		RecursionLabProblems problems = new RecursionLabProblems();
		
		int expectedResult;
		int actualResult;
		String result = "";
		String notes = "";

		// Test
		expectedResult = 0;
		actualResult = problems.fibonacci( 0 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 1: fibonacci( 0 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 1;
		actualResult = problems.fibonacci( 1 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 2: fibonacci( 1 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 1;
		actualResult = problems.fibonacci( 2 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 3: fibonacci( 2 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 2;
		actualResult = problems.fibonacci( 3 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 4: fibonacci( 3 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 3;
		actualResult = problems.fibonacci( 4 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 5: fibonacci( 4 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 5;
		actualResult = problems.fibonacci( 5 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 6: fibonacci( 5 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 8;
		actualResult = problems.fibonacci( 6 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 7: fibonacci( 6 ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		return allTestsPass;
		
	}
	
	public boolean test_countSpaces() {
		System.out.println( "\n[TEST SET: countSpaces]" );

		boolean allTestsPass = true;
		RecursionLabProblems problems = new RecursionLabProblems();
		
		int expectedResult;
		int actualResult;
		String result = "";
		String notes = "";

		// Test
		expectedResult = 0;
		actualResult = problems.countSpaces( "Hello", 0 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 1: countSpaces( \"Hello\" ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 1;
		actualResult = problems.countSpaces( "Hello there", 0 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 2: countSpaces( \"Hello there\" ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		// Test
		expectedResult = 5;
		actualResult = problems.countSpaces( "I am fine, how are you?", 0 );
		if ( actualResult == expectedResult ) {
			result = "PASS";
			
		} else {
			result = "FAIL";
			notes = "\t Expected result: " + String.valueOf(expectedResult) + " \n\t Actual value: " + String.valueOf(actualResult) + " \n\n";
			allTestsPass = false;			
		}
		System.out.printf("(%s) \t Test 3: countSpaces( \"I am fine, how are you?\" ) return %d\n", result, expectedResult);
		if ( !notes.isEmpty() ) { System.out.printf( "%s", notes ); }

		return allTestsPass;		
	}
	
}
