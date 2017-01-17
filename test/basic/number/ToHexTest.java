package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/17.
 */
public class ToHexTest {
    @Test
    public void toHex() throws Exception {
        ToHex to = new ToHex();
        assertEquals("ffffffff", to.toHex(-1));
        assertEquals("1a", to.toHex(26));
    }

}