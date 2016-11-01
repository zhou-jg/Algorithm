package util;

public class StringUtil {
	public static String insertAt(String base, int index, char c){
		if (index < 0 || 
				base != null && index > base.length() ||
				base == null && index > 0){
			throw new IllegalArgumentException("参数错误");
		}
		
		if (base == null){
			return String.valueOf(c);
		}else{
			if (index > 0 && index < base.length()){
				return base.substring(0, index) + String.valueOf(c) + base.substring(index);
			}else if (index == 0){
				return String.valueOf(c) + base;
			}else {
				return base + String.valueOf(c);
			}
		}
	}
	
	public static boolean isValid(String str){
		return str != null && str.length() > 0;
	}
}
