package exceptions;

public class InvalidPositionException extends RuntimeException{
	
	public InvalidPositionException (String collectionName)
    {
        super ("The " + collectionName + " is invalid.");
    }

}
