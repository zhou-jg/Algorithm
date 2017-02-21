package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/21.
 */
public class TeemoAttackingTest {
    TeemoAttacking ta = new TeemoAttacking();

    @Test
    public void pass(){
        assertEquals(4, ta.findPoisonedDuration(new int[]{1, 4}, 2));
        assertEquals(3, ta.findPoisonedDuration(new int[]{1, 2}, 2));
        assertEquals(9, ta.findPoisonedDuration(new int[]{1,2,3,4,8}, 3));
    }
}