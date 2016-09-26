package basic.number;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import util.Algorithm;

public class MatrixAlgorithm {
	/**
	 * 如果array的某个元素为0，则将其所在行列的所有元素都清零。
	 * 操作会在原有数组上进行。也就是说这是个过程，而非函数，所以
	 * 可以不用返回值。
	 * @param array 如果发生清零动作，则array被修改
	 * @return 清零后的array
	 */
	@Algorithm
	public static int[][] reduceZero(int[][] array){
		Objects.requireNonNull(array);

		//记录0出现的行和列
		Set<Integer> rows = new HashSet<>();
		Set<Integer> columns = new HashSet<>();
		for (int i = 0; i < array.length; i++){
			boolean occur = false;
			for (int j = 0; j < array[0].length; j++){
				if (array[i][j] == 0){
					if (!occur){
						occur = true;
						rows.add(i);
					}
					columns.add(j);
				}
			}
		}
		
		/*
		 * 可以进行更为精细的判断，例如如果rows中的元素个数等于总行数，则全部清零，列也是类似；
		 * 再或者出现0的行数或列数哪个数相对更大（即与总行数或列数的差较小），则先按哪个数来清零。
		 * 但这使得代码不易读，没有下面的直接和易读
		 */
		//逐行清零
		for (int row : rows){
			for (int j=0; j < array[0].length; j++){
				array[row][j] = 0;
			}
		}
		//在剩余行中逐列清零
		for (int i = 0; i < array.length; i++){
			if (!rows.contains(i)){
				for (int column : columns){
					array[i][column] = 0;
				}
			}
		}
		
		return array;
	}
	
	/**
	 * 将array顺时针旋转90度
	 * @param array 是个方阵
	 * @return
	 */
	public static int[][] rotate(int[][] array){
		Objects.requireNonNull(array);
		
		int length = array.length;
		int middle = length / 2;
		
		for (int i=0; i<middle; i++){
			for (int j=i; j<length-i-1; j++){
				int tmp = array[i][j];
				//左移到上
				array[i][j] = array[length-1-j][i];
				//下移到左
				array[length-1-j][i] = array[length-1-i][length-1-j];
				//右移到下
				array[length-1-i][length-1-j] = array[j][length-1-i];
				//上移到右
				array[j][length-1-i] = tmp;
			}				
		}
		
		return array;
	}
}
