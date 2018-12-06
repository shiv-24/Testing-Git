package com.design.patterns.adapterpattern;

public class DriverClass {

	public static void main(String[] args) {

		RoundPeg roundPeg = new RoundPeg();

		SquarePeg squarePeg = new SquarePeg();

		Peg pegObj = new SqaurePegAdaptor(squarePeg);

		System.out.println("Round Peg");
		roundPeg.insertPeg();

		System.out.println("Sqaure Object via pegObject ");
		pegObj.insertPeg();

		System.out.println("Sqaure Object Directly ");
		squarePeg.insertSqaurePeg();
		;
	}
}
