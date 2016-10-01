package basic.list;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import datastructure.List;

public class PalindromeCheckerTest {

	private List<Integer> h1 = new List<Integer>(1);
	private List<Integer> h2 = new List<Integer>(1);
	
	@Before
	public void initData(){		
		List<Integer> node1 = h1, node2 = h2;		
		node1.setNext(new List<Integer>(3));
		node1 = node1.getNext();
		node1.setNext(new List<Integer>(5));
		node1 = node1.getNext();
		node1.setNext(new List<Integer>(3));
		node1 = node1.getNext();

		node2.setNext(new List<Integer>(3));
		node2 = node2.getNext();
		node2.setNext(new List<Integer>(5));
		node2 = node2.getNext();
		node2.setNext(new List<Integer>(3));
		node2 = node2.getNext();
		node2.setNext(new List<Integer>(1));
		node2 = node2.getNext();
	}
	
	@Test
	public void h1IsFalseAndh2IsTrue() {
		assertFalse(PalindromeChecker.isPalindrome(h1));
		assertTrue(PalindromeChecker.isPalindrome(h2));
	}
	
	

}
