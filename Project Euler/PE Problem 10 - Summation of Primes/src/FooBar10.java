public class FooBar10 {
	public static boolean isPrime(long n) {
	    //check if n is a multiple of 2
	    if (n % 2 == 0) return false;
	    //if not, then just check the odds
	    for (int i = 3; i * i <= n; i += 2) {
	        if (n % i == 0)
	            return false;
	    }
	    return true;
	}
	
	public static void main(String [] args) {
		long sum = 2;
		
		for (int i = 3; i <= 2000000; i++) {
			if (isPrime(i)) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
	}
}
