package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class HIndexTest {

	HIndex index = new HIndex();
	@Test
	public void test() {
		assertEquals(3, index.hIndex(new int[]{3, 0, 6, 1, 5}));
		assertEquals(0, index.hIndex(new int[]{0}));
	}

}
