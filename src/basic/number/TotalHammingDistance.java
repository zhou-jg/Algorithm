package basic.number;
/**
Source : https://leetcode.com/problems/total-hamming-distance/

The Hamming distance between two integers is the number of positions
at which the corresponding bits are different. Now your job is to find 
the total Hamming distance between all pairs of the given numbers.

Example:
Input: 4, 14, 2

Output: 6

Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
showing the four bits relevant in this case). So the answer will be:
HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
*/
public class TotalHammingDistance {
  /**
  Source: https://discuss.leetcode.com/topic/74655/simple-example-for-the-java-o-n-time-o-1-space-solution
  
  The idea is same as https://discuss.leetcode.com/topic/72092/java-o-n-time-o-1-space
  Assuming we have an array of five integers a, b, c, d, e as follow.
  We examine the digits one by one from the last digit.
  Count the number of integers whose last digit is 1, assign the value to ones

    a = 0 0 0 1 0
    b = 1 0 0 1 1
    c = 0 1 0 0 1
    d = 1 0 0 1 0
    e = 0 0 0 1 0
                ↑
    ones: b, c
    zeros: a, d, e
    
    pairs that make distance are:
    b: a, d, e
    c: a, d, e

    So we have 2 ones and 5 - 2 = 3 zeros
    Total distance = 2 * 3
    then we move the pointer one position left, i.e. all the numbers right shift by 1 (num >>> 1)
  */  
  public int totalHammingDistance(int[] nums) {
        int res = 0, len = nums.length;
        for(int i = 0; i < 32; i++) { //32 digits in integers
            int ones = 0; 
            for(int j = 0; j < len; j++) {
                if((nums[j] & 1) == 1) ones++;
                nums[j] = nums[j] >>> 1;
            }
            res = res + ones * (len - ones);
        }
        return res;
    }
}
