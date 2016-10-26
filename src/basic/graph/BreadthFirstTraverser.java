package basic.graph;

import java.util.ArrayDeque;
import java.util.Queue;

import util.Algorithm;
import basic.graph.datastructure.Edge;
import basic.graph.datastructure.EdgeType;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;
import basic.graph.datastructure.VertexStatus;

/**
 * 图广度优先遍历
 * 参考：邓俊辉 著《数据结构与算法（Java 描述）》
 * @author Jingang Zhou
 *
 */
public abstract class BreadthFirstTraverser extends AbstractTraverser{
	
	public BreadthFirstTraverser(Graph g) {
		super(g);
	}

	/**
	 * 从图的某个起始节点开始广度优先遍历
	 * @param v 指定的节点
	 */
	@Algorithm("图")
	@Algorithm(value="遍历", text="广度优先")
	@Override
	protected Object traverse(Vertex<?> v, Object info){
		if (v.getStatus() != VertexStatus.UNDISCOVERED){
			return null;
		}
		Queue<Vertex<?>> queue = new ArrayDeque<Vertex<?>>();
		
		v.setStatus(VertexStatus.DISCOVERED);
		queue.offer(v);
		visit(v, info);
		
		while(!queue.isEmpty()){
			Vertex<?> u = queue.poll();
			for(Edge<?> edge : u.outEdges()){
				Vertex<?> adjacent = edge.getHead();
				if (adjacent.getStatus() == VertexStatus.UNDISCOVERED){
					edge.setType(EdgeType.TREE);
					adjacent.setStatus(VertexStatus.DISCOVERED);
					queue.offer(adjacent);
					visit(adjacent, info);
				}else{
					edge.setType(EdgeType.CROSS);
				}
			}
			u.setStatus(VertexStatus.VISITED);
		}
		
		return null;		
	}

}
