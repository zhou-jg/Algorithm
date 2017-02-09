package basic.string.match;

import java.util.Objects;

/**
 * Souce: https://leetcode.com/problems/wildcard-matching/
 *
 * <p></p>'?' Matches any single character.<br>
 * '*' Matches any sequence of characters (including the empty sequence).
 *
 * <p>The matching should cover the entire input string (not partial).
 *
 * <p>Some examples:</p>
 * <code>isMatch("aa","a") → false<br>
 * isMatch("aa","aa") → true<br>
 * isMatch("aaa","aa") → false<br>
 * isMatch("aa", "*") → true<br>
 * isMatch("aa", "a*") → true<br>
 * isMatch("ab", "?*") → true<br>
 * isMatch("aab", "c*a*b") → false<br></code>
 *
 * Created by zhou-jg on 2017/2/8.
 */
public class WildCharMatcher {
    /**
     *
     * @param s 要匹配的字符串
     * @param p 带有通配符'*'和'?'的模式串
     * @return
     */
    public boolean isMatch(String s, String p){
        Objects.requireNonNull(s);
        Objects.requireNonNull(p);

        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        int m = s.length(), n = p.length();
        int i = 0, j = 0, asterick = -1, match = 0;
        while (i < m) {
            if (j < n && ps[j] == '*') {
                match = i;
                asterick = j++;
            }else if (j < n && (ss[i] == ps[j] || ps[j] == '?')) {
                i++;
                j++;
            }else if (asterick >= 0) {
                i = ++match;
                j = asterick + 1;
            }else {
                return false;
            }
        }
        while (j < n && ps[j] == '*') j++;
        return j == n;
    }
}
