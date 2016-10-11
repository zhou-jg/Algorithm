package basic.number.applications;

import static org.junit.Assert.*;

import org.junit.Test;

public class BaseTransformerTest {

	@Test
	public void test() {
		assertEquals("122", BaseTransformer.transform(17, 3));
		assertEquals("24", BaseTransformer.transform(14, 5));
	}

}
