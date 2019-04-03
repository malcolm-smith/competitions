import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.FormatFlagsConversionMismatchException;
import java.util.Scanner;

public class Problem2 { // unfinished

	private static final int NUM_OF_TEST_CASES = 2;

	private static ArrayList<String> arr = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("..//..//..//..//ECOOCS_2017//Round 1//DATA//DATA20.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
			System.out.println("NEXT CASE");
		}
	}

	public static void run(Scanner f) {
		

		int numOfChocolates = Integer.parseInt(f.nextLine());
		System.out.println(numOfChocolates);
		Chocolate[] chocs = new Chocolate[numOfChocolates];
		String line = "";
		int temp = -1;
		while (true) {
			line = f.nextLine();

			if (line.charAt(0) == 'J') {
				Scanner sc = new Scanner(line);
				sc.next();
				int pp = (Integer.parseInt(sc.next()));
				int ff = (Integer.parseInt(sc.next()));
				int gg = (Integer.parseInt(sc.next()));
				chocs[temp].p += pp;
				chocs[temp].f += ff;
				chocs[temp].g += gg;
				chocs[temp].total = chocs[temp].p + chocs[temp].f + chocs[temp].g;
				sc.close();
			} else if (line.charAt(0) == '*') {
				break;
			} else {
				temp++;
				chocs[temp] = new Chocolate(line);
			}
		}
		for (Chocolate choc : chocs) {
			System.out.println(choc.name + " " + choc.total);
		}
	}
}

class Chocolate {
	String name;
	int p = 0;
	int f = 0;
	int g = 0;
	int total = 0;

	public Chocolate(String str) {
		name = str;
	}
}