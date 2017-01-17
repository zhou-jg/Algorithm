package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/16.
 */
public class DigitOneCounterTest {
    @Test
    public void count() throws Exception {
        DigitOneCounter doc = new DigitOneCounter();
        assertEquals(1, doc.count(9));
        assertEquals(5, doc.count(12));
        assertEquals(689, doc.count(1234));
    }

}