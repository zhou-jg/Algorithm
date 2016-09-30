package basic.list;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class DuplicateElementRemoverTest {
	
	List<Integer> list = null;
	List<Integer> expected = Arrays.asList(1,2,3,4);
	
	@Before
	public void initData(){
		list = new ArrayList<Integer>(Arrays.asList(1,2,2,3,4,4));
	}

	@Test
	public void deleteDuplicatesWithSet() {		
		DuplicateElementRemover.deleteDuplicates(list);
		assertEquals(expected, list);
	}
	
	@Test
	public void deleteDuplicatesWithoutExtraSpace() {	
		DuplicateElementRemover.deleteDuplicates2(list);
		assertEquals(expected, list);
	}

}
