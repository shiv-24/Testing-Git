package com.java.exceptionhandling;

import java.io.File;

public class SimpleExample {

	public static void main(String[] args) {
		try {

			File file = new File("C://Coding Practice//file.txt");
			String[] contents = file.list();
			if (contents == null) {
				throw new NullPointerException("File does not have anything");
			}
			System.out.println(contents[1]);
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();

		}

		System.out.println("File nahi Milli");
	}
}
