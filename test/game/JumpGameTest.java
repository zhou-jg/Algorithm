package game;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/20.
 */
public class JumpGameTest {
    JumpGame g = new JumpGame();

    @Test
    public void canJump(){
        assertTrue(g.canJump(new int[]{0}));
        assertTrue(g.canJump(new int[]{1,2,3}));
    }

    @Test
    public void cannotJump(){
        assertFalse(g.canJump(new int[]{2,1,0,0}));
    }
}