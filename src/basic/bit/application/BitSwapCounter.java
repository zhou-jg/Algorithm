package basic.bit.application;

public class BitSwapCounter {

	/**
	 * 计算需要对a调整多少个bits，才能使a==b。
	 * 思路是通过异或来判断有多少位差异。
	 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
	 * 程序员面试金典）
	 * @param a
	 * @param b
	 * @return 需要调整的位数
	 */
	public static int count(int a, int b){		
		int count = 0;
		//c&(c-1)可以翻转一个有效的1。
		for (int c=a^b; c!=0; c=c&(c-1)){
			count++;
		}
		return count;
	}
}
