package basic.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackWithMinTest {

	@Test
	public void test() {
		StackWithMin<Integer> stack = new StackWithMin<>();
		stack.push(5);
		assertEquals(5, stack.min().intValue());
		
		stack.push(6);
		assertEquals(5, stack.min().intValue());
		
		stack.push(3);
		assertEquals(3, stack.min().intValue());
		
		stack.push(3);
		assertEquals(3, stack.min().intValue());
		
		stack.pop();
		assertEquals(3, stack.min().intValue());
		
		stack.pop();
		assertEquals(5, stack.min().intValue());
		
		stack.pop();
		assertEquals(5, stack.min().intValue());
	}

}
