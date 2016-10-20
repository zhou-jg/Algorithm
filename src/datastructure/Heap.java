package datastructure;

import static util.NumberUtil.isOdd;

import java.util.ArrayList;

import util.Algorithm;

public class Heap<T extends Comparable<T>> {
	//true:最小堆；false：最大堆
	private final boolean isMin;
	//借助ArrayList来存储数据
	private final java.util.List<T> list = new ArrayList<>();
	
	public Heap(boolean isMin){
		this(null, isMin);
	}
	
	/**
	 * 根据给定数组创建堆。采用Robert Floyd算法，O(n)时间。
	 * @param data 
	 * @param isMin true：小堆；false：大堆
	 */
	@Algorithm(value="堆", text="建堆")
	public Heap(T[] data, boolean isMin){
		this.isMin = isMin;
		if (data != null){
			for (T t : data){
				list.add(t);
			}
			for (int i=data.length/2-1; i>=0; i--){
				reorder(list, i, isMin);
			}
		}
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
		reorder(list, 0, isMin);
	}
	
	//节点下滤
	private static <T extends Comparable<T>> void reorder(java.util.List<T> list, int index, boolean isMin){
		int i = index;
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
	
	public boolean equals(Object obj){
		if (obj instanceof Heap){
			return this.list.equals(((Heap<?>)obj).list);
		}else{
			return false;
		}
	}
}
