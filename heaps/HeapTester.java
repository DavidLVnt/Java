package heaps;

import java.util.Iterator;

public class HeapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayHeap<Integer> ht = new ArrayHeap<Integer>();
//		LinkedHeap<Integer> ht = new LinkedHeap<Integer>();
		test1 (ht);
	//	ht = new LinkedHeap<Integer>();
		ht = new ArrayHeap<Integer>();


	}
	
	public static void test1(HeapADT<Integer> ht) {
	
		ht.addElement(8);
		ht.addElement(5);
		ht.addElement(14);
		ht.addElement(18);
		ht.addElement(34);
		ht.addElement(2);
		ht.addElement(31);
		
		ht.addElement(9);
		ht.addElement(1);
		ht.addElement(17);
		ht.addElement(28);
		ht.addElement(3);
		ht.addElement(23);
		ht.addElement(11);
		
		System.out.println(ht);
		
		System.out.println("Remove first element: ");
		ht.removeMin();
		System.out.println(ht);
		
		System.out.println("Remove elements 2, 3, 4: ");
		ht.removeMin();
		ht.removeMin();
		ht.removeMin();
		System.out.println(ht);
		
		System.out.println("Remove fifth element: ");
		ht.removeMin();
		System.out.println(ht);

		
		System.out.println("\nRemove elements should display incremental values");
		while (!ht.isEmpty()) {
			System.out.print(ht.removeMin() + " ");
		
		
	}

	}}


