package basic.number.applications;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhou-jg on 2017/1/16.
 */
public class StockSellerTest {

    StockSeller ss = new StockSeller();

    @Test
    public void hasProfit(){
        assertEquals(5, ss.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }

    @Test
    public void noProfitYet(){
        assertEquals(0, ss.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}