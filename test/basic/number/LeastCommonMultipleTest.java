package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class LeastCommonMultipleTest {

	@Test
	public void test() {
		assertEquals(72, LeastCommonMultiple.lcm(8, 9));
		assertEquals(24, LeastCommonMultiple.lcm(8, 6));
	}

}
