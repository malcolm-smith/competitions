import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class Problem2 {
	private static final int NUM_OF_TEST_CASES = 10;

	private static ArrayList<Integer> problemRoutes = new ArrayList<Integer>();
	private static int[] r;
	private static int min = 90000;

	public static void main (String [] args) throws FileNotFoundException{
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOO2018\\Round 1\\DATA\\DATA22.txt");
		Scanner fileScanner = new Scanner (new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			run(fileScanner);
		}
	}

public static void run (Scanner f) {
		int routeNum = f.nextInt();

		for (int o = 0; o < routeNum; o++) {
			int temp;
			int ROUTEIDD = f.nextInt();
			int roundabouts = f.nextInt();

			r = new int[roundabouts];

			for (int i = 0; i < roundabouts; i++) { //places round-a-bouts into routeID array
				r[i] = f.nextInt();
			}

			for (int i = 0; i < routeNum; i++) { //finds lowest number in row and expresses as r[0]
				for (int p = i + 1; p < roundabouts; p++) {
					if (r[i] > r[p]) {
						temp = r[i];
						r[i] = r[p];
						r[p] = temp;
					}
				}
			}

			if (min > r[0]) { //creating list of problem routes
				min = r[0];
				problemRoutes.clear();
				problemRoutes.add(ROUTEIDD);
			} else if (min == r[0]) {
				problemRoutes.add(ROUTEIDD);
			}
		}
		Collections.sort(problemRoutes); //this can screw you over... formatting is key (ascending order in this case)
		System.out.println(min + " " + problemRoutes);
		min = 900000; //this one line screwed me over for a couple days...
	}
}
