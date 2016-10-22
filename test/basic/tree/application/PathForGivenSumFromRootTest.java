package basic.tree.application;

import java.util.List;

import org.junit.Test;

import datastructure.BiTree;

public class PathForGivenSumFromRootTest {

	@Test
	public void test() {
		List<List<BiTree<Integer>>> paths = PathForGivenSumFromRoot.findPath(
				new BiTree<Integer>(10, 
						new BiTree<Integer>(5, 
								new BiTree<Integer>(4), 
								new BiTree<Integer>(7)), 
						new BiTree<Integer>(12)), 22);
		for(List<BiTree<Integer>> path : paths){
			System.out.println(path);
		}
	}

}
