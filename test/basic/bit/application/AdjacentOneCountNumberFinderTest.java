package basic.bit.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AdjacentOneCountNumberFinderTest {

	int num = 0B11010010110;
	AdjacentOneCountNumberFinder finder = new AdjacentOneCountNumberFinder(num);
	
	@Test
	public void testBigger() {	
		System.out.println(num);
		assertEquals(0B11010011001, finder.findBigger());
	}
	
	@Test
	public void testSmaller(){
		assertEquals(0B11010010101, finder.findSmaller());
	}

}
