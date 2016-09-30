package basic.list;

import util.Algorithm;
import datastructure.List;

/**
 * 以给定的值对链表进行划分，所有小于该值的节点都排在大于或等于该值的节点的左边。
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class PartitionByValueX {

	/**
	 * 利用两个指针，第一个指针从头到尾遇到一个大于等于<b>x</b>的值就停下来，等待
	 * 第二个指针从头到尾找到一个小于<b>x</b>的值，然后二者进行值交换，直到一个指针
	 * 为空，说明已经划分完毕。
	 * @param head 给定的链表
	 * @param x 给定的参考值
	 */
	@Algorithm
	public static void divide(List<Integer> head, int x){
		if(head == null){
			return;
		}else{
			//寻找大于等于 x 的节点
			List<Integer> firstGuard = head;
			//寻找小于 x 的节点
			List<Integer> secondGuard = head.getNext();
			while (firstGuard != null && secondGuard != null){
				if (firstGuard.getData() >= x){
					while (secondGuard.getData() >= x){
						secondGuard = secondGuard.getNext();
						if (secondGuard == null){
							return;
						}
					}
					int tmp = firstGuard.getData();
					firstGuard.setData(secondGuard.getData());
					secondGuard.setData(tmp);
				}
				firstGuard = firstGuard.getNext();
			}
		}
	}
}
