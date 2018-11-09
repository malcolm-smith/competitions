import java.math.BigInteger;

public class Foobar20 {
	public static void main(String[] args) {
		BigInteger ans = BigInteger.ONE;
		int sum = 0;
		
		for (int i = 1; i <= 100; i++) {
			ans = ans.multiply(BigInteger.valueOf(i));
		}
		
		String a = ans.toString();
		
		for (int i = 0; i < a.toString().length(); i++) {
			sum += Integer.parseInt(Character.toString(a.charAt(i)));
		}
		
		System.out.println(sum);
	}
}
