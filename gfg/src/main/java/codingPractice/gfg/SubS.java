package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubS {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

//		subString(s, s.length());
		subS(s, s.length());
	}

	static void subString(String str, int n) {
		// Pick starting point
		for (int len = 1; len <= n; len++) {
			// Pick ending point
			for (int i = 0; i <= n - len; i++) {
				// Print characters from current
				// starting point to current ending
				// point.
				int j = i + len - 1;
				for (int k = i; k <= j; k++) {
					System.out.print(str.charAt(k));
				}

				System.out.println();
			}
		}
	}

	static void subS(String s, int len) {
		 
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<=len;j++) {
				for(int k=i;k<j;k++) {
					System.out.print(s.charAt(k));
				}
				System.out.println();
			}
			
		}
		 
		 
	 }
}
