package basic.tree.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import datastructure.BiTree;
import util.Algorithm;

/**
 * 查找树中某条路径上节点值的和等于给定值的所有路径。该路径可以不用从根节点开始。
 * @author Jingang Zhou
 *
 */
public class PathFinderForGivenSum {
	
	@Algorithm
	public static List<List<BiTree<Integer>>> find(BiTree<Integer> root, int sum){
		if (root == null){
			return Collections.emptyList();
		}
		List<List<BiTree<Integer>>> results = new ArrayList<>();
		List<BiTree<Integer>> path = new ArrayList<>();
		path.add(root);
		internalFind(results, path, root, sum, 0);
		return results;
	}
	
	private static void internalFind(List<List<BiTree<Integer>>> results, List<BiTree<Integer>> path, BiTree<Integer> node, int sum, int level){		
		int tmp = 0;
		for(int i=level; i>=0; i--){
			tmp += path.get(i).getData();
			if (tmp == sum){		
				addPath(results, path, i, level);				
			}
		}
		if (node.getLeft() != null){
			path.add(node.getLeft());
			internalFind(results, path, node.getLeft(), sum, level+1);
		}
		if (node.getRight() != null){
			path.add(node.getRight());
			internalFind(results, path, node.getRight(), sum, level+1);
		}
		path.remove(path.size()-1);
	}

	private static void addPath(List<List<BiTree<Integer>>> results, List<BiTree<Integer>> path, int index, int level) {
		List<BiTree<Integer>> result = new ArrayList<>();
		for (int i=index; i<=level; i++){
			result.add(path.get(i));
		}
		results.add(result);
	}
}
