package basic.search;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/21.
 */
public class FirstMissingPositiveFinderTest {
    FirstMissingPositiveFinder f = new FirstMissingPositiveFinder();

    @Test
    public void pass(){
        assertEquals(1, f.firstMissingPositive(new int[]{0}));
        assertEquals(2, f.firstMissingPositive(new int[]{1, 0}));
        assertEquals(3, f.firstMissingPositive(new int[]{1,2,0}));
        assertEquals(2, f.firstMissingPositive(new int[]{3,4,-1,1}));
    }
}