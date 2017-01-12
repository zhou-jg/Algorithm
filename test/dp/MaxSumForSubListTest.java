package dp;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/12.
 */
public class MaxSumForSubListTest {

    @Test
    public void test(){
        assertEquals(18, MaxSumForSubList.compute(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
    }
}
