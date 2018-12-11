package com.design.patterns.strategypattern;

public class DriverClass {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		cal.setStrategy(new Add());
		System.out.println(cal.execute(3, 4));

		cal.setStrategy(new Mod());
		System.out.println(cal.execute(3, 4));

	}
}
