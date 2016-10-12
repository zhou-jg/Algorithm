package util;

import java.util.Objects;

public class NumberUtil {
	/**
	 * 
	 * @param a
	 * @return 1 if a >= 0; 0 if a < 0;
	 */
	public static int sign(int a){
		return flip((a>>31)&0x1);
	}
	
	/**
	 * Map 1 to 0 or 0 to 1.
	 * @param bit
	 * @return
	 */
	public static int flip(int bit){
		return 1^bit;
	}
	
	/**
	 * 
	 * @param a
	 * @return max value of the array, Integer.MIN_VALUE if a is empty.
	 */
	public static int max(int... a){
		int result = Integer.MIN_VALUE;
		for (int i = 0; i<a.length; i++){
			if (result < a[i]){
				result = a[i];
			}
		}
		return result;
	}
	
	/**
	 * See also: Apache commons-lang (ArrayUtils.java)
	 * @param a
	 * @return
	 */
	public static int[] fromObjects(Integer[] a){
		if (a==null){
			return null;
		}else{
			int[] res = new int[a.length];
			for (int i=0; i<a.length; i++){
				res[i] = a[i].intValue();
			}
			return res;
		}
	}
	
	public static int factorial(int n){
		int result = 1;
		for (int i=2; i<=n; i++){
			result *= i;
		}
		return result;
	}
	
	/**
	 * 交换指定索引的数组元素
	 * @param array
	 * @param i
	 * @param j
	 * @see ArraysUtil#swap(Object[], int, int)
	 * @deprecated
	 */
	public static void swap(int[] array, int i, int j){
		Objects.requireNonNull(array);
		
		if (i != j){
			int tmp = array[i];
			array[i] = array[j];
			array[j] = tmp;
		}
	}
	
	/**
	 * 判断是否是奇数
	 * @param k
	 * @return
	 */
	public static boolean isOdd(int k){
		return (k & 1) == 1;
	}
	
	/**
	 * 判断是否是偶数
	 * @param k
	 * @return
	 */
	public static boolean isEven(int k){
		return (k & 1) == 0;
	}
}
