package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/9.
 */
public class NthDigitTest {
    NthDigit d = new NthDigit();

    @Test
    public void test() {
        assertEquals(2, d.find(30));
        assertEquals(1, d.find(10));
        assertEquals(0, d.find(11));
        assertEquals(0, d.find(194));
    }

}