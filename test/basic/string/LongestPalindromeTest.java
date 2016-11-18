package basic.string;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import util.Pair;

public class LongestPalindromeTest {

	@Test
	public void testManachersAlgorithm () {
		assertEquals(new Pair<Integer>(7, 14), LongestPalindrome.manachersAlgorithm("fdafdasabcdcbafda"));
	}

	@Test
	public void testNormal(){
		assertEquals(new Pair<Integer>(7, 14), LongestPalindrome.find("fdafdasabcdcbafda"));
	}
}
