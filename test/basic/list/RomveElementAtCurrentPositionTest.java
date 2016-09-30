package basic.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.List;

public class RomveElementAtCurrentPositionTest {
	
	private List<Integer> orignal = new List<Integer>(1);
	private List<Integer> expected = new List<Integer>(1);
	
	@Before
	public void initData(){		
		List<Integer> node1 = orignal, node2 = expected;
		for (int i = 2; i<8; i++){
			node1.setNext(new List<Integer>(i));
			node1 = node1.getNext();
			if (i == 3) continue;
			node2.setNext(new List<Integer>(i));
			node2 = node2.getNext();
		}
	}

	@Test
	public void test() {
		List<Integer> node = orignal;		
		RemoveElementAtCurrentPosition.deleteNode(node.getNext().getNext());
		assertEquals(expected, orignal);
	}

}
