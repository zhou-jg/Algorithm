package basic.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackWithOrderTest {

	@Test
	public void testAscending() {
		StackWithOrder<Integer> stack = new StackWithOrder<>(true);
		stack.push(3);
		stack.push(2);
		assertEquals(2, stack.peek().intValue());
		
		stack.push(4);
		assertEquals(2, stack.pop().intValue());
		assertEquals(3, stack.pop().intValue());		
	}
	
	@Test
	public void testDescending(){
		StackWithOrder<Integer> stack = new StackWithOrder<>(false);
		stack.push(3);
		stack.push(2);
		assertEquals(3, stack.peek().intValue());
		
		stack.push(1);
		assertEquals(3, stack.pop().intValue());
		assertEquals(2, stack.pop().intValue());
	}

}
