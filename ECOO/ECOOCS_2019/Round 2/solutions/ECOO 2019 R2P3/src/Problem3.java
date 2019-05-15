import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3 {

	private static final int NUM_OF_TEST_CASES = 1; //or whatever number of test cases are in the file
	private static String filePath = "../../../data/DATA30.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem3().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		int n = sc.nextInt();
		int full = n;
		int m = sc.nextInt();
		int k = 0;
		int width = 0;
		sc.nextLine();

		for (int i = 0; i < m; i++) {
			int p = sc.nextInt();
			String x = sc.next();
			if (x.equals("L")) {
				k = p - 1;
				n = n - k;
				if (k > n) {
					n = k;

			} else if (x.equals("R")) {
				k = full - p + 1;
				n = n - k;
				if (k > n) {
					n = k;

				}

			
			}
		
				width = m + 1;
			}
		}
		System.out.println(n + " " + width);
	}
}

