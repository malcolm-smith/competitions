
public class Foobar14 {

	public static void main(String[] args) {

		Long n = 0L;
		int terms = 0;
		int chain = 0;
		Long answer = 0L;
		
		for (Long i = 1L; i < 1000000; i++) {
			n = i;
			while (n != 1) {
				if (n % 2 == 0) {
					n = n / 2;
				} else {
					n = (n * 3) + 1;
				}
				terms++;
			}
			if (terms > chain) {
				chain = terms;
				answer = i;
			}
			terms = 0;
		}
		System.out.println(answer);
	}
}
