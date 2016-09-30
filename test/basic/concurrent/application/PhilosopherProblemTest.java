package basic.concurrent.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class PhilosopherProblemTest {

	@Test
	public void test() {
		int[] result = PhilosopherProblem.resolve(8);
		assertArrayEquals(new int[]{1,1,1,1,1,1,1,1}, result);
	}

}
