package basic.number;

import java.util.ArrayList;
import java.util.List;

/**
 * Source: https://leetcode.com/problems/integer-break/
 * 
 * <p>Given a positive integer n, break it into the sum of at least 
 * two positive integers and maximize the product of those integers. 
 * Return the maximum product you can get.
 * 
 * <p>For example, given n = 2, return 1 (2 = 1 + 1); 
 * given n = 10, return 36 (10 = 3 + 3 + 4).

 * <p>Note: You may assume that n is not less than 2 and not larger than 58.

 * <p>Hint:

 * There is a simple O(n) solution to this problem. You may check the 
 * breaking results of n ranging from 7 to 10 to discover the regularities.
 * 
 * @author Jingang Zhou
 *
 */
public class MaxProductFromIntegerBreak {
	public int integerBreak(int n) {
        List<Integer> vals = new ArrayList<>();
        if (n == 2){
            return 1;
        }else if (n ==3){
            return 2;
        }else if (n == 4){
            return 4;
        }else{
            while (n >= 5){
                vals.add(3);
                n -= 3;
            }
            for (int val :vals){
                n *= val;
            }
            return n;
        }
    }
}
