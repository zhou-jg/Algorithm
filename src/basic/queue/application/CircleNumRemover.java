package basic.queue.application;

import java.util.ArrayDeque;
import java.util.Queue;

import util.Algorithm;

/**
 * 将给定的一组元素排成环，从某一个对象开始，当依次数到某个指定数时，该元素退出，重复该过程，
 * 直至只剩下一个对象，返回该对象。
 * 来源：邓俊辉著《数据结构与算法（Java描述）》P.47
 * @author Jingang Zhou
 *
 */
public class CircleNumRemover {

	/**
	 * 从给定数组中经过依次的元素退出，直至最后剩余一个。从数组的第一个元素开始。
	 * @param data 给定的数组
	 * @param magic 给定的数，当依次数到该数时，所处的数组元素退出
	 * @return 最后剩余元素
	 * @exception NullPointerException 当给定的数组为空
	 */
	@Algorithm("队列")
	public static <T> T who(T[] data, int magic){
		Queue<T> queue = new ArrayDeque<T>();
		for (T t : data){
			queue.offer(t);
		}
		while (queue.size() > 1){
			for (int i=1; i<magic; i++){
				queue.offer(queue.poll());
			}
			queue.poll();
		}
		
		return queue.poll();
	}
}
