package com.java.generics;

public class ComparablePair<A extends Comparable<A>, B extends Comparable<B>> {

	private A firstType;
	private B secondType;

	public ComparablePair() {
		// TODO Auto-generated constructor stub
	}

	public ComparablePair(A firstType, B secondType) {
		this.firstType = firstType;
		this.secondType = secondType;
	}

	public A getA() {
		return this.firstType;
	}

	public B getB() {
		return this.secondType;
	}

	public int compareTo(ComparablePair<A, B> pairToCompare) {
		int compareFType = firstType.compareTo(pairToCompare.getA());
		int compareSType = secondType.compareTo(pairToCompare.getB());

		if (compareFType != 0) {
			return compareFType;
		} else {
			return compareSType;
		}
	}
	
	@Override
	public String toString() {

		return "The Class of Type One is " + this.firstType.getClass().getName() + " and " + "The Class of Type Two is "
				+ this.secondType.getClass().getName();
	}
}
