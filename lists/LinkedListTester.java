package lists;

public class LinkedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//testAddToFront();
		//testAddToRear();
		testAddAfter();
		
	}
	
	public static void testAddToFront() {
		LinkedUnorderedList<String> ll = new LinkedUnorderedList<String>();
		
		ll.addToFront("W");
		ll.addToFront("B");
		ll.addToFront("J");
	}
	
	public static void testAddToRear() {
		LinkedUnorderedList<String> ll = new LinkedUnorderedList<String>();
		
		ll.addToRear("W");
		ll.addToFront("B");
		ll.addToFront("J");
		ll.addToRear("A");
	}

	
	public static void testAddAfter() {
		LinkedUnorderedList<String> ll = new LinkedUnorderedList<String>();
		ll.addToFront("W");
		ll.addAfter("W", "B");
		ll.addAfter("W", "H");
		ll.addAfter("B", "X");
		ll.addAfter("M", "A");
		
	}
}
