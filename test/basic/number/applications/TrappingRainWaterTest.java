package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/4.
 */
public class TrappingRainWaterTest {
    TrappingRainWater w = new TrappingRainWater();

    @Test
    public void test(){
        assertEquals(2, w.trap(new int[]{2, 0, 2}));
        assertEquals(6, w.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}