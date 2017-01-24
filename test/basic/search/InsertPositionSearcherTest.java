package basic.search;

import static org.junit.Assert.*;

import org.junit.Test;

public class InsertPositionSearcherTest {

	InsertPositionSearcher s = new InsertPositionSearcher();
	@Test
	public void test() {
		assertEquals(2, s.searchInsert(new int[]{1,3,5,6}, 5));
		assertEquals(1, s.searchInsert(new int[]{1,3,5,6}, 2));
		assertEquals(4, s.searchInsert(new int[]{1,3,5,6}, 7));
		assertEquals(0, s.searchInsert(new int[]{1,3,5,6}, 0));
	}

}
