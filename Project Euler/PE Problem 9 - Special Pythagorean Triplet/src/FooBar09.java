public class FooBar09 {
	
	public static void main(String [] args) {
		double aa, bb, cc;

		for (int a = 1; a < 1000; a++) {
			for (int b = 1; b < 1000; b++) {
				for (int c = 1; c < 1000; c++) {
					if (a + b + c == 1000) {
						aa = Math.pow(a, 2);
						bb = Math.pow(b, 2);
						cc = Math.pow(c, 2);
						if (aa + bb == cc) {
							System.out.println(a * b * c);
							System.exit(0);
						} else if (bb + cc == aa) {
							System.out.println(a * b * c);
							System.exit(0);
						} else if (aa + cc == bb) {
							System.out.println(a * b * c);
							System.exit(0);
						}
					}
				}
			}
		}
	}
}
