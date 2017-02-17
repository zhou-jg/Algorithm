package basic.string.match;

import java.util.HashMap;
import java.util.Map;

/**
 * Source: <a href="https://leetcode.com/problems/isomorphic-strings/">
 *     https://leetcode.com/problems/isomorphic-strings/</a>
 *
 * <p>Given two strings <b>s</b> and <b>t</b>, determine if they are
 * isomorphic.
 *
 * <p>Two strings are isomorphic if the characters in <b>s</b> can be
 * replaced to get <b>t</b>.
 *
 * <p>All occurrences of a character must be replaced with another
 * character while preserving the order of characters. No two characters
 * may map to the same character but a character may map to itself.
 *
 * <p>For example,<br>
 * Given "egg", "add", return true.<br>
 * Given "foo", "bar", return false.<br>
 * Given "paper", "title", return true.<br>
 *
 * <p><b>Note:</b> You may assume both s and t have the same length.
 *
 * Created by zhou-jg on 2017/2/17.
 */
public class IsomorphicChecker {
    public boolean isIsomorphic(String s, String t) {
        if (s == null && t == null || s.length() == 0 && t.length() == 0){
            return true;
        }
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        //Valid mapping from s to t
        Map<Character, Character> map = new HashMap<>();
        for (int i=0; i<ss.length; i++){
            if (map.containsKey(ss[i])){
                char tc = map.get(ss[i]);
                if (tc != ts[i]){
                    return false;
                }
            }else{
                if (map.values().contains(ts[i])){
                    return false;
                }else{
                    map.put(ss[i], ts[i]);
                }
            }
        }

        return true;
    }
}
