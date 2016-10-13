package basic.search;

import java.util.Comparator;
import java.util.List;

import util.Algorithm;

/**
 * 二分查找
 * @author Jingang Zhou
 *
 */
public class BinarySearch {

	/**
	 * 查找给定值在有序列表中的位置，插入后该列表仍为有序。
	 * 当前的实现为升序。
	 * @param list 有序列表
	 * @param t 给定值
	 * @return 给定值在列表的有序位置
	 */
	@Algorithm(value="search")
	public static <T extends Comparable<T>> int find(List<T> list, T t){
		if (list == null){
			return -1;
		}
		if (list.size() == 0){
			return 0;
		}
		
		return internalFind(list, t, 0, list.size()-1);		
	}
	
	private static <T extends Comparable<T>> int internalFind(List<T> list, T t, int begin, int end){
		if (begin > end){
			return begin;
		}
		int index = (begin+end)/2;
		T other = list.get(index);
		if (t.compareTo(other) == 0){
			return index;
		}else if (t.compareTo(other) < 0){
			return internalFind(list, t, begin, index-1);
		}else{
			return internalFind(list, t, index+1, end);
		}
	}
	
	/**
	 * 根据给定的 {@code java.util.Comparator} 来定序。
	 * 实现为升序。
	 * @param list 有序列表
	 * @param t 给定值
	 * @return 给定值在列表的有序位置
	 */
	@Algorithm(value="search")
	public static <T> int find(List<T> list, T t, Comparator<T> c){
		if (list == null){
			return -1;
		}
		if (list.size() == 0){
			return 0;
		}
		
		return internalFind(list, t, c, 0, list.size()-1);		
	}
	
	private static <T> int internalFind(List<T> list, T t, Comparator<T> c, int begin, int end){
		if (begin > end){
			return begin;
		}
		int index = (begin+end)/2;
		T other = list.get(index);
		if (c.compare(t, other) == 0){
			return index;
		}else if (c.compare(t, other) < 0){
			return internalFind(list, t, c, begin, index-1);
		}else{
			return internalFind(list, t, c, index+1, end);
		}
	}
}
