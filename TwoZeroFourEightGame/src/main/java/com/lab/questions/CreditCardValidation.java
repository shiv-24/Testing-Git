package com.lab.questions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CreditCardValidation {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long number = Long.parseLong(br.readLine());
		int ifValid = validCardnumber(number);
		if (ifValid == 0) {
			System.out.println("VALID");
		} else {
			System.out.println("INVALID " + ifValid);
		}
	}

	static int validCardnumber(long number) {
		int sum = 0;
		boolean alternate = false;
		int remainder = 0;
		while (number / 10 != 0) {
			remainder = (int) (number % 10);
			if (alternate) {
				alternate = false;
				remainder *= 2;
				while (remainder / 10 != 0) {
					sum += (remainder % 10);
					remainder = remainder / 10;
				}
				sum += remainder;
			} else {
				sum += remainder;
				alternate = true;
			}
			number = number / 10;
		}
		if (alternate) {
			number *= 2;
			while (number / 10 != 0) {
				sum += (number % 10);
				number = number / 10;
			}
		}
		sum += number;
		sum %= 10;
		return sum;
	}
}
