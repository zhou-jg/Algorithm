package datastructure;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class HeapTest {

	private Heap<Integer> minHeap = new Heap<Integer>(true);
	private Heap<Integer> maxHeap = new Heap<Integer>(false);
	
	@Test
	public void buildHeap(){
		Heap<Integer> heap = new Heap<Integer>(new Integer[]{5,3,8,4}, true);
		assertEquals(Arrays.asList(3,4,8,5), heap.getList());
	}
	
	@Test
	public void minHeap() {
		minHeap.add(5);
		assertEquals(Arrays.asList(5), minHeap.getList());
		
		minHeap.add(3);
		assertEquals(Arrays.asList(3, 5), minHeap.getList());
		
		minHeap.add(8);
		assertEquals(Arrays.asList(3, 5, 8), minHeap.getList());
		
		minHeap.add(4);
		assertEquals(Arrays.asList(3, 4, 8, 5), minHeap.getList());
		
		minHeap.pop();
		assertEquals(Arrays.asList(4,5,8), minHeap.getList());
	}

	@Test
	public void maxHeap(){
		maxHeap.add(5);
		assertEquals(Arrays.asList(5), maxHeap.getList());
		
		maxHeap.add(3);
		assertEquals(Arrays.asList(5, 3), maxHeap.getList());
		
		maxHeap.add(8);
		assertEquals(Arrays.asList(8, 3, 5), maxHeap.getList());
		
		maxHeap.add(4);
		assertEquals(Arrays.asList(8, 4, 5, 3), maxHeap.getList());
		
		maxHeap.pop();
		assertEquals(Arrays.asList(5, 4, 3), maxHeap.getList());
	}
}
