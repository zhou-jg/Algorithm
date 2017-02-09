package basic.number;

/**
 * Source: https://leetcode.com/problems/nth-digit/
 *
 * <p></p>Find the nth digit of the infinite integer sequence
 * 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 *
 * <p>Note:<br>
 * n is positive and will fit within the range of a 32-bit
 * signed integer (n < 231).
 *
 * <p>Example 1:<br>
 * Input: 3  Output: 3<br>
 * <p>Example 2:<br>
 * Input: 11  Output: 0
 * <p>Explanation:<br>
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11,
 * ... is a 0, which is part of the number 10.
 *
 * Created by zhou-jg on 2017/2/9.
 */
public class NthDigit {

    /**
     * 思路：1，计算目标数的位数；2，计算目标数；3，确定目标数的目标位
     * @param n
     * @return
     */
    public int find(int n){
        if (n <= 9){
            return n;
        }
        int i=1; //位数
        int fac = 1; //累积因子，也是i位数的第一个数
        //截止某位数的所有数字个数
        while (n > (long) i * 9 * fac) {
            n -= 9 * fac * i;
            fac *= 10;
            i++;
        }
        int target = fac + (n-1)/i;//目标数
        String str = Integer.toString(target);
        return str.charAt((n-1)%i) - '0';
    }

}
