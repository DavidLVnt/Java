package Searchingandsorting;

public class Menu {
	public static void Header( String text ) {
		DrawHorizontalBar( 80 );
		String head = "| " + text + " |";
		System.out.println( head );
		DrawHorizontalBar( head.length() );
		System.out.print( "\n" );
	}
	
	public static void DrawHorizontalBar( int width ) {
		for ( int i = 0; i < width; i++ ) { System.out.print( "-" ); }
		System.out.print( "\n" );
	}
}
