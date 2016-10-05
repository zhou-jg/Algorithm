package basic.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.BiTree;

public class BalancedBinaryTreeCheckerTest {

	@Test
	public void balanced() {
		assertTrue(BalancedBinaryTreeChecker.check(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), null)));

		assertTrue(BalancedBinaryTreeChecker.check(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), 
														new BiTree<Integer>(3, null, 
																	new BiTree<>(4, null, null)))));														
	}
	
	@Test
	public void notBalanced(){
		assertFalse(BalancedBinaryTreeChecker.check(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), 
														new BiTree<Integer>(3, null, 
																	new BiTree<>(4, 
																			new BiTree<>(5, null, null), null)))));	
	}

	@Test
	public void balancedWithRecursion() {
		assertTrue(BalancedBinaryTreeChecker.checkWithRecursion(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), null)));

		assertTrue(BalancedBinaryTreeChecker.checkWithRecursion(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), 
														new BiTree<Integer>(3, null, 
																	new BiTree<>(4, null, null)))));														
	}
	
	@Test
	public void notBalancedWithRecursion(){
		assertFalse(BalancedBinaryTreeChecker.checkWithRecursion(new BiTree<Integer>(1, 
														new BiTree<Integer>(2, null, null), 
														new BiTree<Integer>(3, null, 
																	new BiTree<>(4, 
																			new BiTree<>(5, null, null), null)))));	
	}
}
