package com.java.exceptionhandling;

public class StackUnwingExample {

	public static void main(String[] args) throws Exception {
		A a = null;
		try {
			A.x = 'A';
			a = new A();
		} catch (Exception e) {
			// System.out.println(a.getClass());
			if (A.c != null) {
				System.out.println(A.c);
				A.c = null;
			}
			e.printStackTrace();
			// System.out.println(A.c);
		}
	}
}

class A extends B {

	static char x;
	static C c = null;
	static D d = null;

	public void ini() throws Exception {
		c = new C(x);
		d = new D(x);
	}

	public A() throws Exception {
		super(x);
		ini();
		System.out.println("in constructer A(), throwing: " + x);
		if (x == 'A') {
			throw new Exception("Why A!?");
		}
	}
}

class B {

	public B(char x) throws Exception {
		System.out.println("in constructer B(), throwing: " + x);
		if (x == 'B') {
			throw new Exception("Why B!?");
		}
	}

}

class C {

	public C(char x) throws Exception {
		System.out.println("in constructer C(), throwing: " + x);
		if (x == 'C') {
			throw new Exception("Why C!?");
		}
	}

}

class D {

	public D(char x) throws Exception {
		System.out.println("in constructer D(), throwing: " + x);
		if (x == 'D') {
			throw new Exception("Why D!?");
		}
	}

}