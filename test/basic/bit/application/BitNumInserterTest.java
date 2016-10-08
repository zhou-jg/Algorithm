package basic.bit.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class BitNumInserterTest {

	@Test
	public void test() {
		int source = 0B110100110101;
		int value = 0B111;
		//将value插入到source的第8到第6位
		int result = 0B110111110101;

		assertEquals(result, BitNumInserter.bitInsert(source, value, 8, 6));
	}

}
