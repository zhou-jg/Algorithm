package basic.list.application;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import datastructure.List;

public class SumByListBitsTest {
	
	private List<Integer> h1 = new List<Integer>(1); //1->2->3
	private List<Integer> h2 = new List<Integer>(5); //5->2->3->4
	private List<Integer> posSum = new List<Integer>(5); //5->3->5->7
	private List<Integer> negSum = new List<Integer>(6); //6->4->6->4
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
		
		tmp = posSum;
		tmp.setNext(new List<Integer>(3));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(5));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(7));
		
		tmp = negSum;
		tmp.setNext(new List<Integer>(4));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(6));
		tmp = tmp.getNext();
		tmp.setNext(new List<Integer>(4));
	}
	
	@Test
	public void positiveSum() {
		assertEquals(posSum, SumByListBits.sum(h1, h2, true));;
	}
	
	@Test
	public void negativeSum() {
		assertEquals(negSum, SumByListBits.sum(h1, h2, false));
	}

}
