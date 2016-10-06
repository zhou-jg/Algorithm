package basic.tree.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import datastructure.BiTree;
import util.Algorithm;

public class DepthList {

	/**
	 * 根据给定的二叉树，创建含有某一深度上所有节点的链表。如果树的深度为D，则会
	 * 创建D个链表。
	 * 思路：通过广度优先遍历，将每个节点的深度信息在进队时保存起来。等遍历完毕，
	 * 基于保存的节点深度信息构造返回链表集合。
	 * @param root 二叉树的根节点
	 * @return 包含树不同深度的节点链表Map
	 */
	@Algorithm
	public static Map<Integer, List<BiTree<?>>> build(BiTree<?> root){
		//对树进行广度优先遍历
		Deque<BiTree<?>> queue = new ArrayDeque<>();
		//存储各个节点的深度
		Map<BiTree<?>, Integer> heights = new HashMap<>();
		
		//初始化
		queue.offerLast(root);
		heights.put(root, 1);
		
		while (!queue.isEmpty()){
			BiTree<?> node = queue.pollFirst();
			int height = heights.get(node);
			BiTree<?> child = node.getLeft();
			if (child != null){
				queue.offerLast(child);
				heights.put(child, height + 1);
			}
			child = node.getRight();
			if (child != null){
				queue.offerLast(child);
				heights.put(child, height + 1);
			}
		}
		
		//构造结果链表
		Map<Integer, List<BiTree<?>>> ret = new HashMap<>();
		for (BiTree<?> key : heights.keySet()){
			int height = heights.get(key);
			if (!ret.containsKey(height)){
				ret.put(height, new ArrayList<>());
			}
			ret.get(height).add(key);
		}
		
		return ret;
	}
}
