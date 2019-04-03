import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
 
public class Problem3 {
	private static final int NUM_OF_TEST_CASES = 10;
	
	static ArrayList<ArrayList<Integer>> keys = new ArrayList<>();
	static ArrayList<ArrayList<Integer>> answers = new ArrayList<>();
	static ArrayList<Integer> fails = new ArrayList<Integer>();
	
	static int n;
	static int x;
	static int y;
	static int z;
	
	public static void main (String [] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOO2018\\Round 1\\DATA\\DATA32.txt"); //change file-path and NUM_OF_TEST_CASES for actual test file
		Scanner fileScanner = new Scanner (new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	}
	
	public static void run (Scanner f) {
		n = f.nextInt();
		x = f.nextInt();
		y = f.nextInt();
		z = f.nextInt();
		
		for (int k = 0; k < n; k++) { //does this for each key
			//takes in keys as Strings, then to array of characters
			String code = f.next();
			char[] code2 = code.toCharArray();
			ArrayList<Integer> code3 = new ArrayList<>();
			
			//converts array of characters to ArrayList of integers
			for (int i = 0; i < code2.length; i++) {
				code3.add(Character.getNumericValue(code2[i]));
			}
			
			for (int i = 0; i <= code3.size() - 1; i++) { //translating keys
				int c = code3.get(i);
				if (code3.get(i) == 0) {
					code3.set(i, z);
				} else if (code3.get(i) % 2 == 0) {
					code3.set(i, c += x);
				} else {
					code3.set(i, c -= y);
					if (code3.get(i) < 0) { //numbers cannot be subtracted below 0
						code3.set(i, 0);
					}
				}
			}
			
			//used in next block
			int c1 = 0;
			int c2 = 0;

			for (int i = 0; i < code3.size(); i++) { //used to debug a key comparison logic error
				if (code3.get(i) >= 10) {
					c1 = Character.getNumericValue(Integer.toString(code3.get(i)).charAt(0));
					c2 = Character.getNumericValue(Integer.toString(code3.get(i)).charAt(1));
					code3.set(i, c1);
					code3.add(i + 1, c2);
				}
			}
			keys.add(code3);
		}
		f.next(); //skips A
		
		for (int k = 0; k < n; k++) { //gets answer key and places in ArrayList
			String a = f.next();
			char[] a2 = a.toCharArray();
			ArrayList<Integer> a3 = new ArrayList<>();
			
			for (int i = 0; i < a2.length; i++) {
				a3.add(Character.getNumericValue(a2[i]));
			}
			answers.add(a3);
		}
		
		for (int i = 0; i < keys.size(); i++) { //compares keys to answer keys, if fails adds incorrect key to fails array
			for (int p = 0; p < keys.get(i).size(); p++) {
				if (keys.get(i).get(p) != answers.get(i).get(p)) {
					fails.add(i + 1);
					break;
				}
			}
		}
		
		if (fails.size() > 0) { //print out answer
			System.out.print("FAIL: ");
			for (int i = 0; i < fails.size() - 1; i++) {
				System.out.print(fails.get(i) + ", ");
			}
			System.out.print(fails.get(fails.size() - 1));
		} else {
			System.out.print("MATCH");
		}
		System.out.print("\n");
		
		f.next(); //skips the *
		
		//clears arrays for next test case
		keys.clear();
		answers.clear();
		fails.clear();
	}
}
