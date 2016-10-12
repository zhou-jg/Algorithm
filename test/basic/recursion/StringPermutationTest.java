package basic.recursion;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import basic.recursion.StringPermutation;

public class StringPermutationTest {

	private List<String> expected = Arrays.asList("cba", "cab", "bca", "bac", "acb", "abc");
	@Test
	public void testComputeWithRecursion() {
		Assert.assertEquals(expected, Arrays.asList(StringPermutation.computePermutations("abc")));
	}

}
