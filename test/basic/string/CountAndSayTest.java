package basic.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class CountAndSayTest {
    CountAndSay cs = new CountAndSay();

    @Test
    public void pass(){
        assertEquals("1211" ,cs.countAndSay(4));
        assertEquals("312211", cs.countAndSay(6));
    }
}