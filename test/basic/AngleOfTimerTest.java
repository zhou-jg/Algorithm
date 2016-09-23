package basic;

import static org.junit.Assert.*;

import org.junit.Test;

public class AngleOfTimerTest {

	@Test
	public void testAngle() {
		assertEquals(0, AngleOfTimer.computeAngle(12, 0), 0);
		assertEquals(30, AngleOfTimer.computeAngle(1, 0), 0);
		assertEquals(105, AngleOfTimer.computeAngle(2, 30), 0);
		
		assertEquals(AngleOfTimer.computeAngle(2, 31), AngleOfTimer.computeAngle(2, 30), 5.5);
	}

}
