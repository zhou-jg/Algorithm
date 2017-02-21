package basic.search.application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/21.
 */
public class DuplicateNumberFinderTest {
    DuplicateNumberFinder f = new DuplicateNumberFinder();

    @Test
    public void pass(){
        assertEquals(3, f.findDuplicate(new int[]{3,2,4,5,1,3,6}));
        assertEquals(3, f.findDuplicate(new int[]{3,2,4,5,1,3}));
    }

    @Test
    public void passOn(){
        assertEquals(3, f.findDuplicateII(new int[]{3,2,4,5,1,3,6}));
        assertEquals(3, f.findDuplicateII(new int[]{3,2,4,5,1,3}));
    }
}