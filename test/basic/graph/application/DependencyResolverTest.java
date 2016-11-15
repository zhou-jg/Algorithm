package basic.graph.application;

import org.junit.Before;
import org.junit.Test;

import basic.graph.application.DependencyResolver;
import basic.graph.application.DependencyResolver.Dependency;
import basic.graph.application.DependencyResolver.DependencyGraph;
import basic.graph.application.DependencyResolver.Module;

public class DependencyResolverTest {
	DependencyGraph g;
	Module m3, m4;
	@Before
	public void init(){
		g = new DependencyGraph();
		Module m1 = new Module(g, "M1");
		Module m2 = new Module(g, "M2");
		m3 = new Module(g, "M3");
		m4 = new Module(g, "M4");
		Module m5 = new Module(g, "M5");
		new Dependency(g, m2, m1, null);
		new Dependency(g, m3, m1, null);
		new Dependency(g, m4, m2, null);
		new Dependency(g, m5, m3, null);
		new Dependency(g, m4, m5, null);
	}
	@Test
	public void testOK() {			
		try {
			DependencyResolver.resolve(g);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Test(expected=RuntimeException.class)
	public void circleExist(){
		new Dependency(g, m3, m4, null);
		try {
			DependencyResolver.resolve(g);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}
