package basic.string.match;

import java.util.HashMap;
import java.util.Map;

/**
 * Souce: <a href="https://leetcode.com/problems/word-pattern/">
 *     https://leetcode.com/problems/word-pattern/</a>
 *
 * <p>Given a <code>pattern</code> and a string <code>str</code>, find
 * if <code>str</code> follows the same pattern.
 *
 * <p>Here <b>follow</b> means a full match, such that there is a bijection
 * between a letter in <code>pattern</code> and a <b>non-empty</b> word in
 * <code>str</code>.
 *
 * <p><b>Examples:</b>
 * <li>pattern = <code>"abba"</code>, str = <code>"dog cat cat dog"</code>
 * should return true.
 * <li>pattern = <code>"abba"</code>, str = <code>"dog cat cat fish"</code>
 * should return false.
 * <li>pattern = <code>"aaaa"</code>, str = <code>"dog cat cat dog"</code>
 * should return false.
 * <li>pattern = <code>"abba"</code>, str = <code>"dog dog dog dog"</code>
 * should return false.
 *
 * <p><b>Notes:</b><br>
 * You may assume <code>pattern</code> contains only lowercase letters, and
 * <code>str</code> contains lowercase letters separated by a single space.</p>
 *
 * @see IsomorphicChecker
 *
 * Created by zhou-jg on 2017/2/17.
 */
public class WordPatternMatcher {
    /**
     *
     * @param pattern
     * @param str
     * @return
     * @see IsomorphicChecker#isIsomorphic(String, String)
     */
    public boolean wordPattern(String pattern, String str) {
        char[] ps = pattern.toCharArray();
        String[] ws = str.split(" ");
        if (ps.length != ws.length){
            return false;
        }else{
            Map<Character, String> map = new HashMap<>();
            for (int i=0; i<ps.length; i++){
                if (map.containsKey(ps[i])){
                    String t = map.get(ps[i]);
                    if (!t.equals(ws[i])){
                        return false;
                    }
                }else{
                    if (map.values().contains(ws[i])){
                        return false;
                    }else{
                        map.put(ps[i], ws[i]);
                    }
                }
            }

            return true;
        }
    }
}
