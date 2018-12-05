package com.design.patterns.factorypattern;

public class DefaultShape extends ShapeAbsClass implements Shape{

	public void draw() {
		System.out.println("This is a default shape");
	}

	@Override
	void cut() {
		// TODO Auto-generated method stub
		super.cut();
	}
	
}
