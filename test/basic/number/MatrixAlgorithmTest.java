package basic.number;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatrixAlgorithmTest {

	@Test
	public void testReduceZero() {
		int[][] expected = new int[][]{
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 0, 0},
				{0, 0, 0, 1, 1}
		};
		
		int[][] result = MatrixAlgorithm.reduceZero(new int[][]{
				{1, 0, 0, 1, 1},
				{0, 1, 1, 1, 1},
				{0, 1, 0, 1, 1},
				{1, 1, 1, 1, 1}
		});
		
		for (int i = 0; i < expected.length; i++){
			assertArrayEquals(expected[i], result[i]);
		}
	}

	@Test
	public void testRotateOddMatrix(){
		int [][] expected = new int[][]{				
				{21,16,11,6, 1},
				{22,17,12,7, 2},
				{23,18,13,8, 3},
				{24,19,14,9, 4},
				{25,20,15,10,5}
		};
		int[][] result = MatrixAlgorithm.rotate(new int[][]{
				{1, 2, 3, 4, 5},
				{6, 7, 8, 9, 10},
				{11,12,13,14,15},
				{16,17,18,19,20},
				{21,22,23,24,25}
		});
		for (int i = 0; i < expected.length; i++){
			assertArrayEquals(expected[i], result[i]);
		}
	}
	
	@Test
	public void testRotateEvenMatrix(){
		int[][] expected = new int[][]{				
				{13,9, 5, 1},
				{14,10,6, 2},
				{15,11,7, 3},
				{16,12,8, 4}
		};
		int[][] result = MatrixAlgorithm.rotate(new int[][]{
				{1,2,3,4},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}		
		});
		for (int i = 0; i < expected.length; i++){
			assertArrayEquals(expected[i], result[i]);
		}
	}
}
