package basic.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.Algorithm;
import util.NumberUtil;
import util.StringUtil;

public class StringPermutation {
	/**
	 * 输出给定字符串的所有排列组合
	 * @param str 不含重复字符
	 * @return
	 */
	@Algorithm(value = "递归")
	public static String[] computePermutations(String str){
		Objects.requireNonNull(str);
		String[] result = new String[NumberUtil.factorial(str.length())];
		internalCompute(result, str);
		return result;
	}
	
	private static void internalCompute(String[] result, String str){
		if (str.length() == 1){
			result[0] = str;
		}else{
			internalCompute(result, str.substring(0, str.length() - 1));			
			int i = 0;
			char toInserted = str.charAt(str.length() - 1);			
			List<String> orignals = new ArrayList<>();
			//在原有元素的开头插入新字母
			while (result[i] != null){
				orignals.add(result[i]);
				result[i] = StringUtil.insertAt(result[i], 0, toInserted);	
				i++;
			}
			//扩充数组内容，构造新字符串
			for (String orignal : orignals) {
				for (int j=1; j<=orignal.length(); j++) {
					result[i++] = StringUtil.insertAt(orignal, j, toInserted);
				}
			}
		}
	}
}
