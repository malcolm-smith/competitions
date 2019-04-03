import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem1 {

	private static final int NUM_OF_TEST_CASES = 10; //or whatever number of test cases are in the file
	private static String filePath = "C:\\Users\\Malcolm\\Desktop\\GitHub\\Competitions\\ECOO\\ECOOCS_2015\\ECOO 2015 Round 1\\Round 1 Data\\DATA11.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem1().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		int orange = 0;
		int blue = 0;
		int green = 0;
		int yellow = 0;
		int pink = 0;
		int violet = 0;
		int brown = 0;
		int red = 0;
		
		String line;
		while(sc.hasNextLine()) {
			line = sc.nextLine();
			if (line.equals("end of box")) {
				break;
			} else if (line.equals("orange")) {
				orange++;
			} else if (line.equals("blue")) {
				blue++;
			} else if (line.equals("green")) {
				green++;
			} else if (line.equals("yellow")) {
				yellow++;
			} else if (line.equals("pink")) {
				pink++;
			} else if (line.equals("violet")) {
				violet++;
			} else if (line.equals("brown")) {
				brown++;
			} else if (line.equals("red")) {
				red++;
			}
		}
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(orange, blue, green, yellow, pink, violet, brown, red));
		int time = 0;
		for (int i = 0; i < a.size() - 1; i++) {
			time += Math.ceil((double) a.get(i) / 7) * 13;
		}
		for (int i = 0; i < red; i++) {
			time += 16;
		}
		System.out.println(time);
	}							
}