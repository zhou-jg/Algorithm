package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class SelectionSorterTest {

	@Test
	public void sort() {
		int[] result = new int[]{2,1,3,5,4};
		SelectionSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4,5}, result);
	}

}
