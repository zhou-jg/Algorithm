package basic.bit.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaxFinderWithoutComparationTest {

	@Test
	public void test() {
		assertEquals(5, MaxFinderWithoutComparation.max(3, 5));
		assertEquals(5, MaxFinderWithoutComparation.max(5, 5));
		assertEquals(5, MaxFinderWithoutComparation.max(5, 1));
	}

}
