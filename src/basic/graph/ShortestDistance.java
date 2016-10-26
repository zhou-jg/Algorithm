package basic.graph;

import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

/**
 * 求某个指定节点到其它节点的最短路径（边数）
 * @author Jingang Zhou
 *
 * @param <V> 节点数据类型
 * @param <E> 边数据类型
 */
public class ShortestDistance<V, E> extends BreadthFirstTraverser<V, E>{

	public ShortestDistance(Graph<V, E> g) {
		super(g);
	}

	/**
	 * @param v 当前访问的节点
	 * @param info v的前趋
	 */
	@Override
	protected Object visit(Vertex<V> v, Object info) {
		if (info == null){
			v.setDistance(0);
		}else{
			v.setDistance(((Vertex<?>)info).getDistance() + 1);
		}
		return null;
	}

	/**
	 * 求指定节点到图中其它节点的最短距离。算法结束后，各节点的{@code distance}属性记录
	 * 了到指定节点的最短距离。
	 * @param 指定节点
	 */
	@Override
	public Object algorithm(Vertex<V> v) {
		reset();
		traverse(v, null);		
		return null;
	}

}
