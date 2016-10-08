package basic.bit.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitSwapCounterTest {

	@Test
	public void test() {
		assertEquals(5, BitSwapCounter.count(0B110010, 0B101));;
	}

}
