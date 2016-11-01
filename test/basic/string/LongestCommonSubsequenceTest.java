package basic.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class LongestCommonSubsequenceTest {

	@Test
	public void test() {
		assertEquals("ACDA", LongestCommonSubsequence.find("ACBDEA", "ABCDA"));
	}

}
