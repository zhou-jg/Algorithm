package basic.queue.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class BracketsMatcherTest {

	@Test
	public void test() {
		assertTrue(BracketsMatcher.isMatch(new char[]{}));
		assertTrue(BracketsMatcher.isMatch(new char[]{'(', '(', 'd', ')', ')'}));
		assertFalse(BracketsMatcher.isMatch(new char[]{'(', ')', ')'}));
	}

}
