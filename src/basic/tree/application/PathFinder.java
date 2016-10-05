package basic.tree.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import datastructure.GNode;

public class PathFinder {
	
	/**
	 * 给定有向图中的两个节点，判断它们之间是否存在一条通路。
	 * 利用有向图的广度优先遍历算法。
	 * @param soruce
	 * @param target
	 * @return
	 */
	public static boolean find(GNode<?> source, GNode<?> target){
		Set<GNode<?>> visited = new HashSet<>();
		Deque<GNode<?>> stack = new ArrayDeque<>();
		stack.offerFirst(source);
		while (!stack.isEmpty()){
			GNode<?> node = stack.pollFirst();
			visited.add(node);
			if (node == target){				
				return true;
			}else{
				for (GNode<?> adjacent : node.getAdjacents()){
					if (!visited.contains(adjacent)){
						stack.offerFirst(adjacent);
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 在有向图的给定两个节点之间找出一条通路。
	 * 思路是在广度优先遍历时，纪录下每个节点的路径信息。但该方法会占用不少内存。
	 * @param source
	 * @param target
	 * @return 由节点表示的通路，如果没用通路，则返回空列表
	 */
	public static List<GNode<?>> findPath(GNode<?> source, GNode<?> target){
		Set<GNode<?>> visited = new HashSet<>();
		Deque<GNode<?>> stack = new ArrayDeque<>();
		//纪录每个节点的访问路径
		Map<GNode<?>, List<GNode<?>>> paths = new HashMap<>();
		
		stack.offerFirst(source);
		List<GNode<?>> head = new ArrayList<>();
		head.add(source);
		paths.put(source, head);
		
		while (!stack.isEmpty()){
			GNode<?> node = stack.pollFirst();
			visited.add(node);
			if (node == target){		
				return paths.get(node);
			}else{
				for (GNode<?> adjacent : node.getAdjacents()){
					List<GNode<?>> pathParent = paths.get(node);
					if (!visited.contains(adjacent)){						
						stack.offerFirst(adjacent);
						//纪录要访问节点的路径
						List<GNode<?>> path = new ArrayList<>(pathParent);
						path.add(adjacent);
						paths.put(adjacent, path);
					}
				}
			}
			/*
			 * 可以在路径Map中删除node的路径信息
			 * paths.remove(node);
			 */
		}
		return Collections.emptyList();
	}
}
