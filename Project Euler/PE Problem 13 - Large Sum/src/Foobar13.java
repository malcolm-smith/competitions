import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;

public class Foobar13 {
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new FileReader(new File("./src/AddTheseNumbersBitch.txt")));

		BigInteger sum = BigInteger.ZERO;
		
		while(in.hasNext()) {
			sum = sum.add(in.nextBigInteger());
		}

		String answer = sum.toString();
		char c[] = answer.toCharArray();
		for (int i = 0; i < 10; i++) {
			System.out.print(c[i]);
		}
		
		in.close();
	}
}
