package basic.recursion;

import static org.junit.Assert.*;

import org.junit.Test;

import util.NumberUtil;

public class ArrayReverserTest {

	@Test
	public void testOddNumberOfData() {
		assertArrayEquals(new int[]{1, 2,3,4,5}, NumberUtil.fromObjects(ArrayReverser.reverse(new Integer[]{5,4,3,2,1})));
	}

	@Test
	public void testEvenNumberOfData() {
		assertArrayEquals(new int[]{1, 2,3,4}, NumberUtil.fromObjects(ArrayReverser.reverse(new Integer[]{4,3,2,1})));
	}
}
