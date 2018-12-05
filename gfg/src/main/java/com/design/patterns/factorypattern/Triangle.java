package com.design.patterns.factorypattern;

public class Triangle extends ShapeAbsClass implements Shape{

	public void draw() {
		
		System.out.println("You have drawn a Triangle");
		
	}

	@Override
	void cut() {
		System.out.println("The cut out shape is a Triangle");
	}

}
