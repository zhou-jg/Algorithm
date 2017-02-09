package basic.string.match;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/8.
 */
public class WildCharMatcherTest {
    WildCharMatcher m = new WildCharMatcher();

    @Test
    public void match(){
        assertTrue(m.isMatch("aa","aa"));
        assertTrue(m.isMatch("aa", "*"));
        assertTrue(m.isMatch("aa", "a*"));
        assertTrue(m.isMatch("ab", "?*"));
    }

    @Test
    public void notMatch() {
        assertFalse(m.isMatch("aa","a"));
        assertFalse(m.isMatch("aaa","aa"));
        assertFalse(m.isMatch("aab", "c*a*b"));
    }

}