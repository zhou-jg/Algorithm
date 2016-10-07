package basic.bit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BitGetterTest {

	private int n1 = 0b11001101;
	
	@Test
	public void testLeftShift() {
		assertFalse(BitGetter.isZeroByRightShift(n1, 1));
		assertTrue(BitGetter.isZeroByLeftShift(n1, 2));
		assertTrue(BitGetter.isZeroByLeftShift(n1, 5));
		assertFalse(BitGetter.isZeroByLeftShift(n1, 7));
		
	}
	
	@Test
	public void testRightShift(){
		assertFalse(BitGetter.isZeroByRightShift(n1, 1));
		assertTrue(BitGetter.isZeroByRightShift(n1, 2));
		assertTrue(BitGetter.isZeroByRightShift(n1, 5));
		assertFalse(BitGetter.isZeroByRightShift(n1, 7));		
	}

}
