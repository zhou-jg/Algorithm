package basic.tree.application;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import datastructure.GNode;

public class PathFinderTest {
	@Before
	public void intData(){
		
	}
	
	@Test
	public void found() {
		GNode<Integer> head = new GNode<Integer>(1);
		GNode<Integer> source = new GNode<>(2);
		GNode<Integer> intermid = new GNode<>(5);
		GNode<Integer> target = new GNode<>(4);
		
		head.addAdjacent(
				source.
					addAdjacent(new GNode<>(3)).
					addAdjacent(intermid.
							addAdjacent(target))).addAdjacent(
				new GNode<>(6));
	
		assertTrue(PathFinder.find(source, target));
		
		List<GNode<?>> result = new ArrayList<GNode<?>>();
		result.add(source);
		result.add(intermid);
		result.add(target);
		assertEquals(result, PathFinder.findPath(source, target));
	}

	@Test
	public void notFound() {
		GNode<Integer> head = new GNode<Integer>(1);
		GNode<Integer> source = new GNode<>(2);
		GNode<Integer> target = new GNode<>(4);
		
		head.addAdjacent(
				source.
					addAdjacent(new GNode<>(3)).
					addAdjacent(new GNode<>(5).
							addAdjacent(new GNode<>(6)))).addAdjacent(
				target);
	
		assertFalse(PathFinder.find(source, target));
	}
		
}
