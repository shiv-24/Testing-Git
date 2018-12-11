package com.design.patterns.decoratorpattern;

public class Maruti extends Car {

	@Override
	public double getCarCost() {
		return 1000000.0;
	}

	@Override
	public String getCarAccessories() {
		return "Maruti";
	}

}
