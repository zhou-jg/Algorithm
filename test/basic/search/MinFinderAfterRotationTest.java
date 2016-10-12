package basic.search;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import basic.search.MinFinderAfterRotation;

public class MinFinderAfterRotationTest {

	@Test
	public void testFindMinFromOrderedArrayAfterRotation(){
		Integer[] array = new Integer[] {3,4,5,6,7,1,2};
		assertEquals(Integer.valueOf(1), MinFinderAfterRotation.min(array));
		
		array = new Integer[] {3,4,4,5,6,7,1,1,2};
		assertEquals(Integer.valueOf(1), MinFinderAfterRotation.min(array));
		
		array = new Integer[] {3,4,5,6,1,2};
		assertEquals(Integer.valueOf(1), MinFinderAfterRotation.min(array));
	}
}
