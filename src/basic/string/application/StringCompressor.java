package basic.string.application;

import java.util.Objects;

import util.Algorithm;

public class StringCompressor {

	/**
	 * 压缩一个字符串，例如，输入<b>"aaabbc"</b>，则输出<b>"a3bbc"，
	 * 即用<b>a</b>出现的次数来代替其它的<b>a</b>，但前提是 可以让字符串
	 * 长度变短，否则不予替换。
	 * 
	 * @param str 不允许出现数字
	 * @return 压缩后的字符串
	 */
	@Algorithm
	public static String compress(String str) {
		Objects.requireNonNull(str);
		if (str.length() <= 2){
			return str;
		}else{			
			char c = str.charAt(0);
			int cNum = 1;
			StringBuilder sb = new StringBuilder();
			
			for (int i= 1; i<str.length(); i++){
				if (c == str.charAt(i)){
					cNum++;
				}else{
					if (cNum > 2) {
						sb.append(c).append(cNum);
					}else{
						for (int j=0; j<cNum; j++){
							sb.append(c);
						}
					}
					c = str.charAt(i);
					cNum = 1;
				}
			}
			sb.append(c).append(cNum);
			
			if (sb.length() >= str.length()) {
				return str;
			}else{
				return sb.toString();
			}
		}
	}

}
