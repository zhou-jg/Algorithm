package basic.graph;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

/**
 * Dijkstra最短路径算法
 * @author Jingang Zhou
 *
 * @param <V> 节点数据类型
 * @param <E> 边数据类型
 */
public class DijkstraShortestPath<V, E> extends BestFirstTraverser<V, E> {

	public DijkstraShortestPath(Graph<V, E> g) {
		super(g);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void updateDistanceAfter(Vertex<V> vb) {
		for(Edge<?> e : vb.outEdges()){
			Vertex<?> v = e.getHead();
			if (v.getDistance() > vb.getDistance() + (Integer) e.getData()){
				v.setDistance(vb.getDistance() + (Integer) e.getData());
				((Vertex<V>)v).setParent(vb);
			}
		}
	}

}
