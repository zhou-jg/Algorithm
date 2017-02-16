package basic.number.applications;

/**
 * Source: <a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/">
 *     https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/</a>
 *
 * <p>Say you have an array for which the ith element is the price of a
 * given stock on day i.
 *
 * <p>Design an algorithm to find the maximum profit. You may complete as
 * many transactions as you like (ie, buy one and sell one share of the
 * stock multiple times). However, you may not engage in multiple transactions
 * at the same time (ie, you must sell the stock before you buy again).
 *
 * <p>Ref: {@link StockSeller StockSeller}</p>
 *
 * Created by zhou-jg on 2017/2/16.
 */
public class StockSellerII {
    /**
     * Traverse to find inflexion point in the top and bottom alternately.
     * And accumulate the diffs.
     * @param prices Array of stock values of every day
     * @return max profit gained by buying and selling stocks
     * @see StockSeller#maxProfit(int[])
     */
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2){
            return 0;
        }
        int val = prices[0], max = 0;
        int i=0;
        while (i+1 < prices.length){
            if (prices[i+1] > val){
                while (i+1 < prices.length && prices[i+1] >= prices[i]){
                    i++;
                }
                max += prices[i]-val;
            }else{
                while (i+1 < prices.length && prices[i+1] <= prices[i]) {
                    i++;
                }
            }
            val = prices[i];
        }

        return max;
    }
}
