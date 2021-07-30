package trees;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
	private static PrintWriter writer;
	
	public static void open( String loggerPath ) {
		try {
			writer = new PrintWriter( new FileWriter( loggerPath ) );
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Writing output log file to \"%s\"... \n\n", loggerPath );
	}
	
	public static void close() {
		writer.close();
	}
	
	public static void println(String text) {
		System.out.println(text);
		writer.println(text);
	}
	
	public static void print(String text) {
		System.out.print(text);
		writer.print(text);
	}
	
	public static void printlabel(String label, String text) {
		System.out.print(label + ": " + text);
		writer.print(label + ": " + text);
	}
	
	public static void header( String text ) {
		drawHorizontalBar( 80 );
		String head = "| " + text + " |";
		Logger.println( head );
		drawHorizontalBar( head.length() );
		Logger.print( "\n" );
	}
	
	public static void header2( String text ) {
		String head = "- [" + text + "] ";
		Logger.print( head );
		drawHorizontalBar( 80 - head.length() );
		Logger.print( "\n" );
	}
	
	public static void drawHorizontalBar( int width ) {
		for ( int i = 0; i < width; i++ ) { Logger.print( "-" ); }
		Logger.print( "\n" );
	}
}
