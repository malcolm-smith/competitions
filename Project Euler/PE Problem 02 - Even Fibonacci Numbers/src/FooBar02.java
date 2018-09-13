public class FooBar02 {
	public static void main(String [] args) {
		int n1 = 1;
		int n2 = 2;
		int n3;
		int sum = 2; //did not add n2

		System.out.print(n2);

		for (int i = 2; i <= 100000; i++) {
			n3 = n1 + n2;

			if (n3 >= 4000000) {
				break;
			}

			if (n3 % 2 == 0) {
				System.out.print(" " + n3);
				sum += n3;
			}

			n1 = n2;
			n2 = n3;
		}
		System.out.println("\n" + sum);
	}
}
