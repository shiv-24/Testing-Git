package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ClosestNumber {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());

		while (testCase > 0) {

			String[] arr = br.readLine().split(" ");

			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);

			int half = m / 2;

			int pct = n % m;

			if (m % 2 == 0) {
				if (Math.abs(pct) < half) {
					int divide = n / m;
					System.out.println((divide) * m);
				} else {
					int divide = n / m;
					if (n > 0) {
						System.out.println((divide + 1) * m);
					} else {
						System.out.println((divide - 1) * m);
					}
				}
			} else {
				if (Math.abs(pct) < (half + 1)) {
					int divide = n / m;
					System.out.println((divide) * m);
				} else {
					int divide = n / m;
					System.out.println((divide + 1) * m);
				}
			}

			testCase--;
		}
	}

}
