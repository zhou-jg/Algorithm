package basic.queue.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class NextGreaterElementFinderTest {

	NextGreaterElementFinder f = new NextGreaterElementFinder();
	@Test
	public void test() {
		assertArrayEquals(new int[]{-1,3,-1}, f.nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2}));
		assertArrayEquals(new int[]{3,-1}, f.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4}));
	}

}
