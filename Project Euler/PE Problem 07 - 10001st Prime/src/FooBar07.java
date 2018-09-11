public class FooBar07 {
	public static boolean isPrime(int n) {
		if (n == 2) {
			return true;  
		}
        if (n % 2 == 0 || n == 1) {
        	return false;  
        }
        long limit = (long)Math.sqrt(n);
        
        for (int i = 3; i <= limit; i += 2) {  
            if (n % i == 0) {
            	return false;
            }
        }
        return true;  
	}
	
	public static void main (String [] args) {
		int count = 1;  
	    int i = 3;  
	        
	    while (count < 10001) {  
	    	if (isPrime(i)) {
	    		++count;  
	    	}
	        i += 2;  
	    }  
	    System.out.println(i - 2); 
	}
}
