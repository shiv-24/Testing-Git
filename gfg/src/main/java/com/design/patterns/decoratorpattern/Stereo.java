package com.design.patterns.decoratorpattern;

public class Stereo extends CarDecorator{

	public Stereo(Car obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}

	public double getCarCost() {
		// TODO Auto-generated method stub
		return obj.getCarCost()+5000;
	}

	public String getCarAccessories() {
		return obj.getCarAccessories()+" Stereo";
	}
}
