package basic.search.application;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class GuessNumberTest {

    @Test
    public void pass(){
        GuessNumber n = new GuessNumber(2);
        assertEquals(2, n.guessNumber(2));

        n = new GuessNumber(6);
        assertEquals(6, n.guessNumber(10));
    }
}