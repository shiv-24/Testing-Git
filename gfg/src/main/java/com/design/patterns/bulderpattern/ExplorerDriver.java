package com.design.patterns.bulderpattern;

public class ExplorerDriver {

	public static void main(String[] args) {
		Explorer exp	=	new Explorer();
		exp.setShelterBuilder(new PolarIce());
		exp.constructShelter();
		System.out.println(exp.getShelter());
	}
}
