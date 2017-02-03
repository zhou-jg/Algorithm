package basic.recursion;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/3.
 */
public class WordSearchInBoardTest {
    WordSearchInBoard s = new WordSearchInBoard();

    @Test
    public void test(){
        assertTrue(s.exist(new char[][]{"aa".toCharArray()}, "a"));
        assertTrue(s.exist(new char[][]{"ABCE".toCharArray(),"SFCS".toCharArray(),"ADEE".toCharArray()}, "ABCCED"));
    }
}