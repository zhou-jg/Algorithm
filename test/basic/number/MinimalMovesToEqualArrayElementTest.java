package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/9.
 */
public class MinimalMovesToEqualArrayElementTest {
    MinimalMovesToEqualArrayElement m = new MinimalMovesToEqualArrayElement();

    @Test
    public void test(){
        assertEquals(3, m.minMoves(new int[]{1,2,3}));
        assertEquals(7, m.minMoves(new int[]{5,6,8,8,5}));
        assertEquals(2147483646, m.minMoves(new int[]{1,1,2147483647}));
        assertEquals(300, m.minMoves(new int[]{-100, 0, 100}));
    }

}