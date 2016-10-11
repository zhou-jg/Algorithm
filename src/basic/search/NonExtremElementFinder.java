package basic.search;

/**
 * 选自：邓俊辉著《数据结构与算法（Java描述）》
 * @author Jingang Zhou
 *
 */
public class NonExtremElementFinder {
	
	/**
	 * 找到数组中非极值外的任意一个元素。用于说明算法的时间复杂度为O(1)。
	 * @param data 规模大于 等于3 的数组
	 * @return 输入数组中不等同于{@code Integer.MAX_VALUE 和 Integer.MIN_VALUE}的一个值
	 */
	public static int find(int[] data){
		if (data[0] == Integer.MAX_VALUE){ //O(2)
			if (data[1] == Integer.MIN_VALUE){ //O(2)
				return data[2]; //O(5)
			}else{
				return data[1]; //O(5)
			}
		}else if (data[0] == Integer.MIN_VALUE){ //O(3)
			if (data[1] == Integer.MAX_VALUE){ //O(4)
				return data[2]; //O(5)
			}else {
				return data[1]; //O(5)
			}
		}else {
			return data[0]; //O(4)
		}
	}
}
