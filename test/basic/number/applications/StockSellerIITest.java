package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/2/16.
 */
public class StockSellerIITest {
    StockSellerII stocker = new StockSellerII();

    @Test
    public void test(){
        assertEquals(6, stocker.maxProfit(new int[]{5,5,4,3,6,4,7,5}));
        assertEquals(7, stocker.maxProfit(new int[]{4,5,4,3,6,4,7,5}));
    }
}