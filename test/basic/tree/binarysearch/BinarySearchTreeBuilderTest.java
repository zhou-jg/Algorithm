package basic.tree.binarysearch;

import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.tree.MiddleOrderTraverser;
import basic.tree.binarysearch.BinarySearchTreeBuilder;

public class BinarySearchTreeBuilderTest {

	@Test
	public void test() {
		assertEquals(Arrays.asList(1,2,3,4,5,6,7,8), 
				MiddleOrderTraverser.traverse(BinarySearchTreeBuilder.build(new Integer[]{1,2,3,4,5,6,7,8})));
	}

}
