package com.design.patterns.adapterpattern;

public class SqaurePegAdaptor extends SquarePeg implements Peg {

	SquarePeg squarePeg;

	public SqaurePegAdaptor(SquarePeg squarePeg) {

		this.squarePeg = squarePeg;
	}

	@Override
	public void insertPeg() {
		squarePeg.insertSqaurePeg();

	}

}
