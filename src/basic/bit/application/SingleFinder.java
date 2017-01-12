package basic.bit.application;

/**
 * https://leetcode.com/problems/single-number/
 * Given an array of integers, every element appears twice except for one. Find that single one.

   Note:
    Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * Created by zhou-jg on 2017/1/12.
 */
public class SingleFinder {

    /**
     * 自身的异或得0；异或满足交换律
     * @param num
     * @return
     */
    public static int find (int[] num){
        int ret = 0;
        for (int i=0; i<num.length; i++){
            ret ^= num[i];
        }
        return ret;
    }
}
