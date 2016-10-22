package basic.tree.application;

import java.util.ArrayList;
import java.util.List;

import util.Algorithm;
import datastructure.BiTree;

public class PathForGivenSumFromRoot {
	
	/**
	 * 从二叉树的根节点开始深度遍历找到和为指定数的所有路径
	 * @param root 二叉树的根节点，所以节点值都为正整数
	 * @param sum 指定的和数，正整数
	 * @return 所有从根节点开始的满足要求的路径，路径按从左到右的顺序
	 */
	@Algorithm("树")
	@Algorithm("迭代")
	public static List<List<BiTree<Integer>>> findPath(BiTree<Integer> root, int sum){
		List<List<BiTree<Integer>>> paths = new ArrayList<List<BiTree<Integer>>>();
		List<BiTree<Integer>> list = new ArrayList<BiTree<Integer>>();

		findPath(paths, list, root, 0, sum);
		return paths;
	}
	
	/**
	 * 从二叉树的根节点开始深度遍历找到和为指定数的所有路径
	 * @param found 用于标识是否存在一条路径
	 * @param list 当前遍历路径
	 * @param node 当前的节点
	 * @param currentSum 当前路径和
	 * @param sum 指定的和数
	 */
	private static void findPath(List<List<BiTree<Integer>>> paths, List<BiTree<Integer>> list, BiTree<Integer> node, int currentSum, int sum){		
		if (sum == currentSum + node.getData()){
			list.add(node);
			addPath(paths, list);
		}else if (sum > currentSum + node.getData()){
			list.add(node);
			currentSum += node.getData();
			if (node.getLeft()!= null){
				findPath(paths, list, node.getLeft(), currentSum, sum);
				if (node.getRight()!=null){
					findPath(paths, list, node.getRight(), currentSum, sum);
				}
			}
		}//否则不用继续从下遍历了，因为都是正整数，当前节点如果查出范围，下一层的节点就更超了
		list.remove(node);
	}
	
	private static void addPath(List<List<BiTree<Integer>>> results, List<BiTree<Integer>> path) {
		List<BiTree<Integer>> result = new ArrayList<>();
		for (int i=0; i<path.size(); i++){
			result.add(path.get(i));
		}
		results.add(result);
	}
}
