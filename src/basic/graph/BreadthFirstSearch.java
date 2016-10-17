package basic.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import datastructure.GNode;
import util.Algorithm;

/**
 * 图广度优先遍历
 * @author Jingang Zhou
 *
 */
public class BreadthFirstSearch {
	
	/**
	 * 从图的某个起始节点开始遍历
	 * @param root
	 */
	@Algorithm("图")
	@Algorithm("遍历")
	public static <T> void traverse(GNode<T> root){
		Set<GNode<T>> visited = new HashSet<>();
		Queue<GNode<T>> queue = new LinkedList<>();
		
		queue.offer(root);
		while (!queue.isEmpty()){
			GNode<T> node = queue.poll();
			if (!visited.contains(node)){
				System.out.println(node.getData());
				for (GNode<T> adjacent : node.getAdjacents()){
					if (!visited.contains(adjacent)){
						queue.offer(adjacent);
					}
				}
				visited.add(node);
			}
		}
	}
	
	public static void main(String[] args){
		traverse(new GNode<Integer>(1).
					addAdjacent(new GNode<Integer>(2).
							addAdjacent(new GNode<Integer>(3))).
					addAdjacent(new GNode<Integer>(4).
							addAdjacent(new GNode<Integer>(5))));
		//output: 1, 2, 4, 3, 5
	}
}
