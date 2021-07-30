package lists;

import exceptions.ElementNotFoundException;
import exceptions.EmptyCollectionException;

public class UnorderedListTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayUnorderedList<String> al = new ArrayUnorderedList<String>();
		//LinkedUnorderedList<String> al = new LinkedUnorderedList<String>();
		System.out.println("List [] : " + al);
		
		System.out.println("check contains: " + al.contains("B"));
		testEmptyList(al);
		testEmptyListRF(al);
		testEmptyListRL(al);
		testEmptyListRM(al);
		addToRearAndFrontTest(al);
		addAfterTest(al);
		System.out.println("check contains: " + al.contains("W"));
		removeToRearAndFrontTest(al);
		remove(al);
		

	}
	
	private static void testEmptyList(ArrayUnorderedList<String> al) {
		// TODO Auto-generated method stub
		try {
			al.addAfter("A", "B");
			
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			System.out.println("EmptyCollectionException : " + e.getMessage());
		}
		
	}
	
	private static void testEmptyListRF(ArrayUnorderedList<String> al) {
		// TODO Auto-generated method stub
		try {
			al.removeFirst();
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			System.out.println("EmptyCollectionException : " + e.getMessage());
		}		
	}
	
	private static void testEmptyListRL(ArrayUnorderedList<String> al) {
		// TODO Auto-generated method stub
		try {
			al.removeFirst();
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			System.out.println("EmptyCollectionException : " + e.getMessage());
		}		
	}
	
	private static void testEmptyListRM(ArrayUnorderedList<String> al) {
		// TODO Auto-generated method stub
		try {
			al.removeFirst();
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			System.out.println("EmptyCollectionException : " + e.getMessage());
		}		
	}
	

	public static void addToRearAndFrontTest(UnorderedListADT<String> al) {
		al.addToRear("B");
		al.addToRear("A");
		al.addToFront("W");
		al.addToFront("J");
		System.out.println("List[J W B A] : " + al);
	}
	
	public static void addAfterTest(UnorderedListADT<String> al) {
		
		System.out.println("\nTest Add After Method");
		System.out.println("List[J W B A] : " + al);

		// test valid add afters
		al.addAfter("W", "Z");
		System.out.println("List[J W Z B A] : " + al);

		al.addAfter("B", "K");
		System.out.println("List[J W Z B K A] : " + al);
		System.out.println("Size [6]: " + al.size());
		
		al.addAfter("A", "M");
		System.out.println("List[J W Z B K A M] : " + al);
		System.out.println("Size [7]: " + al.size());

		// test adding after non existing element

		try {
			al.addAfter("X", "C");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ElementNotFoundException: " + e.getMessage());
		}		
		
		
	}
	public static void removeToRearAndFrontTest(UnorderedListADT<String> al) {
		al.removeFirst();
		al.removeFirst();
		al.removeLast();
		al.removeLast();
		
		System.out.println("List[Z B K] : " + al);
	}
	
public static void remove(UnorderedListADT<String> al) {
		
		System.out.println("\nTest remove Method");
		System.out.println("List[Z B K] : " + al);

		// test valid remove
		al.remove("B");
		System.out.println("List[Z K] : " + al);

		al.remove("Z");
		System.out.println("List[K] : " + al);
		System.out.println("Size [1]: " + al.size());
		
		
		// test removing non existing element

		try {
			al.remove("N");
		} catch (ElementNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("ElementNotFoundException: " + e.getMessage());
		}
		
		try {
			al.remove("K");
		} catch (EmptyCollectionException e) {
			// TODO Auto-generated catch block
			System.out.println("EmptyCollectionException : " + e.getMessage());
		}
	}
	
}
