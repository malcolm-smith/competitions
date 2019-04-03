import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10;

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Round 1\\DATA\\DATA11.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	} 
	
	public static void run(Scanner f) {
		double cost = f.nextInt();
		double n1 = f.nextDouble();
		double n2 = f.nextDouble();
		double n3 = f.nextDouble();
		double n4 = f.nextDouble();
		double s = f.nextInt();
		
		double s1 = s * n1;
		double s2 = s * n2;
		double s3 = s * n3;
		double s4 = s * n4;
		
		double totalCost = ((s1 * 12) + (s2 * 10) + (s3 * 7) + (s4 * 5)) * 0.5;

		if (totalCost <= cost) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}
}
