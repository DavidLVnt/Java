package Loop;

public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5;
		
		while(i >=1) {
			int num = 1;
			for (int j = 1;j <= i; j++) {
				System.out.print(num + "xxx");
				num *= 2;
			}
			System.out.println();
			i--;
		}
		
		
	}
}
