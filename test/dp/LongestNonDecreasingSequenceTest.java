package dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestNonDecreasingSequenceTest {

	@Test
	public void testLength() {
		assertEquals(3, LongestNonDecreasingSequence.length(new int[]{5,6,1,2,7}));;
	}

	@Test
	public void testOneSequence(){
		assertArrayEquals(new int[]{2,3,4}, 
							LongestNonDecreasingSequence.sequences(
									new int[]{5,6,1,2,7}, 
									new int[]{1,2,1,2,3},
									3));
	}
}
