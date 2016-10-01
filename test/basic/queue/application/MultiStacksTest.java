package basic.queue.application;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiStacksTest {

	@Test
	public void test() {
		MultiStacks<Integer> stacks = new MultiStacks<>(2);
		stacks.push(1);
		stacks.push(2);
		assertEquals(2, stacks.pop().intValue());
		
		stacks.push(2);
		stacks.push(3);
		assertEquals(2, stacks.pop(0).intValue());
		assertEquals(3, stacks.pop().intValue());
		
	}

	@Test
	public void test2() {
		MultiStacks<Integer> stacks = new MultiStacks<>(2);
		stacks.push(1);
		stacks.push(2);
		stacks.push(3);
		stacks.pop();
		stacks.push(3);
		
		assertEquals(2, stacks.pop(0).intValue());
		
	}
}
