package codingPractice.TwoZeroFourEightGame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.lab.questions.Rational;

public class TestOthers {

	Rational rationalObject, rationalObjectTwo, rationalObjectThree;
	long num, denorm, num2, denorm2;

	@Before
	public void beforeEachTestCase() {
		num = new Long(2);
		denorm = new Long(4);
		num2 = new Long(3);
		denorm2 = new Long(6);

		rationalObject = new Rational(num, denorm);
		rationalObjectTwo = new Rational(num2, denorm2);
	}

	@Test
	public void testBasicCurdOps() {
		rationalObjectThree = rationalObject.add(rationalObjectTwo);

		assertEquals(1, rationalObjectThree.num());
		assertEquals(1, rationalObjectThree.denorm());

		rationalObjectThree = rationalObject.sub(rationalObjectTwo);

		assertEquals(0, rationalObjectThree.num());
		assertEquals(1, rationalObjectThree.denorm());

		rationalObjectThree = rationalObject.mul(rationalObjectTwo);

		assertEquals(1, rationalObjectThree.num());
		assertEquals(4, rationalObjectThree.denorm());

		rationalObjectThree = rationalObject.div(rationalObjectTwo);

		assertEquals(1, rationalObjectThree.num());
		assertEquals(1, rationalObjectThree.denorm());
	}

	@Test
	public void testEquals() {

//		assertEquals(true, rationalObjectTwo.equal(rationalObject));
		assertTrue(rationalObjectTwo.equal(rationalObject));
	}

}
