package basic.bit.application;

import java.util.HashMap;
import java.util.Map;

import basic.bit.BitClearner;
import basic.bit.BitCounter;
import basic.bit.BitGetter;
import basic.bit.BitSetter;

/**
 * 查找给定正整数中与其二进制表示中1的个数相同的相邻两个数（一个略大，一个略小）
 * 来源：Gayle L. McDowell著的《Cracking the coding interview》（
 * 程序员面试金典）
 * @author Jingang Zhou
 *
 */
public class AdjacentOneCountNumberFinder {

	private final int num;
	private Map<String, Integer> map = new HashMap<String, Integer>();
	private static final String BIG = "bigger";
	private static final String SMALL = "smaller";
	
	public AdjacentOneCountNumberFinder(int num){
		if (num <= 0){
			throw new IllegalArgumentException("输入必须是正整数.");
		}
		this.num = num;
	}
	
	/**
	 * 从低位到高位遍历找到第一个非拖尾的"0"(该位右边有个"1")，将其变为"1"，然后将之前出现的"1"
	 * 都移到最低位。
	 * @return 比给定的数略大，但二进制表示中1的个数相同的数。
	 */
	public int findBigger(){
		if (map.containsKey(BIG)){
			return map.get(BIG);
		}
		//num的二进制位数
		int count = BitCounter.count(num);	
		//记录低位出现的1的个数，-1是为了补足反转的一个1
		int numberOfOne = -1;
		int index = 0;
		for (int i=1; i<=count; i++){
			if (BitGetter.getBit(num, i) == 1){
				numberOfOne++;
				if (BitGetter.getBit(num, i+1) == 0){
					index = i;
					break;
				}
			}
		}
		int	ret = BitSetter.setOne(num, index+1);
		
		//将低位清零
		ret = BitClearner.clearLow(ret, index);		
		//将最低位置1
		if (numberOfOne > 0){
			ret = ret | (1<<numberOfOne)-1;
		}
		map.put(BIG, ret);
		return ret;		
	}
	
	/**
	 * 从低位到高位找到第一个非拖尾的"1"(其右边有"0")，将其改为"0"，然后将这一路中
	 * 出现的1都移到它的右边。
	 * @return 比给定的数略小，但二进制表示中1的个数相同的数。
	 */
	public int findSmaller(){
		if (map.containsKey(SMALL)){
			return map.get(SMALL);
		}
		int count = BitCounter.count(num);	
		//记录查找过程中1出现的个数，初始1是为了补足反转的1
		int numberOfOne = 1;
		int index = 0;
		for (int i=1; i<=count; i++){
			if (BitGetter.getBit(num, i) == 1){
				numberOfOne++;
			}else{
				if (BitGetter.getBit(num, i+1) == 1){
					index = i;
					break;
				}					
			}
		}
		int ret = BitSetter.setZeroByAnd(num, index+1);
		ret = BitClearner.clearLow(ret, index);
		ret |= ((1<<numberOfOne)-1)<<(numberOfOne-index);
		map.put(SMALL, ret);
		return ret;		
	}
	
}
