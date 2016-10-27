package basic.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.Pair;
import basic.graph.datastructure.AdjacentMatrixGraph;

/**
 * 基于邻接矩阵的Floyd-Warshall多源路径最短距离算法。
 * @author Jingang Zhou
 *
 */
public class FloydWarshallShortestPath<V> extends AdjacentMatrixGraph<V>{	
	protected Map<Pair<V>, List<V>> paths;
	
	public FloydWarshallShortestPath(V[] vertices, int[][] distance){
		super(vertices);
		reset(distance);
	}
	
	/**
	 * 计算全部节点间的最短路径。最短路径的值存储在图邻接矩阵中，
	 * 可以通过{@code getDistance(V, V)}来获得。
	 * @return 全部节点间的最短路径。
	 */
	public Map<Pair<V>, List<V>> buildPath(){
		//路径
		int[][] next = initNext();
		
		for (int i=0; i<vertex.length; i++){
			for (int j=0; j<vertex.length; j++){				
				for (int k=0; k<vertex.length; k++){
					if (distance[k][i] == Integer.MAX_VALUE ||
							distance[i][j] == Integer.MAX_VALUE) continue;
					
					if (distance[k][j] > distance[k][i] + distance[i][j]){
						distance[k][j] = distance[k][i] + distance[i][j];
						//记录路径					
						next[k][j] = next[k][i];
					}
				}
			}
		}
		//构造路径
		transform(next);
		return paths;
	}
	
	private int[][] initNext(){
		int[][] next = new int[vertex.length][vertex.length];
		for(int i=0; i<next.length; i++){
			for(int j=0; j<next.length; j++){
				next[i][j]= distance[i][j] == Integer.MAX_VALUE? Integer.MAX_VALUE : j;
			}
		}
		return next;
	}
	
	/**
	 * 根据邻接路径构造真正的最短路径表现形式
	 * @param next
	 */
	protected void transform(int[][] next){
		paths = new HashMap<Pair<V>, List<V>>();
		for (int i=0; i<vertex.length; i++){
			for (int j=0; j<vertex.length; j++){
				if (next[i][j] == Integer.MAX_VALUE){
					paths.put(new Pair<V>(vertexAt(i), vertexAt(j)), Collections.emptyList());
					continue;
				}
				List<V> list = new ArrayList<V>();
				list.add(vertexAt(i));
				int m=i, n=j;
				while(m!=n){
					m=next[m][n];
					list.add(vertexAt(m));
				}
				paths.put(new Pair<V>(vertexAt(i), vertexAt(j)), list);
			}
		}
	}
	
	/**
	 * 输出指定节点间的最短路径
	 * @param start 源节点
	 * @param end 目标节点
	 * @return 指定节点间的最短路径
	 */
	public List<V> getPath(V start, V end){
		if (paths == null){
			return null;
		}
		return paths.get(new Pair<V>(start, end));
	}
	
	/**
	 * 获得全部节点间的最短路径
	 * @return
	 */
	public Map<Pair<V>, List<V>> getPaths(){
		return paths;
	}
	
	public void reset(int[][] distance){
		this.distance = distance.clone();
	}
}
