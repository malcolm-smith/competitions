import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem4 {

	private static final int NUM_OF_TEST_CASES = 1; //or whatever number of test cases are in the file
	// private static String filePath = "../../../data/DATA40.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {
		// Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem4().run();
		}
		// in.close();
	}

	public void run() {
		System.out.println(2 + " " + 2);
		System.out.println(8 + " " + 1);
		System.out.println(3 + " " + 5);

		
	}
}
