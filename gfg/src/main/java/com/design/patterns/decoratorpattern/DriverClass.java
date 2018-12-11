package com.design.patterns.decoratorpattern;

public class DriverClass {

	public static void main(String[] args) {
		Car c	=	new  Maruti();
		
		System.out.println(c.getCarAccessories()+" : "+ c.getCarCost());
		
		c	=	new Stereo(c);
		
		System.out.println(c.getCarAccessories()+" : "+ c.getCarCost());
		
		c	=	new MarutiSUV(c);
		
		System.out.println(c.getCarAccessories()+" : "+ c.getCarCost());

		c	=	new Tata();
		
		System.out.println(c.getCarAccessories()+" : "+ c.getCarCost());
		
		c	=	new Stereo(c);
		
		System.out.println(c.getCarAccessories()+" : "+ c.getCarCost());
				
	}
}
