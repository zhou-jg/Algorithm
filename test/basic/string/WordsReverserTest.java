package basic.string;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class WordsReverserTest {
    WordsReverser r = new WordsReverser();

    @Test
    public void pass(){
        assertEquals("blue is sky the", r.reverseWords("the sky is blue"));
        assertEquals("a", r.reverseWords("a"));
        assertEquals("a b", r.reverseWords(" b a "));
    }
}