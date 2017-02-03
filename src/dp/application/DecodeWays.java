package dp.application;

/**
 * Source: https://leetcode.com/problems/decode-ways/
 *
 * <p> </p>A message containing letters from A-Z is being encoded to numbers
 * using the following mapping:<br>
 * 'A' -> 1<br>
 * 'B' -> 2<br>
 * ...<br>
 * 'Z' -> 26<br>
 *
 * <p></p>Given an encoded message containing digits, determine the total number of ways to decode it.
 *
 * <p></p>For example,<br>
 * Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 * <p></p>The number of ways decoding "12" is 2.
 *
 * Created by zhou-jg on 2017/2/3.
 */
public class DecodeWays {
    //ref: https://discuss.leetcode.com/topic/35840/java-clean-dp-solution-with-explanation
    public int numDecodings(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i <= n; i++) {
            int first = Integer.valueOf(s.substring(i-1, i));
            int second = Integer.valueOf(s.substring(i-2, i));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }
}
