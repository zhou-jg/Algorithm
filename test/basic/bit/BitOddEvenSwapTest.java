package basic.bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitOddEvenSwapTest {

	@Test
	public void test() {
		assertEquals(0B110101011, BitOddEvenSwap.swap(0B1001010111));		
	}

}
