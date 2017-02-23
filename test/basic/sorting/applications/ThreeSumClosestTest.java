package basic.sorting.applications;

import basic.sorting.applications.ThreeSumClosest;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/22.
 */
public class ThreeSumClosestTest {
    ThreeSumClosest tsc = new ThreeSumClosest();

    @Test
    public void pass(){
        assertEquals(82, tsc.threeSumClosest(new int[]{1,2,4,8,16,32,64,128}, 82));
    }

    @Test
    public void passII(){
        assertEquals(82, tsc.threeSumClosestII(new int[]{1,2,4,8,16,32,64,128}, 82));
    }
}