package basic.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.BiTreeNodeEx;

public class NextFinderInBinarySearchTreeTest {

	@Test
	public void nextIsFather() {
		BiTreeNodeEx<Integer> node = new BiTreeNodeEx<Integer>(5, new BiTreeNodeEx<Integer>(4, null, null, null), null, null);
		BiTreeNodeEx<Integer> root = new BiTreeNodeEx<Integer>(2, node, null, null);
		assertEquals(root, NextFinderInBinarySearchTree.findNext(node));
	}

	@Test
	public void nextIsNull(){
		BiTreeNodeEx<Integer> node = new BiTreeNodeEx<Integer>(5, new BiTreeNodeEx<Integer>(4, null, null, null), null, null);
		BiTreeNodeEx<Integer> root = new BiTreeNodeEx<Integer>(2, null, node, null);
		assertEquals(null, NextFinderInBinarySearchTree.findNext(node));
	}
	
	@Test
	public void nextIsFatherFather(){
		BiTreeNodeEx<Integer> node = new BiTreeNodeEx<Integer>(5, new BiTreeNodeEx<Integer>(4, null, null, null), null, null);
		BiTreeNodeEx<Integer> root = new BiTreeNodeEx<Integer>(2, new BiTreeNodeEx<Integer>(3, null, node, null), null, null);
		assertEquals(root, NextFinderInBinarySearchTree.findNext(node));
	}
	
	@Test
	public void nextIsLeftLeafInRightPart(){
		BiTreeNodeEx<Integer> node = new BiTreeNodeEx<Integer>(5, new BiTreeNodeEx<Integer>(4, null, null, null), null, null);
		BiTreeNodeEx<Integer> target = new BiTreeNodeEx<Integer>(1, null, null, null);
		BiTreeNodeEx<Integer> root = new BiTreeNodeEx<Integer>(2, new BiTreeNodeEx<Integer>(3, null, node, null), 
																new BiTreeNodeEx<Integer>(6, target, null, null), null);
		assertEquals(target, NextFinderInBinarySearchTree.findNext(root));
	}
}
