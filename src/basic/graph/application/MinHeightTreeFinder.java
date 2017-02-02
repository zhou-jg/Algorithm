package basic.graph.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Source : https://leetcode.com/problems/minimum-height-trees/
 * 
 * <p>For a undirected graph with tree characteristics, we can choose any node 
 * as the root. The result graph is then a rooted tree. Among all possible rooted 
 * trees, those with minimum height are called minimum height trees (MHTs). Given 
 * such a graph, write a function to find all the MHTs and return a list of their 
 * root labels.
 *
 * <p><b>Format</b><br>
 * The graph contains n nodes which are labeled from 0 to n - 1. You will be given 
 * the number n and a list of undirected edges (each edge is a pair of labels).
 *
 * <p>You can assume that no duplicate edges will appear in edges. Since all edges 
 * are undirected, [0, 1] is the same as [1, 0] and thus will not appear together 
 * in edges.
 * 
 * <p><b>Example 1:</b>
 * <br>Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]<br>
 *         0<br>
 *         |<br>
 *         1<br>
 *        / \<br>
 *       2   3<br>
 *       return [1]
 *       
 * <p><b>Example 2:</b>
 * 
 * <p>Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]<br>

     0  1  2
      \ | /
        3
        |
        4
        |
        5
return [3, 4]

 * @author Jingang Zhou
 *
 */
public class MinHeightTreeFinder {
	/**
	 * 思路：从所有的叶子节点开始遍历，找到最后遍历仅剩的一个或两个节点，就是树根。
	 * 参考：http://52.20.106.37/minimum-height-trees/
	 * @param n
	 * @param edges
	 * @return
	 */
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 0){
            return Collections.emptyList();
        }else if (n == 1){
            return Collections.singletonList(0);
        }
        //构造节点度
        Map<Integer, Set<Integer>> degs = new HashMap<>(n);
        for (int i=0; i<n; i++){
            degs.put(i, new HashSet<Integer>());
        }
        for (int[] edge : edges){
            degs.get(edge[0]).add(edge[1]);
            degs.get(edge[1]).add(edge[0]);
        }
        //找出叶子节点
        List<Integer> leaves = new ArrayList<>();
        for (int i=0; i<n; i++){
            if (degs.get(i).size()==1){
                leaves.add(i);
            }
        }
        
        while (n > 2){
            n -= leaves.size();
            for (int leave : leaves){
                int k = degs.get(leave).iterator().next();
                degs.get(k).remove(leave);
                degs.remove(leave);
            }            
            leaves.clear();
            for (int i : degs.keySet()){
                if (degs.get(i).size() == 1){
                    leaves.add(i);
                }else if (degs.get(i).size() == 0){
                	return Collections.singletonList(i);
                }
            }
        }
        
        return leaves;
	}
}
