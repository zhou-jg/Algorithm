package basic.string;

import util.Algorithm;
import util.Pair;

public class LongestPalindrome {
	
	/**
	 * Manacher's算法。O(N)
	 * @param s 给定字符串
	 * @return 最长回文子串的首尾索引（左闭右开）
	 */
	@Algorithm("动态规划")
	public static Pair<Integer> manachersAlgorithm (String s) {
        if (s==null || s.length()==0)
            return new Pair<Integer>(-1, -1);
        //将奇偶两种情况统一为奇数处理情况
        char[] s2 = addBoundaries(s.toCharArray());
        //记录以s2[i]为轴的最大回文半径
        int[] p = new int[s2.length]; 
        int c = 0, r = 0; // Here the first element in s2 has been processed.
        int m = 0, n = 0; // The walking indices to compare if two elements are the same
        for (int i = 1; i<s2.length; i++) {
            if (i>r) {
                p[i] = 0; m = i-1; n = i+1;
            } else {
                int i2 = c*2-i;
                if (p[i2]<(r-i)) {
                    p[i] = p[i2];
                    m = -1; // This signals bypassing the while loop below. 
                } else {
                    p[i] = r-i;
                    n = r+1; m = i*2-n;
                }
            }
            while (m>=0 && n<s2.length && s2[m]==s2[n]) {
                p[i]++; m--; n++;
            }
            if ((i+p[i])>r) {
                c = i; r = i+p[i];
            }
        }
        int len = 0; c = 0;
        for (int i = 1; i<s2.length; i++) {
            if (len<p[i]) {
                len = p[i]; c = i;
            }
        }

        return new Pair<Integer>((c-len)/2, (c+len)/2);
    }
 
    private static char[] addBoundaries(char[] cs) {
        if (cs==null || cs.length==0)
            return "||".toCharArray();

        char[] cs2 = new char[cs.length*2+1];
        for (int i = 0; i<(cs2.length-1); i = i+2) {
            cs2[i] = '|';
            cs2[i+1] = cs[i/2];
        }
        cs2[cs2.length-1] = '|';
        return cs2;
    }

	/**
	 * 计算给定字符串中的最长Palindrome串。 O(n*n)
	 * 
	 * @param str 给定字符串
	 * @return 最长Palindrome串的起始和终止字符索引（左闭右开）
	 */
	public static Pair<Integer> find(String str){
		if (str == null) return null;
		Pair<Integer> longest = new Pair<Integer>(0, 1);
		for (int i = 0; i < str.length() - 1; i++) {
			//odd cases like 121
			Pair<Integer> palindrome = intermediatePalindrome(str, i, i);
			if (longer(palindrome, longest)) {
				longest = palindrome;
			}
			//even cases like 1221
			palindrome = intermediatePalindrome(str, i, i + 1);
			if (longer(palindrome, longest)) {
				longest = palindrome;
			}
		}
		return longest;
	}
	
	static private Pair<Integer> intermediatePalindrome(String s, int left, int right) {
		if (left > right) return null;
		while (left >= 0 && right < s.length()
				&& s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return new Pair<Integer>(left + 1, right);
	}

	/**
	 * 判断两个 {@code Pair} 的左右索引间隔
	 * @param p1
	 * @param p2
	 * @return true ：如果 {@code p1} 的索引间隔长；否则 false
	 */
	static private boolean longer(Pair<Integer> p1, Pair<Integer> p2){
		return p1.getRight() - p1.getLeft() > p2.getRight() - p2.getLeft();
	}
}
