package basic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * 八皇后问题（参考：https://zh.wikipedia.org/wiki/%E5%85%AB%E7%9A%87%E5%90%8E%E9%97%AE%E9%A2%98）
 * @author Jingang Zhou
 *
 */
public class EightQueensProblem {
	static final int GRID_SIZE = 8;
	
	/**
	 * 计算所用可摆放的位置
	 * @return 所有的可摆放的位置列表，每个数组元素代表一个棋盘（八皇后）位置的摆法；数组的索引时行号，值为列号
	 */
	public static List<Integer[]> find(){
		List<Integer[]> result = new ArrayList<>();
		Integer[] record = new Integer[GRID_SIZE];		
		internalFind(result, record, 0);
		return result;
	}

	/**
	 * 核心部分：以列为外循环，以行为内循环（递归）来遍历所用可能的放法。
	 * @param result
	 * @param record
	 * @param row
	 */
	private static void internalFind(List<Integer[]> result, Integer[] record, int row) {
		if (row == GRID_SIZE){
			result.add(record.clone());
		}else{
			for (int col = 0; col < GRID_SIZE; col++){				
				if (checkValid(record, row, col)){
					record[row] = col;
					internalFind(result, record, row+1);
				}
			}
		}
	}

	private static boolean checkValid(Integer[] record, int row, int col) {
		for (int i=0; i<row; i++){
			if (record[i] == col){
				return false;
			}
			if (Math.abs(record[i] - col) == row - i){
				return false;
			}
		}		
		return true;
	}
}
