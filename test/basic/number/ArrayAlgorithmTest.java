package basic.number;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Pair;

public class ArrayAlgorithmTest {

	
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

}
