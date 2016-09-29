package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertionSorterTest {

	@Test
	public void test() {
		int[] result = new int[]{1};
		InsertionSorter.sort(result);
		assertArrayEquals(new int[]{1}, result);
		
		result = new int[]{2,1};
		InsertionSorter.sort(result);
		assertArrayEquals(new int[]{1, 2}, result);
		
		result = new int[]{2,1,3};
		InsertionSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3}, result);
		
		result = new int[]{2,1,4,3};
		InsertionSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4}, result);
	}

}
