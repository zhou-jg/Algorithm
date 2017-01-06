package basic.number.applications;

import static org.junit.Assert.*;

import org.junit.Test;

public class PrimeCounterTest {

	PrimeCounter pc = new PrimeCounter();
	
	@Test
	public void test() {
		assertEquals(0, pc.countPrimes(-1));
		assertEquals(0, pc.countPrimes(0));
		assertEquals(0, pc.countPrimes(2));
		assertEquals(4, pc.countPrimes(10));
		assertEquals(25, pc.countPrimes(100));
	}

}
