package basic.bit;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitSetterTest {

	@Test
	public void setOne() {
		int num = 0B110010;
		assertEquals(0B110110, BitSetter.setOne(num, 3));
	}
	
	@Test
	public void setZeroByExlusiveOr(){
		int num = 0B110010;
		assertEquals(0B100010, BitSetter.setZeroByExclusiveOr(num, 5));
	}

	@Test
	public void setZeroByAnd(){
		int num = 0B110010;
		assertEquals(0B100010, BitSetter.setZeroByAnd(num, 5));
	}
}
