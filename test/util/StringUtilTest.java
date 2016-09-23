package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilTest {

	@Test
	public void testInsertAtBeginning() {
		assertEquals("dabc", StringUtil.insertAt("abc", 0, 'd'));
	}
	
	@Test
	public void testInsertAtMiddle(){
		assertEquals("adbc", StringUtil.insertAt("abc", 1, 'd'));
	}
	
	@Test
	public void testInsertAtEnd(){
		assertEquals("abcd", StringUtil.insertAt("abc", 3, 'd'));
	}

}
