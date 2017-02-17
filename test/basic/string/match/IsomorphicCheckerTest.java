package basic.string.match;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class IsomorphicCheckerTest {
    IsomorphicChecker c = new IsomorphicChecker();

    @Test
    public void pass(){
        assertTrue(c.isIsomorphic("egg", "add"));
        assertTrue(c.isIsomorphic("paper", "title"));
        assertFalse(c.isIsomorphic("foo", "bar"));
    }
}