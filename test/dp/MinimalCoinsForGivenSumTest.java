package dp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import util.Pair;

public class MinimalCoinsForGivenSumTest {

	@Test
	public void testFound() {
		List<Pair<Integer>> result = MinimalCoinsForGivenSum.find(new int[] {1, 3, 5}, 11);
		assertEquals(1, result.get(0).getRight().intValue());
		assertEquals(0, result.get(1).getRight().intValue());
		assertEquals(2, result.get(2).getRight().intValue());
	}
	
	@Test
	public void testNotFoundInfiniti() {
		List<Pair<Integer>> result = MinimalCoinsForGivenSum.find(new int[] {5, 7}, 23);		
		assertEquals(0, result.size());		
	}
	
	@Test
	public void testFoundFiniti() {
		List<Pair<Integer>> result = MinimalCoinsForGivenSum.find(new int[] {2, 5, 7}, new int[]{5, 5, 5}, 19);		
		assertEquals(0, result.get(0).getRight().intValue());
		assertEquals(1, result.get(1).getRight().intValue());
		assertEquals(2, result.get(2).getRight().intValue());
	}

	@Test
	public void testNotFoundFiniti() {
		List<Pair<Integer>> result = MinimalCoinsForGivenSum.find(new int[] {2, 5, 7}, new int[]{5, 2, 1}, 19);		
		assertEquals(0, result.size());		
	}
}
