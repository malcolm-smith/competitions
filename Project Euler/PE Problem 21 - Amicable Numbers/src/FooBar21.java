import java.util.*;

public class FooBar21 {
	public static int sum = 0;
	
	public static int divisorSum(int a) {
		sum = 0;
		
		for (int i = 1; i < a; i++) {
			if ((a % i) == 0) {
				System.out.println(i);
				sum += i;
			}
		}
		return sum;
	}
	
	public static boolean amicable(int a, int b) {
		if (divisorSum(a) == b && divisorSum(b) == a) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int amiNumSum(int a) {
		int totalSum = 0;
		
		while (true) {
			for (int i = 0; i <= a; i++) {
				if (i == a) {
					i++;
				} if (amicable(i, a)) {
					totalSum += i + a;
				} 
			}
			break;
		}
		return totalSum;
	}
	
	public static void main(String [] args) {
		System.out.println(divisorSum(284));
		System.out.println(divisorSum(220));
	}
}
