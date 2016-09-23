package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

import util.Pair;

public class ArrayAlgorithmTest {

	@Test
	public void testGetMaxSumForSubList() {
		int[] a	= new int[] {-1, 2, -8, 3, -2, 4, -10};
		assertEquals(5, ArrayAlgorithm.getMaxSumForSubList(a));
		
		a 		= new int[] {-1, 2, -8, 3, -2, 4, -10, 6};
		assertEquals(6, ArrayAlgorithm.getMaxSumForSubList(a));
	}
	
	@Test
	public void testFindRangeIndiceToBeOrder(){
		Pair<Integer> p = ArrayAlgorithm.findRangeIndiceToBeOrdered(new int[]{
					1, 2, 4, 7, 10, 11, 
					7, 12, 
					6, 7, 16, 
					3, 8, 12, 17, 18, 19
		});
		assertEquals(2, p.getLeft().intValue());
		assertEquals(13, p.getRight().intValue());		
	}

	@Test
	public void testFindMinFromOrderedArrayAfterRotation(){
		int[] array = new int[] {3,4,5,6,7,1,2};
		assertEquals(1, ArrayAlgorithm.minByDivide(array));
		
		array = new int[] {3,4,4,5,6,7,1,1,2};
		assertEquals(1, ArrayAlgorithm.minByDivide(array));
		
		array = new int[] {3,4,5,6,1,2};
		assertEquals(1, ArrayAlgorithm.minByDivide(array));
	}
}
