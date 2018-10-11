
import java.util.*;

public class FooBar03 {
	public static boolean isPrime(long n) {
		for (int i = 2; i < n; i++) {
	        if (n % i == 0)
	            return false;
	        else if (n % 71 == 0)
	        	return false;
	    }
	    return true;
	}

	public static void main(String [] args) {
		long number = 600851475143L;
		long stop = number / 2;
		ArrayList<Long> list = new ArrayList<Long>();

		for (long i = 1; i <= stop; i += 2) {
			if (number % i == 0) {
				System.out.print(i + " ");
				list.add(i);
				stop = number / i;
				System.out.print(stop + " ");
				list.add(stop);
			}
		}
		System.out.println("Done\n");

		for (int i = 0; i < list.size(); i++) {
			long n2 = Collections.max(list);
			if (isPrime(n2)) {
				System.out.print("\nNumber is: " + n2);
				break;
			} else {
				System.out.println("Removed " + n2);
				list.remove(list.indexOf(n2));
				i = 0;
			}
		}
	}
}
