package lists;

public class ArrayULTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayUnorderedList<String> al = new ArrayUnorderedList<String>();
		
		System.out.println("List [] : " + al);
		addToRearAndFrontTest(al);
		firstTestAfter(al);

	}
	
	public static void addToRearAndFrontTest(ArrayUnorderedList<String> al) {
		al.addToRear("B");
		al.addToRear("A");
		al.addToFront("W");
		al.addToFront("J");
		System.out.println("List[J W B A] : " + al);
	}
	
	public static void firstTestAfter(ArrayUnorderedList<String> al) {
		
		System.out.println("\nTest Add After Method");

		System.out.println("List[J W B A] : " + al);

		al.addAfter("W", "Z");
		System.out.println("List[J W Z B A] : " + al);

		al.addAfter("B", "K");
		System.out.println("List[J W Z B K A] : " + al);

		System.out.println("Size [6]: " + al.size());
		
	}

}
