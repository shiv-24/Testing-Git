package com.java.generics;

public class Pair<A, B> {

	private A typeOne;
	private B typeTwo;

	public Pair() {
	}

	public Pair(A typeOne, B typeTwo) {
		this.typeOne = typeOne;
		this.typeTwo = typeTwo;
	}

	public A getA() {
		return this.typeOne;
	}

	public B getB() {
		return this.typeTwo;
	}

	@Override
	public String toString() {

		return "The Class of Type One is " + this.typeOne.getClass().getName() + " and " + "The Class of Type Two is "
				+ this.typeTwo.getClass().getName();
	}

}
