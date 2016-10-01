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
	public static List<Integer> sum(List<Integer> h1, List<Integer> h2, boolean isPositive){
		return toList(getNum(h1, isPositive) + getNum(h2, isPositive), isPositive);
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
	
	private static List<Integer> toList(int num, boolean isPositive){
		List<Integer> head = null;
		//游标
		List<Integer> tmp = null;
		while (num > 0){
			int bit = num % 10;
			num /= 10;
			List<Integer> node = new List<Integer>(bit);
			if (tmp == null){
				tmp = node;
				head = tmp;//负向时的头指针
			}else{
				if (isPositive){					
					node.setNext(tmp);
					head = node;
				}else{
					tmp.setNext(node);
				}
			}
			tmp = node;
		}
		return head;
	}
}
