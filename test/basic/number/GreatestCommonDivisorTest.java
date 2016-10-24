package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class GreatestCommonDivisorTest {

	@Test
	public void test() {
		assertEquals(12, GreatestCommonDivisor.gcd(36, 24));
		assertEquals(1, GreatestCommonDivisor.gcd(3, 8));
	}

}
