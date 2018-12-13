package com.design.patterns.decoratorpattern;

public class SUV extends CarDecorator{

	public SUV(Car obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}

	public double getCarCost() {
		// TODO Auto-generated method stub
		return obj.getCarCost()+100000;
	}

	public String getCarAccessories() {
		return obj.getCarAccessories()+" SUV";
	}
}
