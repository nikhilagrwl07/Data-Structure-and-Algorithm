

package Codeforces_pratice;
import java.util.Scanner;

public class C572_LengthingStick {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int a = scanner.nextInt();
		int b = scanner.nextInt();
		int c = scanner.nextInt();
		long l = scanner.nextInt();

		// ( l + 4 - 1 )
		// (     l     )

		// Total ways to distribute l amongst a, b and c
		long total = ((l + 1) * (l + 2) * (l + 3)) / 6;
		long subtract = 0;

		// Calculate the amount of invalid distributions of l amongst a, b and c
		for(int i = 0; i <= l; i++) {
			if(!isValid(a + i, b + c)) {
				long n = Math.min((a + i) - (b + c), l - i);
				subtract += ((n + 2) * (n + 1)) / 2;

			}

		}
		for(int i = 0; i <= l; i++) {
			if(!isValid(b + i, a + c)) {
				long n = Math.min((b + i) - (a + c), l - i);
				subtract += ((n + 2) * (n + 1)) / 2;

			}

		}
		for(int i = 0; i <= l; i++) {
			if(!isValid(c + i, a + b)) {
				long n = Math.min((c + i) - (a + b), l - i);
				subtract += ((n + 2) * (n + 1)) / 2;

			}

		}

		System.out.println(total - subtract);

	}

	private static boolean isValid(long base, long sumOfSides) {
		return base < sumOfSides;

	}


}
