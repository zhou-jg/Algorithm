package basic.bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitClearnerTest {

	@Test
	public void clearTop() {		
		assertEquals(0B1010, BitClearner.clearTop(0B11011010, 5));
	}

	@Test
	public void clearLow() {		
		assertEquals(0B10100000, BitClearner.clearLow(0B10101010, 4));
	}
}
