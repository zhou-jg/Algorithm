package basic.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MinFinderAfterRotationTest {

	@Test
	public void testFindMinFromOrderedArrayAfterRotation(){
		int[] array = new int[] {3,4,5,6,7,1,2};
		assertEquals(1, MinFinderAfterRotation.min(array));
		
		array = new int[] {3,4,4,5,6,7,1,1,2};
		assertEquals(1, MinFinderAfterRotation.min(array));
		
		array = new int[] {3,4,5,6,1,2};
		assertEquals(1, MinFinderAfterRotation.min(array));
	}
}
