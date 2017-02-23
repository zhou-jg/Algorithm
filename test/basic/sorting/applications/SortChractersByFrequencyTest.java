package basic.sorting.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/23.
 */
public class SortChractersByFrequencyTest {
    SortChractersByFrequency s = new SortChractersByFrequency();

    @Test
    public void pass(){
        assertEquals("eeerrt", s.frequencySort("treree"));
    }
}