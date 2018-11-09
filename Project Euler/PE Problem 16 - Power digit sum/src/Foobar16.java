import java.math.BigInteger;

public class Foobar16 {
	public static void main(String[] args) {
		String str = new BigInteger("2").pow(1000).toString();
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			sum += Integer.parseInt(Character.toString(str.charAt(i)));
		}
		System.out.println(sum);
	}
}
