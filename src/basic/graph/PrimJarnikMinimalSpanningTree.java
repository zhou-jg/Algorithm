package basic.graph;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

/**
 * Prim-Jarnik最小生成树算法。
 * 树边可以通过查看图中每条边的类型得出；树路径可以通过每个节点的前趋父亲得出。
 * @author Jingang Zhou
 *
 * @param <V> 节点数据类型
 */
public class PrimJarnikMinimalSpanningTree<V> extends BestFirstTraverser<V, Integer>{

	public PrimJarnikMinimalSpanningTree(Graph<V, Integer> g) {
		super(g);
	}

	@Override
	protected void updateDistanceAfter(Vertex<V> vb) {
		for (Edge<?> e : vb.outEdges()){
			int weight = ((Integer) e.getData()).intValue();
			@SuppressWarnings("unchecked")
			Vertex<V> v = (Vertex<V>)e.getHead();
			if (v.getDistance() > weight){
				v.setDistance(weight);
				v.setParent(vb);
			}
		}
	}

}
