package basic.graph;

import java.util.ArrayDeque;
import java.util.Deque;

import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

/**
 * 基于深度优先算法，求解某个节点的可达分量
 * @author Jingang Zhou
 * @param 节点数据类型
 * @param 边数据类型
 */
public class ReachableVertices<V, E> extends DepthFirstTraverser<V, E> {

	public ReachableVertices(Graph<V, E> g) {
		super(g);
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object visit(Vertex<V> v, Object info) {
		((Deque<Vertex<?>>) info).offerFirst(v);
		return null;
	}

	/**
	 * 获取指定节点的可达分量
	 * @param v 指定节点
	 * @return 深度遍历形成的可达分量构成的栈 
	 */
	@Override
	public Deque<Vertex<?>> algorithm(Vertex<V> v) {
		reset();
		Deque<Vertex<?>> stack = new ArrayDeque<Vertex<?>>();
		traverse(v, stack);
		return stack;
	}

}
