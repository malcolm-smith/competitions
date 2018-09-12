import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10;

	public static void main(String[] args) throws FileNotFoundException {
		//File data = new File("E:\\DATA11.txt"); //USB file-path
		File data = new File("C:\\Users\\Malcolm\\Desktop\\ECOO2018\\Round 1\\DATA\\DATA11.txt"); //test case file-path
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
			
		}
	} 
	
	public static void run(Scanner f) { //error occurs when scanner finds null at end of file
		int days = f.nextInt();
		int totalDays = f.nextInt();
		String input ;
		int x = 0;
		
		for (int i = 0; i < totalDays; i++) {
			input = f.next();
			if (input.equals("B")) {
				x += days;
				x--;
			} else if (input.equals("E")) {
				x--;
				if (x < 0) {
					x = 0;
				}
			}
		}

		System.out.println(x);
	}
}