package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/16.
 */
public class DigitOneCounterTest {

    DigitOneCounter doc = new DigitOneCounter();
    @Test
    public void count() throws Exception {
        assertEquals(1, doc.count(9));
        assertEquals(5, doc.count(12));
        assertEquals(689, doc.count(1234));
    }

    @Test
    public void count2(){
        assertEquals(1, doc.count(9));
        assertEquals(5, doc.count(12));
        assertEquals(689, doc.count(1234));
        assertEquals(40, doc.count2(200));
    }

}