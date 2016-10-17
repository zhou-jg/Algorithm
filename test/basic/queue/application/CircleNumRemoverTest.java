package basic.queue.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class CircleNumRemoverTest {

	@Test
	public void test() {
		assertEquals("win", CircleNumRemover.who(new String[]{"bad", "lose", "win"}, 2));
	}

}
