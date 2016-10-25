package basic.graph;

import java.util.Iterator;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.EdgeType;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;
import basic.graph.datastructure.VertexStatus;

public abstract class AbstractTraverser {

	protected final Graph g;
	public AbstractTraverser(Graph g){
		this.g = g;
	}
	
	/**
	 * 将图中各节点的标志、各边的分类复位
	 */
	protected void reset(){
		for(Iterator<Vertex<?>> it = g.vertices(); it.hasNext();){
			Vertex<?> v = it.next();
			v.setStatus(VertexStatus.UNDISCOVERED);
			v.setDistance(Integer.MAX_VALUE);
		}
		for(Iterator<Edge<?>> it = g.edges(); it.hasNext();){
			it.next().setType(EdgeType.UNKNOWN);
		}
	}
	
	/**
	 * 遍历过程中对节点的具体访问操作，服务于具体的{@link AbstractTraverser#algorithm(Vertex, Object)}
	 * @param v
	 * @param info
	 * @return
	 */
	protected abstract Object visit(Vertex<?> v, Object info);
	
	/**
	 * 基于遍历实现的其它算法的模板
	 * @param v 起始节点
	 * @return 算法特定的结果类型
	 */
	public abstract Object algorithm(Vertex<?> v);
	
	/**
	 * 从节点 v 开始做遍历
	 * @param v 起始节点
	 * @param info 其它输入输出参数
	 * @return
	 */
	protected abstract Object traverse(Vertex<?> v, Object info);
}
