package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class QuickSorterTest {

	@Test
	public void test() {
		int[] result = new int[]{1};
		QuickSorter.sort(result);
		assertArrayEquals(new int[]{1}, result);
		
		result = new int[]{2,1};
		QuickSorter.sort(result);
		assertArrayEquals(new int[]{1, 2}, result);
		
		result = new int[]{2,1,3};
		QuickSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3}, result);
		
		result = new int[]{2,1,3,4};
		QuickSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4}, result);
		
		result = new int[]{2,1,3,5,4};
		QuickSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4,5}, result);
	}

}
