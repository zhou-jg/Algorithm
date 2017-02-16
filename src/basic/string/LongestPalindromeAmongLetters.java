package basic.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Source: <a href="https://leetcode.com/problems/longest-palindrome/">
 *     https://leetcode.com/problems/longest-palindrome/</a>
 *
 * <p>Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with
 * those letters.</p>
 *
 * <p>This is case sensitive, for example "Aa" is not considered a palindrome
 * here.</p>
 *
 * <p>Note:<br>
 * Assume the length of given string will not exceed 1,010.
 *
 * <p><b>Example:</b><br>
 * <pre>
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.</pre>

 * Created by zhou-jg on 2017/2/16.
 */
public class LongestPalindromeAmongLetters {
    /**
     * Check whether the count of each letter is odd or even.
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return 0;
        }
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs){
            if (!map.containsKey(c)){
                map.put(c, 1);
            }else{
                map.put(c, map.get(c)+1);
            }
        }
        int length = 0;
        boolean flag = false;
        for (char c : map.keySet()){
            int v = map.get(c);
            if (v % 2 == 0){
                length += v;
            }else{
                if (flag){
                    length += v-1;
                }else {
                    length += v;
                    flag = true;
                }
            }
        }

        return length;
    }
}
