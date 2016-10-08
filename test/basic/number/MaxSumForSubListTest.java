package basic.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaxSumForSubListTest {

	@Test
	public void testGetMaxSumForSubList() {
		int[] a	= new int[] {-1, 2, -8, 3, -2, 4, -10};
		assertEquals(5, MaxSumForSubList.compute(a));
		
		a 		= new int[] {-1, 2, -8, 3, -2, 4, -10, 6};
		assertEquals(6, MaxSumForSubList.compute(a));
	}
	
}
