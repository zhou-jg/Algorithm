package basic.graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import util.Algorithm;
import datastructure.GNode;

/**
 * 深度优先搜索
 * @author Jingang Zhou
 *
 */
public class DepthFirstSearch {
	
	@Algorithm
	public static <T> void traverse(GNode<T> root){
		Deque<GNode<T>> stack = new ArrayDeque<GNode<T>>();
		Set<GNode<T>> visited = new HashSet<>();
		
		stack.offerFirst(root);
		
		internalRecursive(stack, visited);
	}
	
	private static <T> void internalRecursive(Deque<GNode<T>> stack, Set<GNode<T>> visited){
		while (!stack.isEmpty()){
			GNode<T> node = stack.pollFirst();
			if (!visited.contains(node)){
				System.out.println(node.getData());
				visited.add(node);
				for (GNode<T> adjacent : node.getAdjacents()){
					if (!visited.contains(adjacent)){
						stack.offerFirst(adjacent);
						internalRecursive(stack, visited);
					}
				}
			}
		}
	}
	
	public static void main(String[] args){
		traverse(new GNode<Integer>(1).
						addAdjacent(new GNode<Integer>(2).
										addAdjacent(new GNode<Integer>(3)).
										addAdjacent(new GNode<Integer>(4))).
						addAdjacent(new GNode<Integer>(5)));
		//output: 1, 2, 3, 4, 5
	}
}
