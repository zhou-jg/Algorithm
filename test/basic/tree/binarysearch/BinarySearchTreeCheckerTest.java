package basic.tree.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.tree.binarysearch.BinarySearchTreeChecker;
import datastructure.BiTree;

public class BinarySearchTreeCheckerTest {

	@Test
	public void isSearchTree() {
		assertTrue(BinarySearchTreeChecker.check(
				new BiTree<Integer>(6, 
						new BiTree<Integer>(4, null,
								new BiTree<Integer>(5)),
						new BiTree<Integer>(9, 
								new BiTree<Integer>(8, 
										new BiTree<Integer>(7), null), null))));
	}
	
	@Test
	public void notSearchTree(){
		assertFalse(BinarySearchTreeChecker.check(
				new BiTree<Integer>(6, 
						new BiTree<Integer>(7, null,
								new BiTree<Integer>(9)), null)));
	}

}
