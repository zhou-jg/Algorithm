package basic.sorting;

import static org.junit.Assert.*;

import org.junit.Test;

public class BubbleSorterTest {

	@Test
	public void testSort() {
		assertArrayEquals(new int[]{1, 2, 3, 4, 5},
				BubbleSorter.sort(new int[]{3, 4, 2, 5, 1}));
	}

}
