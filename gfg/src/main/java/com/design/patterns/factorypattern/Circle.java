package com.design.patterns.factorypattern;

public class Circle extends ShapeAbsClass implements Shape{

	public void draw() {
		System.out.println("You have drawn a Circle");
		
	}

	@Override
	void cut() {
		
		System.out.println("The cut out shape is a Circle");
	}
	
	

}
