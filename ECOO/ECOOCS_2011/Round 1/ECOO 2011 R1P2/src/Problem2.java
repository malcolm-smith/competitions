import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2 {

	private static final int NUM_OF_TEST_CASES = 5; // or whatever number of test cases are in the file
	private static String filePath = "../src/DATA20.txt"; // write the file path here

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem2().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		// write code for solving a single test case here; for loop above will repeat
		// for each test case
		String row1 = sc.nextLine();
		String row2 = sc.nextLine();
		String row3 = sc.nextLine();
		String rows[] = { row1, row2, row3 };
		String arr[] = new String[row1.length() / 2];

		// hard code braille 
		String code[] = new String[27];
		code[0] = "xooooo";
		code[1] = "xoxooo";
		code[2] = "xxoooo";
		code[3] = "xxoxoo";
		code[4] = "xooxoo";
		code[5] = "xxxooo";
		code[6] = "xxxxoo";
		code[7] = "xoxxoo";
		code[8] = "oxxooo";
		code[9] = "oxxxoo";
		code[10] = "xoooxo";
		code[11] = "xoxoxo";
		code[12] = "xxooxo";
		code[13] = "xxoxxo";
		code[14] = "xooxxo";
		code[15] = "xxxoxo";
		code[16] = "xxxxxo";
		code[17] = "xoxxxo";
		code[18] = "oxxoxo";
		code[19] = "oxxxxo";
		code[20] = "xoooxx";
		code[21] = "xoxoxx";
		code[22] = "oxxxox";
		code[23] = "xxooxx";
		code[24] = "xxoxxx";
		code[25] = "xooxxx";
		code[26] = "oooooo";

		for (int i = 0; i < arr.length; i++) {
			arr[i] = "";
		}

		for (int k = 0; k < rows.length; k++) { // put each braille code into array index
			Scanner in = new Scanner(rows[k]);
			for (int i = 0; i < row1.length() / 2; i++) {
				arr[i] = arr[i] + Character.toString(rows[k].charAt(i * 2))
						+ Character.toString(rows[k].charAt((i * 2) + 1));
			}
		}

		for (int i = 0; i < arr.length; i++) { // translate
			for (int k = 0; k < 25; k++) {
				if (arr[i].equals(code[k])) {
					arr[i] = Character.toString((char) (k + 97));
				}
			}
			if (arr[i].equals(code[26])) {
				arr[i] = " ";
			}
		}
		for (int i = 0; i < arr.length; i++) { // print answer
			System.out.print(arr[i]);
		}
		System.out.println();
	}
}
