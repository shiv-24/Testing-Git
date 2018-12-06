package com.java.exceptionhandling;

import java.util.Scanner;

public class CheckedExceptionImpl {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			int x = sc.nextInt();
			if (x < 0) {
				throw new CEForCheckedExceptions("Input cannot be less than 0");
			}
		} catch (CEForCheckedExceptions e) {
			String errorMessage = e.getMessage();
			System.out.println(errorMessage);

		} finally {
			sc.close();

		}
	}
}
