package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class HappyNumberTest {
	
	private HappyNumber hn = new HappyNumber();

	@Test
	public void happyNumbers() {
		assertTrue(hn.isHappyNumber(19));
	}

	@Test
	public void unHappyNumbers(){
		assertFalse(hn.isHappyNumber(3));
	}
}
