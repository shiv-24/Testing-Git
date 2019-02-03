package com.practice.java8;

public class LamdaExpressions {

	
	public static void main(String[] args) {
		LamdaExpressions obj	=	new LamdaExpressions();
		MathOperation addtion	=	(int a, int b)->a+b;
		MathOperation sub		=	(a,b)->a-b;
		MathOperation mul		=	(a,b)->{return a*b;};
		MathOperation div		=	(int a,int b)-> a/b;
		System.out.println("Addition Of"+addtion.Operation(2, 3));
		System.out.println("Sub Of"+obj.operate(5, 10, sub));
		System.out.println("Multiplication Of"+obj.operate(5, 10, mul));
		System.out.println("Dvision Of"+obj.operate(10, 5, div));
		
		GreetingsToPeople greet	=	(message)->{System.out.println("Hello You There??!!"+message);};
		greet.printGreeting("Vinaya");
		MathOperation.fd(3, 4, 5);
		
	}
	@FunctionalInterface
	private interface MathOperation{
		int Operation(int a, int b);
		static int fd(int a,int b, int c) {
			return a+b+c;
		}
	}
	
	private interface GreetingsToPeople {
		void printGreeting(String greeting);
	}
	private int operate(int a,int b, MathOperation operation) {
		return operation.Operation(a, b);
	}
	

}

