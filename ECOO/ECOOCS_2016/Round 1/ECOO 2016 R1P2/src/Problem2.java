import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Problem2 {

	private static final int NUM_OF_TEST_CASES = 1;
	
	public String str = "";
	public int score = 0;
	public int scale = 0;
	public int spinNums[];
	public int poss[];
	
	public static void main(String[] args) throws FileNotFoundException {
		Problem2 m = new Problem2();
		File data = new File("C:\\Users\\Malcolm\\Desktop\\Computer Science\\ECOO\\ECOOCS_2016\\Round 1\\DATA\\DATA20.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			m.run(fileScanner);
		}
	} 
	
	public void run(Scanner f) {
		score = 0;
		
		scale = f.nextInt();
		int spinNums[] = new int[scale];
		for (int i = 0; i < spinNums.length; i++) {
			spinNums[i] = f.nextInt();
		//	System.out.println(spinNums[i]);
		}
		int poss[] = new int[5];
		for (int i = 0; i < 5; i++) {
			poss[i] = f.nextInt();
		}
		
		
		
		
		int m = 0;
		for (int q = 0; q < 5; q++) {
			for (int i = 0; i < spinNums.length; i++) {
				score = spinNums[i];
				for (int k = 0; k < spinNums.length; k++) { //add
					score += spinNums[i];
					for (int p = 0; p < spinNums.length; p++) { //add
						score += spinNums[i];
						System.out.println(score + " 1");
							if (score == poss[q]) {
								m++;
							}
					}
				}
				score = spinNums[i];
				for (int k = 0; k < spinNums.length; k++) {//mul
					score = score * spinNums[i];
					for (int p = 0; p < spinNums.length; p++) { //add
						score += spinNums[i];
						System.out.println(score + " 2");
						if (score == poss[q]) {
							m++;
						}
					}
				}
				score = spinNums[i];
				for (int k = 0; k < spinNums.length; k++) {//mul
					score = score * spinNums[i];
					for (int p = 0; p < spinNums.length; p++) { //mul
						score = score * spinNums[i];
						System.out.println(score + " 3");
						if (score == poss[q]) {
							m++;
						}
					}
				}
				score = spinNums[i];
				for (int k = 0; k < spinNums.length; k++) {//add
					score = score + spinNums[i];
					for (int p = 0; p < spinNums.length; p++) { //add
						score = score + spinNums[i];
						System.out.println(score + " 4");
						if (score == poss[q]) {
							m++;
						}
					}
				}
			}
			if (m == 0) {
				str = str + "F";
			} else {
				str = str + "T";
			}
			m = 0;
			System.out.println("\n\n\n\n");
		}
		//System.out.println(str);
	}
	
	public boolean check(int a) {
		for (int i = 0; i < spinNums.length; i++) {
			score = spinNums[i];
			for (int k = 0; k < spinNums.length; k++) { //add
				score += spinNums[i];
				for (int p = 0; p < spinNums.length; p++) { //add
					score += spinNums[i];
					
						if (score == a) {
							return true;
						}
					
				}
			}
			score = spinNums[i];
			for (int k = 0; k < spinNums.length; k++) {//mul
				score = score * spinNums[i];
				for (int p = 0; p < spinNums.length; p++) { //add
					score += spinNums[i];

					if (score == a) {
						return true;
					}
				}
			}
			score = spinNums[i];
			for (int k = 0; k < spinNums.length; k++) {//mul
				score = score * spinNums[i];
				for (int p = 0; p < spinNums.length; p++) { //mul
					score = score * spinNums[i];

					if (score == a) {
						return true;
					}
				}
			}
			score = spinNums[i];
			for (int k = 0; k < spinNums.length; k++) {//add
				score = score + spinNums[i];
				for (int p = 0; p < spinNums.length; p++) { //add
					score = score + spinNums[i];

					if (score == a) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
