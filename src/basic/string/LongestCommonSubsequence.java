package basic.string;

import util.Algorithm;
import util.StringUtil;

/**
 * 利用动态规划寻找两个字符串的最大公共子串
 * （https://en.wikipedia.org/wiki/Longest_common_subsequence_problem）。
 * 
 * @author Jingang Zhou
 */
public class LongestCommonSubsequence {
	/**
	 * 寻找给定字符串的最大公共子串
	 * @param str1 给定字符串
	 * @param str2 给定字符串
	 * @return 最长公共子串
	 */
	@Algorithm("字符串")
	@Algorithm("动态规划")
	public static String find(String str1, String str2){
		if (!StringUtil.isValid(str1) || !StringUtil.isValid(str2)){
			return "";
		}
		
		char[] c1 = str1.toCharArray();
		char[] c2 = str2.toCharArray();
		int lc1 = c1.length, lc2 = c2.length;
		//构造中间结果存储
		int[][] LCS = new int[lc1+1][lc2+1];
		
		for (int i=0; i<=lc1; i++){
			LCS[i][0] = 0;
		}
		for (int i=0; i<=lc2; i++){
			LCS[0][i] = 0;
		}
		
		for (int i=1; i<=lc1; i++){
			for (int j=1; j<=lc2; j++) {
				if (c1[i-1] == c2[j-1]){
					LCS[i][j] = LCS[i-1][j-1] + 1;
				}else{
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		StringBuilder sb = new StringBuilder(Math.min(lc1, lc2));
		int s = LCS[lc1][lc2];
		while(s!=0){
			if (LCS[lc1-1][lc2-1] == s){
				lc1--;
				lc2--;
			}else if (LCS[lc1-1][lc2] == s){
				lc1--;
			}else if (LCS[lc1][lc2-1] == s){
				lc2--;
			}else{
				sb.insert(0, c1[lc1-1]);
				lc1--;
				lc2--;
				s = LCS[lc1][lc2];
			}
		}
		
		return sb.toString();
	}
}
