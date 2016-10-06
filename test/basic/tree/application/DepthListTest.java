package basic.tree.application;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import datastructure.BiTree;

public class DepthListTest {

	@Test
	public void test() {
		BiTree<Integer> root = new BiTree<>(1);
		BiTree<Integer> node21 = new BiTree<>(2);
		BiTree<Integer> node22 = new BiTree<>(3);
		BiTree<Integer> node32 = new BiTree<>(4);
		root.setLeft(node21);
		root.setRight(node22);
		node22.setRight(node32);
		
		List<BiTree<?>> list1 = new ArrayList<>();
		list1.add(root);
		List<BiTree<?>> list2 = new ArrayList<>();
		list2.add(node21);
		list2.add(node22);
		List<BiTree<?>> list3 = new ArrayList<>();
		list3.add(node32);
		
		Map<Integer, List<BiTree<?>>> result = DepthList.build(root);
		assertEquals(list1, result.get(1));
		assertEquals(new HashSet<BiTree<?>>(list2), new HashSet<BiTree<?>>(result.get(2)));
		assertEquals(list3, result.get(3));
	}

}
