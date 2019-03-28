import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Problem3 {

	private static final int NUM_OF_TEST_CASES = 10;
	//private static ArrayList<Integer> arr = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Round 2\\DATA\\DATA31.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	} 
	
	public static void run(Scanner f) {
		int n = f.nextInt();
		int m = f.nextInt();
		long k = f.nextInt();
		long arr[] = new long[n];
		System.out.println(n + "n\n" + m + "m\n" + k + "k\n");
		
		long max = 0;
		long val = 0;
		
		for (int i = 0; i < n; i++) {
			arr[i] = f.nextLong();
		}
		
		// System.out.println(Collections.max(arr) + "ee");
		
		// for (long i = 0; i < k; i++) {
		// 	System.out.println(arr);
		// 	long x = Collections.max(arr);
		// 	for (long p = 0; p < arr.size(); p++) {
		// 		if (arr.get(p) == x) {
		// 			max = p;
		// 			break;
		// 		}
		// 	}
		// 	val = arr.get(max);
		// 	System.out.println(max + " max set to " + (val - m));
		// 	arr.set(max, val -= m);
		// 	if (arr.get(max) < 0) {
		// 		arr.set(max, 0);
		// 	}
		// }
		// System.out.println(max + 1);
		// arr.clear();
	}
}