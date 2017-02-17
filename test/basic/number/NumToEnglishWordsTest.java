package basic.number;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/17.
 */
public class NumToEnglishWordsTest {
    NumToEnglishWords t = new NumToEnglishWords();

    @Test
    public void pass(){
        assertEquals("One Hundred", t.numberToWords(100));
        assertEquals("One Hundred Twenty Three", t.numberToWords(123));
        assertEquals("Twelve Thousand Three Hundred Forty Five", t.numberToWords(12345));
        assertEquals("One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven", t.numberToWords(1234567));
    }
}