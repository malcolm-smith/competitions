import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem2 {

	private static final int NUM_OF_TEST_CASES = 1;

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOOCS_2016\\Round 1\\DATA\\DATA21.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	} 
	
	public static void run(Scanner f) {
		int n = f.nextInt();
		
		
	}
}	
