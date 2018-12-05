package com.design.patterns.factorypattern;

public class ShapeFactory {

	public Shape getShapeObject(String shapeType) {

		if (shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		} else if (shapeType.equalsIgnoreCase("Square")) {
			return new Square();
		} else {
			return new DefaultShape();
		}
	}

	public ShapeAbsClass getCutOutShape(String shapeType) {

		if (shapeType.equalsIgnoreCase("Circle")) {
			return new Circle();
		} else if (shapeType.equalsIgnoreCase("Triangle")) {
			return new Triangle();
		} else if (shapeType.equalsIgnoreCase("Square")) {
			return new Square();
		} else {
			return new DefaultShape();
		}
	}

}
