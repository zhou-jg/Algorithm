package basic.tree;

import static org.junit.Assert.*;

import org.junit.Test;

import datastructure.BiTree;

public class LeastCommonAncestorFinderTest {

	BiTree<Integer> root = new BiTree<Integer>(5);
	BiTree<Integer> u = new BiTree<Integer>(1);
	BiTree<Integer> v = new BiTree<Integer>(10);
	
	@Test
	public void foundRoot() {		
		root.setLeft(new BiTree<Integer>(3, u, null))
			.setRight(new BiTree<Integer>(7, 
							new BiTree<Integer>(6, null, null), 
							new BiTree<Integer>(8, null, v)));
		assertEquals(root, LeastCommonAncestorFinder.find(root, u, v));
	}
	
	@Test
	public void foundAncestor(){
		root.setLeft(new BiTree<Integer>(3, u, null))
			.setRight(u.setLeft(new BiTree<Integer>(6, null, null))
					   .setRight(new BiTree<Integer>(8, null, v)));
		assertEquals(u, LeastCommonAncestorFinder.find(root, u, v));
	}
	
	@Test
	public void notFound(){
		root.setLeft(new BiTree<Integer>(3, null, null))
			.setRight(new BiTree<Integer>(7, 
							new BiTree<Integer>(6, null, null), 
							new BiTree<Integer>(8, null, v)));
		assertEquals(null, LeastCommonAncestorFinder.find(root, u, v));
	}

}
