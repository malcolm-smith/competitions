import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem2 { //unfinished

	private static final int NUM_OF_TEST_CASES = 2;

	private static ArrayList<String> arr = new ArrayList<>();
	
	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Round 1\\DATA\\DATA11.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	} 
	
	public static void run(Scanner f) {
		int n = f.nextInt();
		
	}
}