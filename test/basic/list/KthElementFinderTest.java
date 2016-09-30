package basic.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.List;

public class KthElementFinderTest {

	private List<Integer> head = new List<Integer>(1);
	
	@Before
	public void initData(){		
		List<Integer> node = head;
		for (int i = 2; i<8; i++){
			node.setNext(new List<Integer>(i));
			node = node.getNext();
		}
	}
	
	@Test
	public void findWithStack() {
		assertEquals(5, KthElementFinder.findWithStack(head, 3).intValue());
	}

	@Test
	public void findWithDoublePointers() {
		assertEquals(5, KthElementFinder.findWithDoublePointers(head, 3).intValue());
	}
}
