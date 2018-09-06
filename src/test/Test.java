package test;
import java.util.Arrays;
import java.util.Scanner;

public class Test {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		solve(4, 6);
		System.out.println(count);

	}

	private static int solve(int m, int n) {
		if (m + n < 3 || n < 1 || m < 1) {
			return 0;
		}
		if (m < n) {
			count++;
			m -= 1;
			n -= 2;

		} else {
			count++;
			m -= 2;
			n -= 1;
		}
		return solve(m, n);
	}
}
