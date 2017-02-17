package basic.string.match;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class WordPatternMatcherTest {
    WordPatternMatcher m = new WordPatternMatcher();

    @Test
    public void test(){
        assertTrue(m.wordPattern("abba", "dog cat cat dog"));
        assertFalse(m.wordPattern("abba", "dog cat cat fish"));
        assertFalse(m.wordPattern("aaaa", "dog cat cat dog"));
        assertFalse(m.wordPattern("abba", "dog dog dog dog"));
    }
}