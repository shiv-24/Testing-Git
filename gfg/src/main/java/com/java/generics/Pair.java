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

	
	public <A,B> Pair<B,A> swap(Pair<A,B> pair){
		return new Pair<B, A>(pair.typeTwo, pair.typeOne);
	}
	@Override
	public String toString() {

		return  this.typeOne+ " : " + this.typeTwo;
	}

}
