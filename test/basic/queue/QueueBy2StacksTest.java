package basic.queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueBy2StacksTest {

	@Test
	public void test() {
		QueueBy2Stacks<Integer> queue = new QueueBy2Stacks<>();
		queue.in(1);
		queue.in(2);
		assertEquals(1, queue.out().intValue());
		assertEquals(2, queue.peek().intValue());
		queue.in(3);
		assertEquals(2, queue.out().intValue());
	}

}
