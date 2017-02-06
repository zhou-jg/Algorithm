package basic.tree;

import static org.junit.Assert.*;
import static util.NumberUtil.fromObjects;

import java.util.List;

import org.junit.Test;

import datastructure.BiTree;

public class PostOrderTraverserTest {
	
	BiTree<Integer> root = new BiTree<Integer>(8, 
								new BiTree<Integer>(4,
									new BiTree<Integer>(2, null, null), 
									new BiTree<Integer>(3, null, null)), 
								new BiTree<Integer>(7, 
									new BiTree<Integer>(5, null, null), 
									new BiTree<Integer>(6, null, null)));
	int[] expected = new int[] { 2, 3, 4, 5, 6, 7, 8 };

	BiTree<Integer> root2 = new BiTree<Integer>(7, 
								new BiTree<Integer>(4, null, // new BiTree<Integer>(2, null, null),
										new BiTree<Integer>(3, null, null)), 
								new BiTree<Integer>(6,
										new BiTree<Integer>(5, null, null), null /* new BiTree<Integer>(8, null, null)*/));
	int[] expected2 = new int[] { 3, 4, 5, 6, 7 };

	@Test
	public void traverseWithoutRecursion() {
		List<Integer> result = PostOrderTraverser.traverseWithoutRecursion(root);
		assertArrayEquals(expected,
				fromObjects(result.toArray(new Integer[result.size()])));

		result = PostOrderTraverser.traverseWithoutRecursion(root2);
		assertArrayEquals(expected2,
				fromObjects(result.toArray(new Integer[result.size()])));
	}

	@Test
	public void traverseWithoutRecursionII() {
		List<Integer> result = PostOrderTraverser.traverseWithoutRecursionII(root);
		assertArrayEquals(expected,
				fromObjects(result.toArray(new Integer[result.size()])));

		result = PostOrderTraverser.traverseWithoutRecursionII(root2);
		assertArrayEquals(expected2,
				fromObjects(result.toArray(new Integer[result.size()])));
	}
	
	@Test
	public void recursiveTraverse() {
		List<Integer> result = PostOrderTraverser.traverse(root);
		assertArrayEquals(expected,
				fromObjects(result.toArray(new Integer[result.size()])));
	}

	
}
