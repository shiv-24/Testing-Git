package com.design.patterns.decoratorpattern;

public class Tata extends Car{

	@Override
	public double getCarCost() {
		// TODO Auto-generated method stub
		return 500000;
	}

	@Override
	public String getCarAccessories() {
		return "Tata";
	}

}
