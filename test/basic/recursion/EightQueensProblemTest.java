package basic.recursion;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class EightQueensProblemTest {

	@Test
	public void test() {
		List<Integer[]> results = EightQueensProblem.find();
		for (Integer[] record : results){
			System.out.println(Arrays.asList(record));
		}
		
		assertEquals(92, results.size());
	}

}
