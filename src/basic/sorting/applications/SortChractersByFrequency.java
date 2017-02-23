package basic.sorting.applications;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Source: <a herf="https://leetcode.com/problems/sort-characters-by-frequency/?tab=Description">
 *     https://leetcode.com/problems/sort-characters-by-frequency/</a>
 *
 * <p>Given a string, sort it in decreasing order based on the frequency of characters.
 * <p><b>Example 1:</b></p>
 * <code><b>Input:</b><br>
 * "tree"<br>
 * <b>Output:</b><br>
 * "eert"<br>
 * <b>Explanation:</b><br>
 * 'e' appears twice while 'r' and 't' both appear once. So 'e' must appear before both 'r' and 't'.
 * Therefore "eetr" is also a valid answer.</code>
 *
 * <p><b>Example 2:</b></p>
 * <code><b>Input:</b><br>
 * "cccaaa"<br>
 * <b>Output:</b><br>
 * "cccaaa"<br>
 * <b>Explanation:</b><br>
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer. Note that "cacaca" is
 * incorrect, as the same characters must be together.</code>
 *
 * <p><b>Example 3:</b></p>
 * <code><b>Input:</b><br>
 * "Aabb"<br>
 * <b>Output:</b><br>
 * "bbAa"<br>
 * <b>Explanation:</b><br>
 * "bbaA" is also a valid answer, but "Aabb" is incorrect. Note that 'A' and 'a' are treated as
 * two different characters.</code>
 *
 * <p>Created by zhou-jg on 2017/2/23.
 */
public class SortChractersByFrequency {
    public String frequencySort(String s) {
        if (s == null || s.length() < 3){
            return s;
        }
        char[] cs = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : cs){
            if (map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }

        Character[] ss = new Character[map.size()];
        int i=0;
        for (char c : map.keySet()){
            ss[i] = c;
            i++;
        }
        Arrays.sort(ss, (c1, c2) -> map.get(c2)-map.get(c1));
        StringBuilder sb = new StringBuilder(cs.length);
        for (char c : ss){
            for (i=1; i<=map.get(c); i++){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
