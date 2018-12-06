package com.java.exceptionhandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class UnCheckedExceptionImpl {

	public static void main(String[] args) {
		String fileName = null;
		Scanner t = new Scanner(System.in);
		fileName = t.nextLine();

		try (Scanner sc = new Scanner(new File(fileName))) {

		} catch (FileNotFoundException e) {
			if (!fileName.equals("LogFile")) {
				throw new CEForUncheckedExceptions("InCorrect FileName", e);
			}

		} finally {
			t.close();
		}

	}
}
