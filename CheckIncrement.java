package Chapter1;
import java.util.Scanner;

public class CheckIncrement {

	public static void main(String[] args) {
		int numRows = 2;
	    int numCols = 3;
	    int rows = 0;
	    int cols = 1;
	    char col;

	    while (rows < numRows) {
	    	cols = 1;
	        rows++;

	        col='A';

	        while (cols <= numCols) {
	            System.out.print("" + rows + col + " ");
	            col++;
	            cols++;
	        }

	    }
	    System.out.println(" ");

	    return;

	}

	}

