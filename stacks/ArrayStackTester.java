package stacks;

public class ArrayStackTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayStack<String> strStack = new ArrayStack<String>();
		
		System.out.println(strStack);
		
		System.out.println("\n== Test push and peek ==");
		System.out.println("isEmpty() [true]: " + strStack.isEmpty());
		System.out.println("Push hello");
		strStack.push("hello");
		System.out.println("peek() [hello]: " + strStack.peek());
		System.out.println("Push world");
		strStack.push("world");
		System.out.println("peek() [world]: " +strStack.peek());

		System.out.println("\n== Test pop and peek ==");
		System.out.println("pop() [world]: " + strStack.pop());
		System.out.println("peek() [hello]: " + strStack.peek());
		System.out.println("pop() [hello]: " +strStack.pop());
		System.out.println("pop() [null]: " +strStack.pop());
		System.out.println("peek() [null]: " + strStack.peek());

		
		System.out.println("\n== Test empty stack ==");
		System.out.println("pop() [null]: " + strStack.pop());
		System.out.println("peek() [null]: " +strStack.peek());
		
		System.out.println("\n== Test full stack ==");
		System.out.println("Push hello1..10");
		for (int i = 1; i <= 10; ++i) {
			strStack.push("hello" + i);
		}
		System.out.println("peek() [hello10]: " + strStack.peek());

		System.out.println("Push hello11, hello12");
		strStack.push("hello11");
		System.out.println("peek() [hello11]: " + strStack.peek());
		strStack.push("hello12");
		System.out.println("peek() [hello12]: " + strStack.peek());

		
	}

}
