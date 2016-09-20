package game;

import static org.junit.Assert.*;
import game.MasterMind.Color;

import org.junit.Test;

import util.Pair;

public class MasterMindTest {

	@Test
	public void testGuess() {
		MasterMind mm = new MasterMind(new Color[]{Color.R, Color.G, Color.B, Color.Y});
		Pair<Integer> p = mm.guess(new Color[]{Color.G, Color.G, Color.R, Color.R});
		
		assertEquals(1, p.getLeft().intValue());
		assertEquals(1, p.getRight().intValue());		
	}

}
