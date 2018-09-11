import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class FooBar11 {

	private static int arr[][] = new int[20][20];
	private static long product = 0;
	private static long h = 0;
	private static long v = 0;
	private static long d1 = 0;
	private static long d2 = 0;
	
	public static void main(String[] args) throws FileNotFoundException {
		File data = new File("C:\\Users\\Malcolm\\eclipse-workspace\\PE Problem 11 - Largest Product in a Grid\\ProductGrid.txt");
		Scanner fileScanner = new Scanner(new BufferedReader(new FileReader(data)));
		run(fileScanner);
	} 
	
	public static void run(Scanner f) {
		for (int i = 0; i < 20; i++) {
			for (int k = 0; k < 20; k++) {
				arr[k][i] = f.nextInt();
			}
		}
		for (int i = 0; i < 20; i++) { //checks all horizontal products
			for (int k = 0; k < 17; k++) {
				product = arr[k][i] * arr[k + 1][i] * arr[k + 2][i] * arr[k + 3][i];
				if (product > h) {
					h = product;
				}
			}		
		}
		
		for (int i = 0; i < 20; i++) { //checks all vertical products
			for (int k = 0; k < 17; k++) {
				product = arr[i][k] * arr[i][k + 1] * arr[i][k + 2] * arr[i][k + 3];
				if (product > v) {
					v = product;
				}
			}		
		}
		
		for (int i = 0; i < 17; i++) { //checks half of diagonal products
			for (int k = 3; k < 20; k++) {
				product = arr[i][k] * arr[i + 1][k - 1] * arr[i + 2][k - 2] * arr[i + 3][k - 3];
				if (product > d1) {
					d1 = product;
				}
			}
		}
		
		for (int i = 19; i > 2; i--) { //checks other half of diagonal products
			for (int k = 19; k > 2; k--) {
				product = arr[i][k] * arr[i - 1][k - 1] * arr[i - 2][k - 2] * arr[i - 3][k - 3];
				if (product > d2) {
					d2 = product;
				}
			}
		}
		//print highest product to the console
		long max = h;
	    if (v > max)
	        max = v;
	    if (d1 > max)
	        max = d1;
	    if (d2 > max)
	        max = d2;
	    System.out.println(max); //can remove the 4 variables
	}
}