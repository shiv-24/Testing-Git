package codingPractice.gfg;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HackerBlocksQuestion1 {

//	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String endText = new String("X");
//		String endTextSmall = new String("x");
//		String plus = new String("+");
//		String minus = new String("-");
//		String multiply = new String("*");
//		String divide = new String("/");
//		String mod = new String("%");
//		String input;
//		// System.out.println(plus.toUpperCase());
//		do {
//			input = br.readLine();
//			if (input.equals(plus)) {
//				int a = Integer.parseInt(br.readLine());
//				int b = Integer.parseInt(br.readLine());
//				System.out.println(a + b);
//			} else if (input.equals(minus)) {
//				int a = Integer.parseInt(br.readLine());
//				int b = Integer.parseInt(br.readLine());
//				System.out.println(a - b);
//			} else if (input.equals(multiply)) {
//				int a = Integer.parseInt(br.readLine());
//				int b = Integer.parseInt(br.readLine());
//				System.out.println(a * b);
//			} else if (input.equals(divide)) {
//				int a = Integer.parseInt(br.readLine());
//				int b = Integer.parseInt(br.readLine());
//				System.out.println(a / b);
//			} else if (input.equals(mod)) {
//				int a = Integer.parseInt(br.readLine());
//				int b = Integer.parseInt(br.readLine());
//				System.out.println(a % b);
//			}else {
//				if(!(input.equals(endTextSmall)||input.equals(endText)))
//				System.out.println("Invalid Text");
//			}
//		} while (!(input.equals(endText) || input.equals(endTextSmall)));
//
//	}
	
	public static void main(String[] args) {
		Scanner sc	=	new Scanner(System.in);
		int []arr	=	new int[200];
		int i=0;
		String str	=	sc.next();
		char c	=	str.charAt(0);
		do {
			int a	=	sc.nextInt();
			int b	=	sc.nextInt();
			System.out.println(a+b);
		}while(false);
	}
}
