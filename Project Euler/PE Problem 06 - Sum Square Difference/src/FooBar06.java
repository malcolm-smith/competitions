public class FooBar06 {
	public static void main(String [] args) {
		int x = 0;
		int a = 0;
		int b = 0;
		
		for (int i = 0; i <= 100; i++) {
			x = (int) Math.pow(i, 2);
			a += x;
		}
		for (int i = 0; i <= 100; i++) {
			b += i;
		}
		int answer = (int)Math.pow(b, 2) - a; 
		System.out.println(answer);
	}
}
