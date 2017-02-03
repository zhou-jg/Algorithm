package dp.application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/3.
 */
public class DecodeWaysTest {
    DecodeWays ways = new DecodeWays();

    @Test
    public void pass(){
        assertEquals(1, ways.numDecodings("10"));
        assertEquals(0, ways.numDecodings("01"));
        assertEquals(2, ways.numDecodings("12"));
    }
}