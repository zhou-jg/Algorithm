package basic.graph;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.EdgeType;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;
import basic.graph.datastructure.VertexStatus;

/**
 * 深度优先遍历
 * 参考：邓俊辉 著《数据结构与算法（Java 描述）》
 * @author Jingang Zhou
 *
 */
public abstract class DepthFirstTraverser extends AbstractTraverser{
	//遍历过程中的时钟
	protected int clock = 0;
	
	public DepthFirstTraverser(Graph g) {
		super(g);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object traverse(Vertex<?> v, Object info){
		if (v.getStatus() != VertexStatus.UNDISCOVERED) {
			return null;
		}
		v.setDStamp(clock++);
		v.setStatus(VertexStatus.DISCOVERED);
		visit(v, info);
		for (Edge<?> edge : v.outEdges()){
			Vertex<?> u = edge.getHead();
			switch (u.getStatus()) {
			case UNDISCOVERED:
				edge.setType(EdgeType.TREE);
				traverse(u, info);
				break;
			case DISCOVERED:
				edge.setType(EdgeType.BACKWORD);
				break;
			default://VISITED
				if (u.getDStamp() < v.getDStamp()){
					edge.setType(EdgeType.CROSS);
				}else{
					edge.setType(EdgeType.FORWARD);
				}
				break;
			}
		}
		v.setFStamp(clock++);
		v.setStatus(VertexStatus.VISITED);
		return null;
	}
	
	
}
