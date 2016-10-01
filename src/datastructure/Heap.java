package datastructure;

import java.util.ArrayList;
import static util.NumberUtil.isOdd;

public class Heap<T extends Comparable<T>> {
	//true:最小堆；false：最大堆
	private final boolean isMin;
	//借助ArrayList来存储数据
	private final java.util.List<T> list = new ArrayList<>();
	
	public Heap(boolean isMin){
		this.isMin = isMin;
	}
	
	public void add(T t){		
		list.add(t);
		int index = list.size()-1;		
		while (index > 0){
			int parent = getParentIndex(index);
			if (list.get(parent).compareTo(t) > 0 && isMin ||
					list.get(parent).compareTo(t) < 0 && !isMin){
				list.set(index, list.get(parent));
				list.set(parent, t);
				index /= 2;
			}else{
				break;
			}
		}		
	}
	
	public T pop(){
		if (list.size() > 0){
			T ret = list.get(0);
			list.set(0, list.get(list.size()-1));
			list.remove(list.size()-1);
			
			reorder(list, isMin);
			
			return ret;
		}else{
			return null;
		}
	}
	
	private static <T extends Comparable<T>> void reorder(java.util.List<T> list, boolean isMin){
		int i = 0;
		while ( 2 * i + 1 <= list.size()-1){				
			int childIndex = isMin? minIndex(list, i) : maxIndex(list, i);
			if (i == childIndex){
				break;
			}else{
				T parent = list.get(i);
				list.set(i, list.get(childIndex));
				list.set(childIndex, parent);
				i = childIndex;
			}
		}		
	}
	
	/**
	 * 获取i和其左右子树节点值最小值的索引
	 * @param list
	 * @param i
	 * @return
	 */
	private static <T extends Comparable<T>> int minIndex (java.util.List<T> list, int i){
		if (list.get(i).compareTo(list.get(2 * i + 1)) <= 0){
			if (2*i+2 <= list.size()-1 && list.get(i).compareTo(list.get(2 * i + 2)) > 0){				
				return 2 * i + 2;
			}else{
				return i;
			}
		}else{
			if (2*i+2 <= list.size()-1 && list.get(2 * i + 1).compareTo(list.get(2 * i + 2)) > 0){				
				return 2 * i + 2;
			}else{
				return 2 * i + 1;
			}
		}
	}
	
	/**
	 * 获取索引i及其左右子树节点最大值的索引
	 * @param list
	 * @param i
	 * @return
	 */
	private static <T extends Comparable<T>> int maxIndex (java.util.List<T> list, int i){
		if (list.get(i).compareTo(list.get(2 * i + 1)) >= 0){
			if (2*i+2 <= list.size() && list.get(i).compareTo(list.get(2 * i + 2)) < 0){
				return 2 * i + 2;
			}else{
				return i;
			}
		}else{
			if (2*i+2 <= list.size() && list.get(2 * i + 1).compareTo(list.get(2 * i + 2)) < 0){
				return 2 * i + 2;
			}else{
				return 2 * i + 1;
			}
		}
	}
	
	private static int getParentIndex (int childIndex){
		if (isOdd(childIndex)){
			return childIndex / 2;
		}else{
			return (childIndex - 1) / 2;
		}
	}
	
	public ArrayList<T> getList(){
		//TODO：需要改进
		return new ArrayList<>(list);
	}
	
	public static <T extends Comparable<T>> Heap<T> build(T[] ts, boolean isMin){
		//TODO
		return new Heap<T>(isMin);
	}
	
	public boolean equals(Object obj){
		if (obj instanceof Heap){
			return this.list.equals(((Heap<?>)obj).list);
		}else{
			return false;
		}
	}
}
