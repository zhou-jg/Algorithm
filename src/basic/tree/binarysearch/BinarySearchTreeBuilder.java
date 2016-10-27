package basic.tree.binarysearch;

import datastructure.BiTree;
import util.Algorithm;

public class BinarySearchTreeBuilder {
	
	/**
	 * 根据给定的点掉升序数组，构造一颗高度最小的二叉查找树。
	 * 为使高度最小，要尽量左右均分，所以以数组的中间节点为树根，以此递归创建节点。
	 * @param array 单调升序数组
	 * @return
	 */
	@Algorithm
	public static <T extends Comparable<T>> BiTree<T> build(T[] array){
		return internalBuild(array, 0, array.length-1);
	}
	
	private static <T extends Comparable<T>> BiTree<T> internalBuild(T[] array, int start, int end){
		int length = end - start;
		if (length == 0){
			return new BiTree<T>(array[start], null, null);
		}else if (length == 1){
			return new BiTree<T>(array[end], new BiTree<T>(array[start], null, null), null);
		}else if (length == 2){
			return new BiTree<T>(array[start+1], 
									new BiTree<T>(array[start], null, null), 
									new BiTree<T>(array[end], null, null));
		}else{
			return new BiTree<T>(array[(start+end)/2], 
									internalBuild(array, start, (start+end)/2 - 1), 
									internalBuild(array, (start+end)/2 + 1, end));
		}
	}
}
