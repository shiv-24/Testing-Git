package com.pct.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Basic4 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalP = 0, totalC = 0, totalS = 0;

		String input = br.readLine();

		int testCase = Integer.parseInt(input);

		while (testCase != 0) {
			totalP = 0;
			totalC = 0;
			totalS = 0;
			input = br.readLine();
			for (int i = 0; i < input.length(); i++) {
				char inChar = input.charAt(i);
				if (inChar == '(') {
					totalP++;
				} else if (inChar == ')') {
					totalP--;
				} else if (inChar == '{') {
					totalC++;
				} else if (inChar == '}') {
					totalC--;
				} else if (inChar == '[') {
					totalS++;
				} else if (inChar == ']') {
					totalS--;
				}
			}

			if (totalC != 0 || totalP != 0 || totalS != 0) {
				System.out.println("FALSE");
			} else {
				System.out.println("TRUE");
			}
		}
	}
}
