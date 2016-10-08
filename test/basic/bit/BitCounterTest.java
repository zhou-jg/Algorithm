package basic.bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitCounterTest {

	@Test
	public void test() {
		int num = 0B100111001;
		assertEquals(9, BitCounter.count(num));
	}

}
