package basic.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.List;
import static util.NumberUtil.fromObjects;

public class PartitionByValueXTest {
	
	private List<Integer> head = new List<Integer>(1);
	
	@Before
	public void initData(){		
		List<Integer> node = head;
		node.setNext(new List<Integer>(6));		
		node = node.getNext();
		node.setNext(new List<Integer>(2));		
		node = node.getNext();
		node.setNext(new List<Integer>(3));		
		node = node.getNext();
		node.setNext(new List<Integer>(8));		
		node = node.getNext();
		node.setNext(new List<Integer>(5));		
		node = node.getNext();
		node.setNext(new List<Integer>(4));		
		node = node.getNext();
		node.setNext(new List<Integer>(7));		
		node = node.getNext();
		node.setNext(new List<Integer>(5));	
	}

	@Test
	public void test() {
		PartitionByValueX.divide(head, 5);
		assertArrayEquals(new int[]{1, 2,3,4,8,5,6,7,5},
				fromObjects(head.toArray(new Integer[9])));
	}

}
