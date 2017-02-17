package basic.string;

/**
 * Source: <a href="https://leetcode.com/problems/count-and-say/">
 *     https://leetcode.com/problems/count-and-say/</a>
 *
 * <p>The count-and-say sequence is the sequence of integers beginning as follows:</br>
 * <code>1, 11, 21, 1211, 111221, ...</code>
 *
 * <p><code>1</code> is read off as <code>"one 1"</code> or <code>11</code>.
 * <p><code>11</code> is read off as <code>"two 1s"</code> or <code>21</code>.
 * <p><code>21</code> is read off as <code>"one 2</code>, then
 * <code>one 1"</code> or <code>1211</code>.
 *
 * <p>Given an integer n, generate the nth sequence.
 *
 * <p>Note: The sequence of integers will be represented as a string.
 *
 * <p>Created by zhou-jg on 2017/2/17.
 */
public class CountAndSay {
    /**
     * Start from 1, build the nth sequence via a StringBuilder that holds
     * the inter-sequence string.
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        StringBuilder sb = new StringBuilder("1");
        if (n == 1){
            return sb.toString();
        }else{
            for (int i=2; i<=n; i++){
                char[] cs = sb.toString().toCharArray();
                //digit
                char c = cs[0];
                //digit count
                int count = 1;
                sb = new StringBuilder();
                for (int j=1; j<cs.length; j++){
                    if (cs[j] == c){
                        count++;
                    }else{
                        sb.append(count);
                        sb.append(c);
                        c = cs[j];
                        count = 1;
                    }
                }
                sb.append(count);
                sb.append(c);
            }

            return sb.toString();
        }
    }
}
