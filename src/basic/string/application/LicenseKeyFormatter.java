package basic.string.application;

/**
 * Source: https://leetcode.com/problems/license-key-formatting/
 * 
 * <p>Now you are given a string S, which represents a software 
 * license key which we would like to format. The string S is 
 * composed of alphanumerical characters and dashes. The dashes 
 * split the alphanumerical characters within the string into 
 * groups. (i.e. if there are M dashes, the string is split into 
 * M+1 groups). The dashes in the given string are possibly misplaced.

 * <p>We want each group of characters to be of length K (except for 
 * possibly the first group, which could be shorter, but still must 
 * contain at least one character). To satisfy this requirement, we 
 * will reinsert dashes. Additionally, all the lower case letters in 
 * the string must be converted to upper case.

 * <p>So, you are given a non-empty string S, representing a license 
 * key to format, and an integer K. And you need to return the license 
 * key formatted according to the description above.

 * <p><b>Example 1:</b><br>
 * <code>Input: S = "2-4A0r7-4k", K = 4</br>
 * Output: "24A0-R74K"</br>
 * Explanation: The string S has been split into two parts, each part 
 * has 4 characters.</code>
 * <p><b>Example 2:</b></br>
 * <code>Input: S = "2-4A0r7-4k", K = 3</br>
 * Output: "24-A0R-74K"</br>
 * Explanation: The string S has been split into three parts, each part 
 * has 3 characters except the first part as it could be shorter as said above.</code></br>
 *<p><b>Note:</b>
 *<li>The length of string S will not exceed 12,000, and K is a positive integer.
 *<li>String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
 *<li>String S is non-empty.
 *
 * @author Jingang Zhou
 */
public class LicenseKeyFormatter {
	public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.length());
        int count = 0;
        for (int i=S.length()-1; i>=0; i--){
            char c = S.charAt(i);
            if (c >= '0' && c <= '9' || c >= 'A' && c <= 'Z'){
                sb.insert(0, c);
                count++;
            }else if (c >= 'a' && c <='z'){
                sb.insert(0, (char)(c - 32));
                count++;
            }
            if (count == K){
                sb.insert(0, '-');
                count = 0;
            }
        }
        if (sb.length() > 0 && sb.charAt(0) == '-'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
