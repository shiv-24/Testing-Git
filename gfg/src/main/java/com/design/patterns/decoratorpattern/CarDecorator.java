package com.design.patterns.decoratorpattern;

public class CarDecorator extends Car{

	Car obj;

	public CarDecorator(Car obj) {
		this.obj = obj;
	}

	public double getCarCost() {
		// TODO Auto-generated method stub
		return obj.getCarCost();
	}

	public String getCarAccessories() {
		return obj.getCarAccessories();
	}

}
