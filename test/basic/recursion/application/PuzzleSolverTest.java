package basic.recursion.application;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class PuzzleSolverTest extends PuzzleSolver{
	
	public PuzzleSolverTest(){
		super(new HashSet<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9)));
	}

	@Test
	public void test() {
		Map<Character, Integer> solution = solve();
		//{a=1, b=3, r=4, g=2, i=7, y=5, l=0, o=9}
		System.out.println(solution);
		assertEquals(solution.get('a').intValue(), 1);
		assertEquals(solution.get('b').intValue(), 3);
		assertEquals(solution.get('g').intValue(), 2);
		assertEquals(solution.get('i').intValue(), 7);
		assertEquals(solution.get('l').intValue(), 0);
		assertEquals(solution.get('o').intValue(), 9);
		assertEquals(solution.get('r').intValue(), 4);
		assertEquals(solution.get('y').intValue(), 5);
	}

	@Override
	protected boolean check(Map<Character, Integer> solution) {
		return PuzzleSolver.isAdditionOK(Arrays.asList('b','o','y'), Arrays.asList('g','i','r','l'), Arrays.asList('b','a','b','y'), solution);			
	}

	@Override
	protected Set<Character> getVariables() {
		Set<Character> set = new HashSet<Character>(8);
		set.add('a');
		set.add('b');
		set.add('g');
		set.add('i');
		set.add('l');
		set.add('o');
		set.add('r');
		set.add('y');
		return set;
	}

}
