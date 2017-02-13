package basic.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/13.
 */
public class DiagonalTraverserTest {
    DiagonalTraverser t = new DiagonalTraverser();

    @Test
    public void test(){
        assertArrayEquals(new int[]{1,2,4,7,5,3,6,8,9}, t.traverse(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        assertArrayEquals(new int[]{1,2,5,9,6,3,4,7,10,13,14,11,8,12,15,16}, t.traverse(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}}));

    }
}