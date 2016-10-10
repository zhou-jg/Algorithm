package basic.tree.application;

import java.util.List;

import org.junit.Test;

import util.GPair;

public class HuffmanCodingTest {

	@Test
	public void test() {
		List<GPair<Integer, String>> result = HuffmanCoding.encoding(new int[]{1,3,4,6});
		for (GPair<Integer, String> p : result){
			System.out.println(p);
		}
		
	}

}
