package basic.number;

import util.Algorithm;

/**
 * 来源：https://leetcode.com/problems/happy-number/
 * 或参考：https://en.wikipedia.org/wiki/Happy_number
 * 
 * A happy number is a number defined by the following process: 
 * Starting with any positive integer, replace the number by the sum of 
 * the squares of its digits, and repeat the process until the number 
 * equals 1 (where it will stay), or it loops endlessly in a cycle which 
 * does not include 1. Those numbers for which this process ends in 1 are happy numbers.
 * 
 * <b>Node:</b> According the following proof from the wikipedia link above:
 * <i>1 is a happy number, and for every n, power(10, n) is happy since its sum is 1
 * <i>for every n, 2 × power(10, n) is unhappy since its sum is 4 and 4 is an unhappy number.</i>
 * we can easily get the termination condition for a number that is unhappy.
 *
 *	Example: 19 is a happy number
 *
 *	squar(1) + squar(9) = 82
 *	squar(8) + squar(2) = 68
 *	squar(6) + squar(8) = 100
 *	squar(1) + squar(0) + squar(0) = 1
 *
 * @author Jingang Zhou
 *
 */
public class HappyNumber {

	@Algorithm("Easy")
	public boolean isHappyNumber(int n){
		if (n <= 0){
            return false;
        }
        int sum = 0;
        while (n > 0){
            int tmp = n % 10;
            sum += tmp * tmp;
            n /= 10;
        }
        if (sum == 1) {
            return true;
        }else if (sum == 4){
            return false;
        }else {
            return isHappyNumber(sum);
        }
	}
}
