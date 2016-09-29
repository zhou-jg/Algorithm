package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class ShellSorterTest {

	@Test
	public void sort() {
		int[] result = new int[]{2,1,3,5,4,9,7,10,22,8, 33,24,34,28,19,20,6};
		ShellSorter.sort(result);
		assertArrayEquals(new int[]{1, 2,3,4,5,6,7,8,9,10,19,20,22,24,28,33,34}, result);
	}

}
