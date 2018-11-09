import java.util.ArrayList;
import java.util.Collections;

public class FooBar12 {

	public static void main(String[] args) {
		int divisors = 0;
		int term = 1;
		int a = 0;
		
		while (divisors <= 500) {
			term++;
			a = 0;
			for (int i = 0; i < term; i++) {
				a += i;
			}
			divisors = allFactors(a).size();
		}
		System.out.println(a);
	}

	public static ArrayList<Integer> allFactors(int a) {

		int upperlimit = (int) (Math.sqrt(a));
		ArrayList<Integer> factors = new ArrayList<Integer>();
		for (int i = 1; i <= upperlimit; i += 1) {
			if (a % i == 0) {
				factors.add(i);
				if (i != a / i) {
					factors.add(a / i);
				}
			}
		}
		Collections.sort(factors);
		return factors;
	}
}
