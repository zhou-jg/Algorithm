package basic.string.match;

import static org.junit.Assert.*;

import org.junit.Test;

public class SundayTest {

	@Test
	public void foundMatch() {
		assertEquals(3, Sunday.match("Hello world.", "lo"));
	}
	
	@Test
	public void noMatach(){
		assertEquals(-1, Sunday.match("Hello world.", "robin"));
	}
	
	@Test
	public void matchAll(){
		assertArrayEquals(new int[]{3,10}, Sunday.matchAll("Hello, Hello", "lo"));
	}

}
