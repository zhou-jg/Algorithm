package basic.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class NonExtremElementFinderTest {

	@Test
	public void test() {
		assertEquals(0, NonExtremElementFinder.find(new int[]{0, Integer.MAX_VALUE, Integer.MIN_VALUE}));
		assertEquals(0, NonExtremElementFinder.find(new int[]{Integer.MAX_VALUE, 0, Integer.MIN_VALUE}));
		assertEquals(0, NonExtremElementFinder.find(new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE, 0}));
	}

}
