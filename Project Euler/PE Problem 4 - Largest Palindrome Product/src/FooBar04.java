import java.util.ArrayList;
import java.util.Collections;

public class FooBar04 {
	public static boolean isPalindrome(int n) {
		 int palindrome = n;
		    int reverse = 0;

		    // Compute the reverse
		    while (palindrome != 0) {
		        int remainder = palindrome % 10;
		        reverse = reverse * 10 + remainder;
		        palindrome = palindrome / 10;
		    }

		    // The integer is palindrome if integer and reverse are equal
		    return n == reverse; // Improved by Peter Lawrey
	}
	
	public static void main(String [] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		
		for (int i = 999; i > 0; i--) {
			for (int k = 999; k > 0; k--) {
				if (isPalindrome(i * k)) {
					arr.add(i * k);
				}
			}
		}
		System.out.println(Collections.max(arr));
	}
}