package util;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class GPairTest {

	@Test
	public void test() {
		Map<GPair<String, String>, Integer> map = new HashMap<GPair<String, String>, Integer>();
		map.put(new GPair<String, String>("D", "A"), 5);
		assertEquals(Integer.valueOf(5), map.get(new GPair<String, String>("D", "A")));
	}

}
