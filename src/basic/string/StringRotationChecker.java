package basic.string;

public class StringRotationChecker {
	
	/**
	 * 判断 <b>s1</b> 是否由 <b>s2</b> 旋转而成，所谓旋转是指字符串首尾相接后的移位。例如：
	 * “abcd”可以旋转为“cdab”。
	 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
	 * 程序员面试金典）
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotatedFrom(String s1, String s2){
		if (s1 == null || s2 == null){
			return false;
		}
		if (s1.length() != s2.length()){
			return false;
		}
		
		if (isSubString(s1, s2+s2)){
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * s1是否是s2的字串
	 * mock方法
	 * @return
	 */
	static boolean isSubString(String s1, String s2){
		return s2.indexOf(s1) > -1;
	}
}
