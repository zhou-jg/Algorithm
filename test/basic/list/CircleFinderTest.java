package basic.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.List;

public class CircleFinderTest {
	private List<Integer> head = new List<Integer>(1);
	
	@Before
	public void initData(){
		head.setNext(new List<Integer>(2));
		head.getNext().setNext(new List<Integer>(3));
	}

	@Test
	public void hasCircle() {
		List<Integer> node = new List<Integer>(4);
		node.setNext(new List<Integer>(5));
		node.getNext().setNext(head.getNext().getNext());
		head.getNext().getNext().setNext(node);
		
		assertEquals(head.getNext().getNext(), CircleFinder.findNode(head));
	}
	
	@Test
	public void noCircle(){		
		assertEquals(null, CircleFinder.findNode(head));
	}

}
