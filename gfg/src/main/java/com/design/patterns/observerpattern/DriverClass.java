package com.design.patterns.observerpattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DriverClass {

	private static UserName obj;
	private static UserNameChecker checkerObj;

	public static void main(String[] args) throws Exception {
		setUp();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(" Enter User Names and Enter -1 to end ");

		String input = new String();
		while (!input.equalsIgnoreCase("-1")) {
			input = br.readLine();
			if (input.equalsIgnoreCase("-1")) {
				break;
			}
			obj.setName(input);
			if (!obj.getIfNameIsPresent()) {
				System.out.println("Name is Not Present in the list Do you want to Add the Name (Y/N)");
				String choice = br.readLine();
				if (choice.equalsIgnoreCase("Y")) {
					obj.setIfNameIsPresentOrNot(true);
					obj.setName(input);
				}
			}
		}

		for (int i = 0; i < obj.getAllUserNameLsit().size(); i++) {
			System.out.println(obj.getAllUserNameLsit().get(i));
		}
	}

	public static void setUp() {
		obj = new UserName();
		checkerObj = new UserNameChecker();
		obj.addObserver(checkerObj);
	}
}
