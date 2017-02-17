package basic.string;

/**
 * Source: <a href="https://leetcode.com/problems/reverse-words-in-a-string/">
 *     https://leetcode.com/problems/reverse-words-in-a-string/</a>
 *
 * <p>Given an input string, reverse the string word by word.
 * <p>For example,<br>
 * Given s = "the sky is blue",<br>
 * return "blue is sky the".<br>
 *
 * Created by zhou-jg on 2017/2/17.
 */
public class WordsReverser {
    public String reverseWords(String s) {
        if (s == null){
            return s;
        }else if (s.trim().equals("")){
            return s.trim();
        }

        char[] cs = s.trim().toCharArray();
        StringBuilder sb = new StringBuilder(cs.length);
        int i=cs.length-1, j=i;
        while (j >= 0){
            while (j >= 0 && cs[j] != ' '){
                j--;
            }
            for (int k=j+1; k<=i; k++){
                sb.append(cs[k]);
            }
            sb.append(' ');
            if (j == -1){
                break;
            }
            while (j >= 0 && cs[j] == ' '){
                j--;
            }
            i=j;
        }

        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
