import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10; //or whatever number of test cases are in the file
	private static String filePath = "../../../data/DATA11.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem1().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		int n = sc.nextInt();
		sc.nextLine();

		ArrayList<String> all = new ArrayList<String>();
		ArrayList<String> ls = new ArrayList<String>();
		
		for (int i = 0; i < n; i++) {
			all.add(format(sc.nextLine()));
		}

		for (String email : all) {
			if (!ls.contains(email)) {
				ls.add(email);
			}
		}

		System.out.println(ls.size());
	}

	public String format(String e) {
		String email = e;
		email = email.toLowerCase();
		char[] arr = email.toCharArray();

		boolean foundAt = false;
		boolean foundPlus = false;

		for (int i = 0; i < arr.length; i++) {
			char letter = arr[i];
			if (letter == '@') {
				foundAt = true;
			}
			if (foundAt == true) {
				String newEmail = "";
				for (char c : arr) {
					if (c == '~') {
						newEmail += "";
					} else {
						newEmail += Character.toString(c);
					}
				}
				return newEmail;
			}
			if (foundPlus == false) {
				 if (letter == '+') {
					foundPlus = true;
					arr[i] = '~';
				} else if (letter == '.') {
					arr[i] = '~';
				}
			} else if (foundPlus == true) {
				arr[i] = '~';
			}
		}
		return "eh";
	}
}
