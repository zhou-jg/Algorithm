package basic.tree.binarysearch;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

import basic.tree.MiddleOrderTraverser;
import basic.tree.binarysearch.BinarySearcheTreeInserter;
import datastructure.BiTreeNodeEx;

public class BinarySearcheTreeInserterTest {

	@Test
	public void rootIsNull() {
		assertEquals(Arrays.asList(1), MiddleOrderTraverser.traverse(
											BinarySearcheTreeInserter.insert(null, Integer.valueOf(1))));
		assertEquals(Arrays.asList(1), MiddleOrderTraverser.traverse(
											BinarySearcheTreeInserter.insertIteratively(null, Integer.valueOf(1))));
	}
	
	@Test
	public void insertNormal(){
		BiTreeNodeEx<Integer> root = new BiTreeNodeEx<Integer>(5, 
												new BiTreeNodeEx<Integer>(5, 
														new BiTreeNodeEx<>(3, 
																new BiTreeNodeEx<>(2, null, null, null), 
																new BiTreeNodeEx<>(4, null, null, null), null), null, null), 
												new BiTreeNodeEx<>(8, 
														new BiTreeNodeEx<>(6, null, null, null), 
														new BiTreeNodeEx<>(10, null, null, null), null), null);
		
		assertEquals(Arrays.asList(1,2,3,4,5,5,6,8,10), MiddleOrderTraverser.traverse(
															BinarySearcheTreeInserter.insert(root, 1)));
		assertEquals(Arrays.asList(1,2,3,4,5,5,6,8,9,10), MiddleOrderTraverser.traverse(
															BinarySearcheTreeInserter.insert(root, 9)));
		assertEquals(Arrays.asList(1,1,2,3,4,5,5,6,8,9,10), MiddleOrderTraverser.traverse(
																BinarySearcheTreeInserter.insertIteratively(root, 1)));
		assertEquals(Arrays.asList(1,1,2,3,4,5,5,6,8,9,9,10), MiddleOrderTraverser.traverse(
																BinarySearcheTreeInserter.insertIteratively(root, 9)));
	}

}
