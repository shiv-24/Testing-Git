package com.design.patterns.factorypattern;

public class Square extends ShapeAbsClass implements Shape {

	public void draw() {
		System.out.println("You have drawn a Swaure");
	}

	@Override
	void cut() {
		System.out.println("Cut out shape is a Square");
	}
}
