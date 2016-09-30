package basic.list;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import util.Algorithm;

/**
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class DuplicateElementRemover {

	/**
	 * 借住Set/散列表删除列表中重复元素。
	 * @param list
	 */
	@Algorithm
	public static <T> void deleteDuplicates(List<T> list){
		Objects.requireNonNull(list);
		//借助Set来过滤重复元素
		Set<T> set = new HashSet<>();
		int i = 0;
		while (i < list.size()){
			T ele = list.get(i);
			if (set.contains(ele)) {
				list.remove(i);
			}else{
				set.add(ele);
				i++;
			}
		}
	}
	
	/**
	 * 不使用临时缓冲区删除列表中的重复元素
	 * @param list
	 */
	public static <T> void deleteDuplicates2(List<T> list){
		Objects.requireNonNull(list);
		int i=0, j;
		while (i < list.size()){
			T ele = list.get(i);
			j = i + 1;
			while (j < list.size()){
				if (ele.equals(list.get(j))){
					list.remove(j);
				}else{
					j++;
				}
			}
			i++;
		}
	}
}
