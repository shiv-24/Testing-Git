package codingPractice.TwoZeroFourEightGame;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.AfterClass;

import com.lab.questions.Rational;

public class TestingReduceAndNormalize {

	long a, b;
	Rational rationalObject;
	
	@BeforeClass public static void beforeClass() {
		
		System.out.println("See you After the class");
	}
	
	@AfterClass public static void afterClass() {
		System.out.println("Hi!");
	}
	@Before public void beforeEachTestCase() {
		a	=	new Long(24);
		b	=	new Long(24);
		rationalObject	=	new Rational(a, b);
	}
	
	@Test
	public void testReduce() {
		rationalObject.reduce();
		assertEquals(1, rationalObject.num());
		assertEquals(1, rationalObject.denorm());
	}
	
	@Test
	public void testNormalize() {
		rationalObject.normalize();
		assertEquals(24, rationalObject.num());
		assertEquals(24, rationalObject.denorm());
	}

}
