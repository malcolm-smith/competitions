import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Problem3 {

    private static final int NUM_OF_TEST_CASES = 10; //or whatever number of test cases are in the file
    private static String filePath = "../../DATA/DATA30.txt"; //write the file path here

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File(filePath));
        for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
            new Template().run(in);
        }
        in.close();
    }

    public void run(Scanner sc) {

    }
}
