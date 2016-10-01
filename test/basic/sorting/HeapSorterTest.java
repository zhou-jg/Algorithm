package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class HeapSorterTest {

	@Test
	public void test() {
		int[] result = new int[]{5,9,7,3,10};
		HeapSorter.sort(result);
		assertArrayEquals(new int[]{3, 5,7,9,10}, result);
	}

}
