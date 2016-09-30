package basic.list.application;

import util.Algorithm;
import datastructure.List;

/**
 * 对两个由链表表示的整数进行求和，其中链表中每个节点代表一个整数位。分为正向和逆向两者情况：
 * <ol>正向: 5->7->3 代表 573
 * <ol>逆向: 5->7->3 代表 375
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class SumByListBits {

	/**
	 * 
	 * @param h1
	 * @param h2
	 * @param isPositive true 表示正向表示的数；false 表示逆向表示的数
	 * @return
	 */
	@Algorithm
	public static int sum(List<Integer> h1, List<Integer> h2, boolean isPositive){
		return getNum(h1, isPositive) + getNum(h2, isPositive);
	}
	
	private static int getNum(List<Integer> h, boolean isPositive){
		int num = 0;
		int i = 1;
		while (h != null){
			if (isPositive){
				num = num * 10 + h.getData();				
			}else{
				num += i * h.getData();
				i *= 10;
			}
			h = h.getNext();
		}
		return num;
	}
}
