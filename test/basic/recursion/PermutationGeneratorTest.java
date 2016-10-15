package basic.recursion;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class PermutationGeneratorTest {

	@Test
	public void test() {
		PermutationGenerator pg = new PermutationGenerator(new Character[]{'A', 'B', 'C', 'D'});
		List<List<Character>> ret = pg.generate(3);
		for (List<Character> s : ret){
			System.out.println(s);
		}
		assertEquals(24, ret.size());
	}

}
