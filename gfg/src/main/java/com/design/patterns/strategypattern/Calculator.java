package com.design.patterns.strategypattern;

public class Calculator {

	public Strategy strategy;
	
	public void setStrategy(Strategy strategy) {
		this.strategy	=	strategy;
	}
	
	public int execute(int a, int b) {
		return strategy.execute(a,b);
	}
	
}
