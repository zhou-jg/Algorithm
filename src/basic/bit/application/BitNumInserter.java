package basic.bit.application;

import basic.bit.BitClearner;

public class BitNumInserter {

	/**
	 * 把value按位插入到source的第begin到第end位内。例如，将101插入到1100101100的第5位到第3位
	 * 间将得到1100110100。
	 * @param source
	 * @param value 有效二进制位数=begin-end
	 * @param begin
	 * @param end
	 * @return 修改后的值
	 */
	public static int bitInsert(int source, int value, int begin, int end){
		if (begin <= end){
			throw new IllegalArgumentException("起始位要大于终止位");
		}
		//保存低位(1~end-1)
		int lowValue = ~(1<<end) & source;
		//将source低位置零
		source = BitClearner.clearLow(source, begin);
		//合并
		return source | value<<end-1 | lowValue;
	}
}
