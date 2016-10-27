package basic.graph;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import util.Pair;

public class FloydWarshallShortestPathTest {

	String[] vertices = new String[]{"A", "B", "C", "D"};
	int[][] distance = new int[vertices.length][vertices.length];
	
	@Before
	public void init(){
		for (int i=0; i<distance.length; i++){
			for (int j=0; j<distance.length; j++){
				if (i==j){
					distance[i][j]=0;
				}else{
					distance[i][j]=Integer.MAX_VALUE;
				}
			}
		}
	}
	
	@Test
	public void test() {
		FloydWarshallShortestPath<String> algorithm = new FloydWarshallShortestPath<String>(vertices, distance);
		algorithm.setDistance("A", "C", -2)
				 .setDistance("C", "D", 2)
				 .setDistance("D", "B", -1)
				 .setDistance("B", "A", 4)
				 .setDistance("B", "C", 3);
		Map<Pair<String>, List<String>> paths = algorithm.buildPath();
		assertEquals(3, distance[3][0]);
		assertEquals(Arrays.asList("D","B","A"), paths.get(new Pair<String>("D","A")));
	}

}
