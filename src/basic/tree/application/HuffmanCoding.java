package basic.tree.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

import util.Algorithm;
import util.GPair;
import basic.search.BinarySearch;
import basic.sorting.QuickSorter;
import datastructure.BiTree;

/**
 * 霍夫曼编码（请参考：{@link https://zh.wikipedia.org/wiki/%E9%9C%8D%E5%A4%AB%E6%9B%BC%E7%BC%96%E7%A0%81}）
 * @author Jingang Zhou
 *
 */
public class HuffmanCoding {

	/**
	 * 根据给定频率数组构造相应的霍夫曼编码。
	 * @param frequency
	 * @return 相应频率对应的霍夫曼编码列表
	 */
	@Algorithm(value = "编码")
	public static <T> List<GPair<Integer, String>> encoding(int[] frequency){
		if (frequency == null || frequency.length == 0){
			return Collections.emptyList();
		}
		int[] freCopy = frequency.clone();
		QuickSorter.sort(freCopy);
		BiTree<Integer> root = buildTree(freCopy);
		return buildCodes(root);		
	}
	
	/**
	 * 遍历树，生成霍夫曼编码
	 * @param root
	 * @return 各频率相对应的编码列表
	 */
	private static List<GPair<Integer, String>> buildCodes(BiTree<Integer> root){
		List<GPair<Integer, String>> ret = new ArrayList<GPair<Integer,String>>();
		StringBuilder sb = new StringBuilder();
		Deque<BiTree<Integer>> stack = new ArrayDeque<BiTree<Integer>>();
		stack.offerFirst(root);
		internalBuild(ret, sb, stack);
		return ret;
	}
	
	private static void internalBuild (List<GPair<Integer, String>> list, StringBuilder sb, Deque<BiTree<Integer>> stack){
		while (!stack.isEmpty()){
			BiTree<Integer> node = stack.pollFirst();
			if (node.getLeft() != null){
				sb.append('0');
				stack.offerFirst(node.getLeft());
				internalBuild(list, sb, stack);
			}
			if (node.getRight() != null){
				sb.append('1');
				stack.offerFirst(node.getRight());
				internalBuild(list, sb, stack);
			}
			if (node.getLeft() == null && node.getRight() == null){
				list.add(new GPair<Integer, String>(node.getData(), sb.toString()));				
			}
			if (sb.length()>0){//加判定是因为访问根节点为加入任何字母，所以在出栈访问时会越界
				sb.deleteCharAt(sb.length()-1);
			}
		}
	}
	
	/**
	 * 基于给定的有序（按频率）数据，构造霍夫曼编码树
	 * @param data 给定的数据，与{@code frequency}对应
	 * @param frequency 按非降序排列的非空数组
	 * @return 霍夫曼编码树
	 * @throws NullPointerException 如果输入数组为空
	 */
	public static BiTree<Integer> buildTree(int[] frequency){
		List<BiTree<Integer>> treeList = new ArrayList<>();
		for (int i=0; i<frequency.length; i++){
			treeList.add(new BiTree<>(frequency[i]));
		}
		//每次选取开始两个（最小的）合并，将新生成的节点按序插入列表，直至最终的根节点形成
		while (treeList.size() > 1){
			BiTree<Integer> node1 = treeList.remove(0);
			BiTree<Integer> node2 = treeList.remove(0);
			BiTree<Integer> node = new BiTree<Integer>(node1.getData() + node2.getData(), node1, node2);
			treeList.add(BinarySearch.find(treeList, node, (BiTree<Integer> n1, BiTree<Integer> n2)->n1.getData()-n2.getData()), node);
		}
		return treeList.get(0);
	}

}
