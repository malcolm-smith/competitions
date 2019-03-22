import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Problem2 {

	private static final int NUM_OF_TEST_CASES = 10; //or whatever number of test cases are in the file
	private static String filePath = "..\\..\\DATA\\DATA21.txt"; //write the file path here

	// variables here
	private int spinnerCount;
	private int[] spinner;
	private int[] targets;
	private String output = "";
	private ArrayList<Integer> poss = new ArrayList<Integer>();

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem2().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		output = "";
		spinnerCount = sc.nextInt();
		spinner = new int[spinnerCount];
		for (int i = 0; i < spinnerCount; i++) {
			int temp = sc.nextInt();
			if (!(spinner.contains(temp))) {
				
			}
		}
		targets = new int[5];
		for (int i = 0; i < 5; i++) {
			targets[i] = sc.nextInt();
		}

		for (int i = 0; i < spinnerCount; i++) {
			for (int j = 0; j < spinnerCount; j++) {
				for (int k = 0; k < spinnerCount; k++) {
					poss.add(spinner[i] + spinner[j] + spinner[k]);
					poss.add(spinner[i] * spinner[j] + spinner[k]);
					poss.add(spinner[i] * spinner[j] * spinner[k]);
					poss.add((spinner[i] + spinner[j]) * spinner[k]);
				}
			}
		}

		for (int target : targets) {
			if (poss.contains(target)) {
				output = output + "T";
			} else {
				output = output + "F";
			}
		}

		System.out.println(output);
	}
}
