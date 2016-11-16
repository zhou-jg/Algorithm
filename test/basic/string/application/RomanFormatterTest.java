package basic.string.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class RomanFormatterTest {

	@Test
	public void toInt() {
		assertEquals(17, RomanFormatter.toInt("XVII"));
		assertEquals(1953, RomanFormatter.toInt("MCMLIII"));
		assertEquals(3303, RomanFormatter.toInt("MMMCCCIII"));
		assertEquals(1995, RomanFormatter.toInt("MCMXCV"));
	}
	
	@Test
	public void toRoman(){
		assertEquals("XVII", RomanFormatter.toRoman(17));
		assertEquals("MCMLIII", RomanFormatter.toRoman(1953));
		assertEquals("MMMCCCIII", RomanFormatter.toRoman(3303));
		assertEquals("MCMXCV", RomanFormatter.toRoman(1995));
	}

}
