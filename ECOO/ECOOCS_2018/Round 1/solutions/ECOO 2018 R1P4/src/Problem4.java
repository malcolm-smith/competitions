import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem4 {

	private static final int NUM_OF_TEST_CASES = 1; //or whatever number of test cases are in the file
	private static String filePath = "../../DATA/DATA40.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem4().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.printf("X:\t%d\nY:\t%d\n", x, y);

		Point point = new Point(x, y);
		Rectangle rect = new Rectangle(new Point(6, 6));
		rect.add(new Point(8, 2));
		int counter = 0;
		System.out.println(rect.toString());
		System.out.println(rect.contains(point));

		
	}
}
