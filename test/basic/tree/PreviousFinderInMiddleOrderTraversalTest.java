package basic.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.BiTreeNodeEx;

public class PreviousFinderInMiddleOrderTraversalTest {

	BiTreeNodeEx<Integer> node2 = new BiTreeNodeEx<Integer>(2, 
										new BiTreeNodeEx<>(4, null, null, null),  
										new BiTreeNodeEx<>(1, null, null, null), null);
	BiTreeNodeEx<Integer> node1 = new BiTreeNodeEx<Integer>(3, node2, null, null);
	
	@Test
	public void findInLeft() {
		assertEquals(node2.getRight(), PreviousFinderInMiddleOrderTraversal.find(node1));		
	}
	
	@Test
	public void findParent(){
		assertEquals(node2, PreviousFinderInMiddleOrderTraversal.find(node2.getRight()));
	}
	
	@Test
	public void findNothing(){
		assertEquals(null, PreviousFinderInMiddleOrderTraversal.find(node2.getLeft()));
	}

}
