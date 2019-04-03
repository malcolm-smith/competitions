import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Problem1 {


	private static final int NUM_OF_TEST_CASES = 10; //or whatever number of test cases are in the file
	private static String filePath = "C:\\Users\\Malcolm\\Desktop\\GitHub\\Competitions\\ECOO\\ECOOCS_2014\\ECOO 2014 Round 1\\data\\DATA11.txt"; //write the file path here

	public static void main(String[] args) throws FileNotFoundException {

		Scanner in = new Scanner(new File(filePath));
		for (int i = 0; i < NUM_OF_TEST_CASES; i++) {
			new Problem1().run(in);
		}
		in.close();
	}

	public void run(Scanner sc) {
		DecimalFormat df = new DecimalFormat("00");
		
		int earthdays = sc.nextInt();
		int earthhours = sc.nextInt();
		int earthmins = sc.nextInt();
		double earthsecs = (earthdays * 60 * 60 * 24) + (earthhours * 60 * 60) + (earthmins * 60);
		double ratio = 86400 / 88642.663;
        double marssecs = earthsecs * ratio;
        
        int days = (int)marssecs / (int)(86400);
         
        double daystosecs = days * 86400;
        double hourstosecs = marssecs - daystosecs;
        int marshours = (int)hourstosecs / (3600);
        
        double minstosecs = marssecs - daystosecs - marshours * 3600;
        double marsmins = Math.round(minstosecs / 60.0);
        
        if (earthdays != 0 || earthhours != 0 || earthmins != 0) {
        	marsmins += 36;
        } 
        if (marsmins > 59) {
            marshours += 1;
            marsmins -= 60;
        }   
        System.out.println("Day " + days + ", " + df.format(marshours) + ":" + df.format(marsmins));
	}
}
