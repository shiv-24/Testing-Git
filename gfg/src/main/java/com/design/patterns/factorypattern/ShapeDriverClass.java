package com.design.patterns.factorypattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ShapeDriverClass {

	static ShapeFactory facObject = new ShapeFactory();

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String input = br.readLine();

			while (!input.equalsIgnoreCase("-1")) {
				// ShapeAbsClass obj = facObject.getShapeObject(input);
				ShapeAbsClass obj = facObject.getCutOutShape(input);
				obj.cut();
				input = br.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
