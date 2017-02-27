package basic.string.match;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/27.
 */
public class ReaptedSubStringTest {
    ReaptedSubString r = new ReaptedSubString();

    @Test
    public void pass(){
        assertTrue(r.repeatedSubstringPattern("aaaaaaaaaaaaaaaaaaaaa"));
        assertTrue(r.repeatedSubstringPattern("ababab"));
        assertFalse(r.repeatedSubstringPattern("ababac"));
    }
}