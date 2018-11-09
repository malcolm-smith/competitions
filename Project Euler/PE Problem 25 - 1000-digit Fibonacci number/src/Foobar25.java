import java.math.BigInteger;

public class Foobar25 {
	public static void main(String[] args) {
		long i = 1;
		BigInteger digits = new BigInteger("0");
		while (digits.toString().length() != 1000) {
			digits = fib(i);
			//System.out.println(digits);
			i++;
		}
		System.out.println(i);
	}

	static BigInteger fib(long n) {
		BigInteger a = new BigInteger("1");
		BigInteger b = new BigInteger("1");
		BigInteger c;
		
		if (n == 0)
			return a;
		for (long i = 2; i <= n; i++) {
			c = a.add(b);
			a = b;
			b = c;
		}
		return b;
	}
}
