import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10;

	public static void main(String[] args) throws FileNotFoundException {
		//File data = new File("E:\\DATA11.txt"); //USB file-path
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Round 2\\DATA\\DATA11.txt"); //test case file-path
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
			
		}
	} 
	
	public static void run(Scanner f) { 
		int n = f.nextInt();
		int m = f.nextInt();
		
		//keys
		String r11 = f.next();
		String r12 = f.next();
		String r21 = f.next();
		String r22 = f.next();
		String r31 = f.next();
		String r32 = f.next();
		String r41 = f.next();
		String r42 = f.next();
		
		//first floor
		String first = f.next();
		
		ArrayList<Character> arr = new ArrayList<>();
		
		//turns string into ArrayList of characters
		for (int i = 0; i < n; i++) {
			arr.add(first.charAt(i));
		}
		
		//main loop
		for (int k = 0; k < m - 1; k++) {
				for (int p = 0; p < n; p++) {
					if (p - 1 < 0) { //if left side of grid; only ever used once; no point of placing in loop
						if ((Character.toString(arr.get((k * n) + n - 1)) + Character.toString(arr.get((k * n) + 1))).equals(r11)) {
							arr.add(r12.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + n - 1)) + Character.toString(arr.get((k * n) + 1))).equals(r21)) {
							arr.add(r22.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + n - 1)) + Character.toString(arr.get((k * n) + 1))).equals(r31)) {
							arr.add(r32.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + n - 1)) + Character.toString(arr.get((k * n) + 1))).equals(r41)) {
							arr.add(r42.charAt(0));
						}
					} else if (p + 2 > n) { //if right side of grid; only ever used once
						if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n)))).equals(r11)) {
							arr.add(r12.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n)))).equals(r21)) {
							arr.add(r22.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n)))).equals(r31)) {
							arr.add(r32.charAt(0));
						} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n)))).equals(r41)) {
							arr.add(r42.charAt(0));
						}
					//normal calculations	
					} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n) + p + 1))).equals(r11)) {
						arr.add(r12.charAt(0));
					} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n) + p + 1))).equals(r21)) {
						arr.add(r22.charAt(0));
					} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n) + p + 1))).equals(r31)) {
						arr.add(r32.charAt(0));
					} else if ((Character.toString(arr.get((k * n) + p - 1)) + Character.toString(arr.get((k * n) + p + 1))).equals(r41)) {
						arr.add(r42.charAt(0));
					}
				}
		}
		//print answer to console
		for (int i = n; i > 0; i--) {
			System.out.print(Character.toString(arr.get(arr.size() - i)));
		}
		System.out.println();
		arr.clear(); //clears ArrayList for next test case
		f.next(); //skips the * at end of test case
	}
}