
public class Foobar14 {

	public static void main(String[] args) {

		int n = 0;
		int terms = 0;
		int chain = 0;
		
		//for (int i = 1; i < 1000000; i++) {
		int i = 113383;	
		n = i;
			//System.out.println(n);
			while (n != 1) {
				if (n % 2 == 0) {
					n = n / 2;
				} else {
					n = (n * 3) + 1;
				}
				terms++;
				System.out.println(n);
			}
			if (terms > chain) {
				chain = terms;
			}
			terms = 0;
		//}
		System.out.println(chain);
	}
}
