package basic.number.applications;

/**
 * 进制转换。
 * 选自：邓俊辉著《数据结构与算法（Java描述）》
 * @author Jingang Zhou
 *
 */
public class BaseTransformer {

	/**
	 * 将给定的数转换为指定进制的输出。时间复杂度为对数时间复杂度O(log n)，
	 * 底数大小其实无所谓。 这里的n是给定数的大小。
	 * @param num 给定的数 (> 0)
	 * @param base 指定的进制 (<10)
	 * @return 以给定进制的输出形式
	 */
	public static String transform (int num, int base){
		StringBuilder sb = new StringBuilder(); //O(1)
		for (; num > 0; num /= base){
			sb.insert(0, num % base);
		} //3 * O(log n) + 1 = O(log n)
		return sb.toString();//O(log n)+O(1) = O(log n)
	}
}
