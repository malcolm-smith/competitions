import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Foobar {

	private static final int NUM_OF_TEST_CASES = 10;

	public static void main(String[] args) throws FileNotFoundException {
		//File data = new File("E:\\DATA11.txt"); //USB file-path
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOOCS_2016\\Round 1\\DATA\\DATA11.txt"); //test case file-path
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
			
		}
	} 
	
	public static void run(Scanner f) { //error occurs when scanner finds null at end of file
		int weights[] = new int[4];
		for (int i = 0; i < 4; i++) {
			weights[i] = f.nextInt();
		}
		int n = f.nextInt();
		int student[][] = new int[n][4];
		int passes = 0;
		for (int i = 0; i < n; i++) {
			for (int k = 0; k < 4; k++) {
				student[i][k] = f.nextInt();
			}
		}
		for (int i = 0; i < n; i++) {
			int score = 0;
			for (int k = 0; k < 4; k++) {
				score += (weights[k] * student[i][k]); //discrepancy due to dividing by 100. removed the dividing to keep accuracy
			}
			if (score >= 5000) {
				passes++;
			}
		}
		System.out.println(passes);
	}
}