package basic.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

public class CombinationGeneratorTest {

	@Test
	public void test() {
		CombinationGenerator cg = new CombinationGenerator(new Character[]{'A', 'B', 'C', 'D'});
		Set<Set<Character>> ret = cg.generate(3);
		for (Set<Character> s : ret){
			System.out.println(s);
		}
		assertEquals(4, ret.size());
	}

}
