package basic.graph;

import java.util.Iterator;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.EdgeType;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;
import basic.graph.datastructure.VertexStatus;

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

	@Override
	protected Vertex<V> bestVertex() {
		//初始最佳指标
		int bestValue = Integer.MAX_VALUE;
		Vertex<V> bestVertex = null;
		for (Iterator<Vertex<V>> it = g.vertices(); it.hasNext();){
			Vertex<V> v = it.next();
			if (v.getStatus() == VertexStatus.UNDISCOVERED){
				if (v.getDistance() < bestValue){
					bestValue = v.getDistance();
					bestVertex = v;
				}
			}
		}
		if (bestVertex != null && bestVertex.getParent() != null){
			bestVertex.getParent().edgeTo(bestVertex).setType(EdgeType.TREE);
		}
		return bestVertex;
	}

}
