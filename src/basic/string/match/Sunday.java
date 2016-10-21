package basic.string.match;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import util.Algorithm;
import util.NumberUtil;

/**
 * Sunday字符串匹配算法
 * @author Jingang Zhou
 *
 */
public class Sunday {
	
	/**
	 * 在给定字符串中查找指定模式串的首次出现位置
	 * @param base 给定字符串
	 * @param p 指定模式串
	 * @return 首次出现的索引，-1表示没有找到匹配字符串
	 * @throws NullPointerException 如果给定字符串或指定模式串为空
	 */
	@Algorithm(value="字符串")
	@Algorithm(value="查找", text="串匹配")
	public static int match(String base, String p){
		Objects.requireNonNull(base);
		Objects.requireNonNull(p);
		if (p.length()==0){
			return 0;
		}else if (p.length() > base.length()){
			return -1;
		}
		
		int j=0;
		while(j <= base.length()-p.length()){
			for (int i=0; i<p.length(); i++){
				if (base.charAt(j+i) != p.charAt(i)){
					char c = base.charAt(j+p.length());
					int index = p.lastIndexOf(c);
					j = j+p.length()-index;
					break;
				}else if (i==p.length()-1){
					return j;
				}
			}
		}
		return -1;
	}
	
	/**
	 * 在给定字符串中查找指定模式串的所有出现位置
	 * @param base 给定字符串
	 * @param p 指定模式串
	 * @return 所有出现的索引，空表示没有找到匹配字符串
	 * @throws NullPointerException 如果给定字符串或指定模式串为空
	 */
	@Algorithm(value="字符串")
	@Algorithm(value="查找", text="串匹配")
	public static int[] matchAll(String base, String p){
		Objects.requireNonNull(base);
		Objects.requireNonNull(p);
		if (p.length()==0){
			return new int[]{0};//按首次出现处理，否则意义不大
		}else if (p.length() > base.length()){
			return new int[]{};
		}
		
		int j=0;
		List<Integer> list = new ArrayList<>();
		while(j <= base.length()-p.length()){
			for (int i=0; i<p.length(); i++){
				if (base.charAt(j+i) != p.charAt(i)){
					char c = base.charAt(j+p.length());
					int index = p.lastIndexOf(c);
					j = j+p.length()-index;
					break;
				}else if (i==p.length()-1){
					list.add(j);
					j = j+p.length(); //与首次找到就返回的唯一区别
				}
			}
		}
		return NumberUtil.fromObjects(list.toArray(new Integer[list.size()]));
	}
}
