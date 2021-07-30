package lists;

import java.util.Iterator;

public class ListIteratorTester {
	
	public static void main(String[] args) {
		
		LinkedUnorderedList<String> ll = new LinkedUnorderedList<String>();
		System.out.println("Is empty true: " + ll.isEmpty());
		
		Iterator<String> itr = ll.iterator();

		System.out.println("Has next false: " + itr.hasNext());
		
		ll.addToFront("F");
		ll.addToFront("C");
		ll.addToFront("A");
		ll.addToFront("E");
		ll.addToFront("B");
		ll.addToFront("D");
		ll.addToFront("G");
		ll.addToFront("N");
		ll.removeFirst();

		
		itr = ll.iterator();
		System.out.println("Has next true: " + itr.hasNext());
		System.out.println("Size: " + ll.size());
		while(itr.hasNext())
			System.out.println(itr.next());
		System.out.println("Has next false: " + itr.hasNext());

		System.out.println("Modify: " + ll.modCount);
		itr = ll.iterator();
		for (String letter : ll)
			System.out.print(letter + " ");

	}

}
