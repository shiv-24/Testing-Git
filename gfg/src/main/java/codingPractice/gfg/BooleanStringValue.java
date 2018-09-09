package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BooleanStringValue {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int testCase = Integer.parseInt(br.readLine());
		while (testCase > 0) {

			String s = br.readLine();
			Integer first = s.charAt(0) - 48;
			Integer second = s.charAt(2) - 48;
			char mid = s.charAt(1);
			Integer res = 0;

			if (mid == 'A') {

				res = first & second;
			} else if (mid == 'B') {
				res = first | second;
			} else if (mid == 'C') {
				res = first ^ second;
			}
			for (int i = 4; i < s.length(); i += 2) {
				second = s.charAt(i) - 48;
				mid = s.charAt(i - 1);
				if (mid == 'A') {

					res = res & second;
				} else if (mid == 'B') {

					res = res | second;
				} else if (mid == 'C') {
					res = res ^ second;
				}

			}

			System.out.println(res);

			testCase--;
		}
	}
}
