package basic.list.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructure.List;

public class SumByListBitsTest {
	
	private List<Integer> h1 = new List<Integer>(1); //1->2->3
	private List<Integer> h2 = new List<Integer>(5); //5->2->3->4
	{
		List<Integer> tmp = h1;
		tmp.setNext(new List<Integer>(2));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(3));
		tmp = tmp.getNext();
		
		tmp = h2;
		tmp.setNext(new List<Integer>(2));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(3));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(4));
	}

	@Test
	public void positiveSum() {
		assertEquals(123+5234, SumByListBits.sum(h1, h2, true));;
	}
	
	@Test
	public void negativeSum() {
		assertEquals(321+4325, SumByListBits.sum(h1, h2, false));
	}

}
