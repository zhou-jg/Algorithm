package basic.graph.application;

import java.util.HashSet;
import java.util.Set;

import basic.graph.DepthFirstTraverser;
import basic.graph.datastructure.Edge;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

/**
 * 在给定图中判断以给定节点开始的深度遍历路径中是否含有环。
 * @author Jingang Zhou
 *
 * @param <V>
 * @param <E>
 */
public class CircleFinder<V, E> extends DepthFirstTraverser<V, E> {

	public CircleFinder(Graph<V, E> g) {
		super(g);
	}

	@Override
	protected Object visit(Vertex<V> v, Object info) {
		return null;
	}

	//程序入口
	@Override
	public Boolean algorithm(Vertex<V> v) {
		Set<Vertex<V>> set = new HashSet<Vertex<V>>();
		return traverse(v, set);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Boolean traverse(Vertex<V> v, Object info) {
		Set<Vertex<V>> set = (Set<Vertex<V>>) info;
		if (set.contains(v)){
			return true;
		}else{
			set.add(v);
		}
		
		for (Edge<?> e : v.outEdges()){
			if (traverse((Vertex<V>) e.getHead(), info)){
				return true;
			}
		}
		return false;
	}
}
