package basic.tree.application;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import datastructure.BiTree;

public class PathFinderForGivenSumTest {

	@Test
	public void test() {
		BiTree<Integer> root = new BiTree<Integer>(5,
				new BiTree<>(4, 
					new BiTree<>(-3, 
						new BiTree<>(8, 
							new BiTree<>(-2, null, null),
							new BiTree<>(-4, null, null)),
						new BiTree<>(6,
							new BiTree<>(-2, null, null),
							new BiTree<>(2, null, null))),
					new BiTree<>(1, 
							new BiTree<>(3, 
								new BiTree<>(1, null, null),
								new BiTree<>(-4, null, null)),
							new BiTree<>(8,
								new BiTree<>(0, null, null),
								new BiTree<>(-4, null, null)))),
				new BiTree<>(-5, null, null));
		List<List<BiTree<Integer>>> result = PathFinderForGivenSum.find(root, 9);
		for(List<BiTree<Integer>> l : result){
			System.out.println(l);
		}
		
		assertEquals(8, result.size());
	}

}
