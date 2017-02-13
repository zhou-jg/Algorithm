package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/13.
 */
public class RectangleConstructorTest {

    RectangleConstructor rc = new RectangleConstructor();

    @Test
    public void test(){
        assertArrayEquals(new int[]{2,2}, rc.constructRectangle(4));
        assertArrayEquals(new int[]{6,4}, rc.constructRectangle(24));
        assertArrayEquals(new int[]{5,1}, rc.constructRectangle(5));
    }
}