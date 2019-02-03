package com.lab.questions;

public class Rational {

	private long num, denorm;
	
	public Rational() {
		this.num = 0;
		this.denorm = 1;

	}
	
	public Rational(long num, long denorm) {
		this.num	=	num;
		this.denorm	=	denorm;
		
	}
	
	public void normalize() {
		
		long num =	this.num;
		long denorm	=	this.denorm;
		
		if(denorm<0) {
			this.denorm	=	-denorm;
			this.num	=	-num;
			
		}
	}
	
	public void reduce() {
		this.normalize();
		long g	=	gcd(this.num,this.denorm);
		this.num/=g;
		this.denorm/=g;
	}
	
	private long gcd(long a, long b) {
		
		long g;
		if(b==0) {
			return a;
		}else {
			g=		gcd(b,(a%b));
			if(g<0)
				return -g;
			else return g;
		}
	}
	
	public long num() {
		return this.num;
	}
	
	public long denorm() {
		return this.denorm;
	}
	
	public Rational add(Rational r) {
		Rational result	=	new Rational();
		result.num	=	(this.num*r.denorm())+(this.denorm*r.num());
		result.denorm	=	this.denorm*r.denorm();
		result.normalize();
		result.reduce();
		return result;
	}
	
	public Rational sub(Rational r) {
		Rational result	=	new Rational();
		result.num	=	(this.num*r.denorm())-(this.denorm*r.num());
		result.denorm	=	this.denorm*r.denorm();
		result.normalize();
		result.reduce();
		return result;
	}
	
	public Rational mul(Rational r) {
		Rational result	=	new Rational();
		result.num	=	this.num*r.num();
		result.denorm	=	this.denorm*r.denorm();
		result.normalize();
		result.reduce();
		return result;
	}
	
	public Rational div(Rational r) {
		Rational result	=	new Rational();
		result.num	=	this.num*r.denorm();
		result.denorm	=	this.denorm*r.num();
		result.normalize();
		result.reduce();
		return result;
	}
	
	public boolean equal(Rational r) {
		
		if((this.num()*r.denorm())==(this.denorm*r.num())) {
			return true;
		}else {
			return false;
		}
	}
	
	public String toString() {
		return String.valueOf(this.num)+" / "+ String.valueOf(this.denorm);
	}
	
	public static void main(String[] args) {
		
//		Rational a	=	new Rational(1, 2);
//		Rational b	=	new Rational(2, 3);
//		Rational c;
//		
//		c	=	a.add(b);
//		
//		c	=	a.sub(b);
//		
//		c	=	a.mul(b);
//		
//		c	=	a.div(b);
		
		Rational a	=	new Rational(2, 4);
		a.reduce();
		System.out.println(a.num());
		System.out.println(a.denorm());
	}
}
