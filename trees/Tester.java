package trees;

import java.util.ArrayList;

import trees.Logger;

public class Tester {
	protected ArrayList<Test> tests = new ArrayList<Test>();
	protected String testSetName;
	
	public Tester() {
		testSetName = "base";
	}
	
	public void runAllTests() {
		Logger.header(testSetName);
		String failedMethods = "";
		String unimplementedMethods = "";
		String testName = "";
		
		// Run tests
		for (Test t : tests) {
			try { if ( !t.run() ) { failedMethods += "\n* " + t.getName(); } }
			catch( UnsupportedOperationException ex ) { unimplementedMethods += "\n* " + t.getName(); }
			finally {}
		}
		
		Logger.println("\n");
		Logger.drawHorizontalBar(80);
		Logger.drawHorizontalBar(80);
		Logger.header("TEST RESULS:" );
		// Display results
		if ( failedMethods.equals( "" ) && unimplementedMethods.equals("") ) {
			Logger.println( "All tests passed!" );
		}
		else {
			Logger.printlabel( "Failed tests", (failedMethods.contentEquals("")) ? "none" : failedMethods );
			Logger.println( "\n" );
			Logger.printlabel( "Tests that threw UnsupportedOperationException", (unimplementedMethods.contentEquals("") ? "none" : unimplementedMethods) );
		}
		
	}
}
