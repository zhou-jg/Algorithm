package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class MergeSorterTest {

	@Test
	public void sort() {
		int[] result = new int[]{1};
		MergeSorter.sort(result);
		assertArrayEquals(new int[]{1}, result);
		
		result = new int[]{2,1};
		MergeSorter.sort(result);
		assertArrayEquals(new int[]{1, 2}, result);
		
		result = new int[]{2,1,3};
		MergeSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3}, result);
		
		result = new int[]{2,1,3,4};
		MergeSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4}, result);
		
		result = new int[]{2,1,3,5,4};
		MergeSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4,5}, result);
	}

}
