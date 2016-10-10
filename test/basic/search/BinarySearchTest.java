package basic.search;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class BinarySearchTest {

	List<Integer> list = new ArrayList<>();{
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
	}
	
	@Test
	public void atBeginning() {
		assertEquals(0, BinarySearch.find(list, 1));
		assertEquals(0, BinarySearch.find(list, 1, (c1, c2)-> c1-c2));
	}

	@Test
	public void atMiddle() {
		assertEquals(1, BinarySearch.find(list, 3));
		assertEquals(1, BinarySearch.find(list, 3, (c1, c2)-> c1-c2));
	}
	
	@Test
	public void atEnd() {
		assertEquals(4, BinarySearch.find(list, 6));
		assertEquals(4, BinarySearch.find(list, 6, (c1, c2)-> c1-c2));
	}
}
