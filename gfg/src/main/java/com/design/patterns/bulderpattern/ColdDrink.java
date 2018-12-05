package com.design.patterns.bulderpattern;

public abstract class ColdDrink implements Items{

	public String name() {
		
		return null;
	}

	public Packing packing() {
		
		return new Bottle();
	}

	public float price() {
		// TODO Auto-generated method stub
		return 0;
	}

}
