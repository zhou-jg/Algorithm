package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/9.
 */
public class HeatersForRadiusTest {
    HeatersForRadius h = new HeatersForRadius();

    @Test
    public void test(){
        assertEquals(1, h.findRadius(new int[]{1,2,3}, new int[]{2}));
        assertEquals(1, h.findRadius(new int[]{1,2,3,4}, new int[]{1,4}));
        assertEquals(25, h.findRadius(new int[]{1,2,3,5,30}, new int[]{2,5}));
    }
}