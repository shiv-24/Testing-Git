package com.design.patterns.strategypattern;

public class Mod implements Strategy{

	@Override
	public int execute(int a, int b) {
		// TODO Auto-generated method stub
		return a%b;
	}

}
