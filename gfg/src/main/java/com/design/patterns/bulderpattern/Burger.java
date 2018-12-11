package com.design.patterns.bulderpattern;

public abstract class Burger implements Items{

	public String name() {
		// TODO Auto-generated method stub
		return null;
	}

	public Packing packing() {
		// TODO Auto-generated method stub
		return new Wrapper();
	}

	public float price() {
		// TODO Auto-generated method stub
		return 0;
	}

}
