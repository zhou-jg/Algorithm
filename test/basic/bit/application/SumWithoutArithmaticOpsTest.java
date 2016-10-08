package basic.bit.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SumWithoutArithmaticOpsTest {

	@Test
	public void testSum() {
		assertEquals(2, SumWithoutArithmaticOps.sum(0, 2));
		assertEquals(2, SumWithoutArithmaticOps.sum(2, 0));
		assertEquals(2, SumWithoutArithmaticOps.sum(1, 1));
		assertEquals(2, SumWithoutArithmaticOps.sum(3, -1));
	}

}
