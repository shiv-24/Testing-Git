package com.design.patterns.strategypattern;

public class Add implements Strategy{

	@Override
	public int execute(int a, int b) {
		
		return a+b;
		
	}

	
}
