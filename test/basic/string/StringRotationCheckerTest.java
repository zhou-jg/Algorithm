package basic.string;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringRotationCheckerTest {

	@Test
	public void falseWhenStringIsNull() {
		assertFalse(StringRotationChecker.isRotatedFrom(null, null));
	}
	
	@Test
	public void falseWhenStringLengthNotEqual(){
		assertFalse(StringRotationChecker.isRotatedFrom("fa", "fdafsa"));
	}
	
	@Test
	public void trueWhenStringIsFromRotation(){
		assertTrue(StringRotationChecker.isRotatedFrom("abcd", "cdab"));
	}

}
