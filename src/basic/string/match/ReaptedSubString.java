package basic.string.match;

/**
 * Source: https://leetcode.com/problems/repeated-substring-pattern/?tab=Description
 *
 * Given a non-empty string check if it can be constructed by taking a
 * substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters
 * only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 *
 * Created by zhou-jg on 2017/2/12.
 */
public class ReaptedSubString {
    public boolean repeatedSubstringPattern(String str) {
        if (str == null || str.length() < 2){
            return false;
        }
        int len = str.length();
        //Whether str is constructed by two substring
        if (len % 2 == 0){
            if (str.substring(0, len/2).equals(str.substring(len/2, len))){
                return true;
            }
        }
        //Whether str is constructed by odd numbers substring
        int part = 1;
        outer: while (part+2 <= len){
            part += 2;
            if (len % part == 0){
                int width = len/part;
                for (int i=1; i<part; i++){
                    if (!str.substring(0, width).equals(str.substring(i*width, (i+1)*width))){
                        continue outer;
                    }
                }

                return true;
            }
        }
        return false;
    }
}
