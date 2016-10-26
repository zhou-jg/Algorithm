package basic.graph;

import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;
import basic.graph.datastructure.VertexStatus;

/**
 * 最佳优先遍历，在遍历过程中，不断调整到未访问节点集的距离权重，挑选最优的加入待访问节点集。
 * 参考：邓俊辉 著《数据结构与算法（Java 描述）》
 * @author Jingang Zhou
 */
public abstract class BestFirstTraverser extends AbstractTraverser {

	public BestFirstTraverser(Graph g) {
		super(g);
	}

	@Override
	protected Object visit(Vertex<?> v, Object info) {
		v.setStatus(VertexStatus.VISITED);
		return null;
	}

	@Override
	public Object algorithm(Vertex<?> v) {
		reset();
		traverse(v, null);
		return null;
	}

	@Override
	protected Object traverse(Vertex<?> v, Object info) {
		if (v.getStatus() != VertexStatus.UNDISCOVERED){
			return null;//跳过已访问节点（针对非连通图）
		}
		v.setDistance(0);//设置v到已访问节点集的距离
		//挑选最佳节点
		Vertex<?> vb;
		while ((vb = bestVertex()) != null){
			visit(vb, null);
			//更新未访问节点集的最短距离
			updateDistanceAfter(vb);
		}
		return null;
	}

	/**
	 * 在指定节点加入已访问集后更新未访问节点集的各节点权重
	 * @param vb 指定的节点
	 */
	protected abstract void updateDistanceAfter(Vertex<?> vb);

	/**
	 * 从未访问节点集中选出最优节点
	 * @return 算法特定的最优节点
	 */
	protected abstract Vertex<?> bestVertex();

}
