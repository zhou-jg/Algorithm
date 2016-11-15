package basic.graph.application;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import basic.graph.datastructure.Edge;
import basic.graph.datastructure.Graph;
import basic.graph.datastructure.Vertex;

public class DependencyResolver {
	/**
	 * 根据给定的插件列表，并发执行这些插件
	 * @param plguins 
	 * @throws InterruptedException
	 */
	public static void resolve(List<Plugin> plguins) throws InterruptedException{
		DependencyGraph g = buildGraph(plguins);
		resolve(g);
	}
	
	/**
	 * 根据插件列表，构造依赖关系图
	 * @param plguins
	 * @return 构造的图
	 */
	private static DependencyGraph buildGraph(List<Plugin> plguins) {
		DependencyGraph g = new DependencyGraph();
		Map<String, Module> map = new HashMap<String, Module>(plguins.size());
		
		for (Plugin p : plguins){
			map.put(p.getName(), new Module(g, p.getName()));			
		}
		for (Plugin p : plguins){
			Module head = map.get(p.getName());
			for (String m : p.getReqires()){
				Module tail = map.get(m);
				if (tail == null){
					throw new IllegalArgumentException("给定的输入缺少plugin： " + m);
				}
				new Dependency(g, head, tail, null);
			}
		}
		
		return g;
	}

	public static void resolve(DependencyGraph g) throws InterruptedException{
		int moduleNum = g.getVertexNumber();		
		int repeat = 0;

		while (moduleNum > 0){
			int before = moduleNum;
			for (Iterator<Vertex<String>> it = g.vertices(); it.hasNext(); ){
				Module m = (Module) it.next();
				if (m.inDeg() == 0){
					new Thread(m).start();
					it.remove();
					moduleNum--;
					if (moduleNum == 0){
						return;
					}
				}
			}
			/*以下是简单判断依赖图中是否存在环的一种简易替代方法
			*如果在连续3次指定的时间段内都没有发现新的可运行模块，就判定为存在环
			*@see CircleFinder
			*/
			if (before == moduleNum){
				repeat++;
			}else{
				repeat = 0;
			}
			if (repeat == 3){
				throw new RuntimeException("有环路存在，模块无法启动!");
			}
			
			Thread.sleep(1000);
		}
	}

	public static class Module extends Vertex<String> implements Runnable{
		private Graph<String, ?> g;

		public Module(Graph<String, ?> g, String data) {
			super(g, data);
			this.g = g;
		}

		@Override
		public void run() {
			System.out.println(data + " is running!");
			try {
				Thread.sleep(900);
				while (!outEdges.isEmpty()){
					g.remove(outEdges.get(0));
				}
				System.out.println(data + " is done.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Dependency extends Edge<Object> {

		public Dependency(Graph<?, Object> g, Module head, Module tail,
				Object data) {
			super(g, head, tail, data);
		}
		
	}
	
	public static class DependencyGraph extends Graph<String, Object> {
		
	}
	
	/**
	 * 插件对象，记录插件名称和依赖的插件
	 * @author Jingang Zhou
	 *
	 */
	public static final class Plugin{
		private final String name;
		private final List<String> reqires;
		
		public Plugin(String name, List<String> reqires){
			this.name = name;
			this.reqires = reqires;
		}
		
		public String getName(){
			return name;
		}
		
		public List<String> getReqires(){
			return reqires;
		}
	}
}

