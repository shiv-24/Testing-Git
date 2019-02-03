package com.java.exceptionhandling;

import java.util.Scanner;

public class CheckedExceptionImpl {

	public static void main(String[] args) throws CEForCheckedExceptions {

		Scanner sc = new Scanner(System.in);

		try {
			int x = sc.nextInt();
			if (x < 0) {
				throw new CEForCheckedExceptions();
			}else if(x==0) {
				throw new NullPointerException();
			}
		}finally {
			sc.close();

		}
	}
}
