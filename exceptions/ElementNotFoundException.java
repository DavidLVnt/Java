package exceptions;

public class ElementNotFoundException extends RuntimeException {
	public ElementNotFoundException (String collectionName)
    {
        super ("The " + collectionName + " is not found.");
    }
}
