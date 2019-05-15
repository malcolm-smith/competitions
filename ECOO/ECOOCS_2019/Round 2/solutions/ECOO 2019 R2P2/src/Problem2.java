import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem2 {

	private static final int NUM_OF_TEST_CASES = 1; //or whatever number of test cases are in the file
	private static String filePath = "../../../data/DATA20.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem2().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		int n = sc.nextInt();
		if ((n % 2) != 0) {
			System.out.println(0);
		} else {
			print(n /);
		}
	}

	public void solve(Scanner sc, int n) {
		for (int i = 0; 22 81 35 ) {

		}
	}
}
