package basic.number.applications;

import static org.junit.Assert.*;

import org.junit.Test;

public class UglyNumberTest {
	
	UglyNumber un = new UglyNumber();

	@Test
	public void ugly() {
		assertTrue(un.isUgly(12));		
	}

	@Test
	public void notUgly() {
		assertFalse(un.isUgly(14));		
	}
}
