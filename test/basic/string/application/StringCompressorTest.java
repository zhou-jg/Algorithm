package basic.string.application;

import static org.junit.Assert.*;

import org.junit.Test;

import basic.string.application.StringCompressor;

public class StringCompressorTest {

	@Test
	public void testCompress() {
		assertEquals("aa", StringCompressor.compress("aa"));
		assertEquals("aabc5a3", StringCompressor.compress("aabcccccaaa"));
	}

}
