package basic.concurrent.application;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

public class MergeSortWithForkJoinTest {

	@Test
	public void sort() {
		int[] result = new int[]{1};
		MergeSortWithForkJoin.sort(result);
		assertArrayEquals(new int[]{1}, result);
		
		result = new int[]{2,1};
		MergeSortWithForkJoin.sort(result);
		assertArrayEquals(new int[]{1, 2}, result);
		
		result = new int[]{2,1,3};
		MergeSortWithForkJoin.sort(result);
		assertArrayEquals(new int[]{1, 2,3}, result);
		
		result = new int[]{2,1,3,4};
		MergeSortWithForkJoin.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4}, result);
		
		result = new int[]{2,1,3,5,4};
		MergeSortWithForkJoin.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4,5}, result);
	}

}
