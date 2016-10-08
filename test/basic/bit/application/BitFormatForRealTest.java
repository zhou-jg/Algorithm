package basic.bit.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitFormatForRealTest {

	@Test
	public void test() {
		double d1 = 0.45;
		assertEquals("ERROR", BitFormatForReal.get(d1));
		
		double d2 = 0.25;
		assertEquals(".01", BitFormatForReal.get(d2));
	}

}
