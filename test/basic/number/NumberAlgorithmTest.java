package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumberAlgorithmTest {

	@Test
	public void testSum() {
		assertEquals(2, NumberAlgorithm.sum(0, 2));
		assertEquals(2, NumberAlgorithm.sum(2, 0));
		assertEquals(2, NumberAlgorithm.sum(1, 1));
		assertEquals(2, NumberAlgorithm.sum(3, -1));
	}

}
