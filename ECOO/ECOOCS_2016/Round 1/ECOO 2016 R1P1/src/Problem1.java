import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10;

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOOCS_2016\\Round 1\\DATA\\DATA11.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	}

	public static void run(Scanner f) {
		//TAPQ
		int passes = 0;
		double av = 0;

		double w[] = new double[4];
		for (int i = 0; i < 4; i++) {
			w[i] = Double.parseDouble(f.next());
		}
		int num = f.nextInt();
		int arr[][] = new int[num][4];
		for (int i = 0; i < num; i++) {
			for (int k = 0; k < 4; k++) {
				arr[i][k] = f.nextInt();
				av += (arr[i][k] * (w[k] / 100));
			}
			if (av >= 50.0) {
				passes++;
			}
			av = 0;
		}
		System.out.println(passes);


	}
}
