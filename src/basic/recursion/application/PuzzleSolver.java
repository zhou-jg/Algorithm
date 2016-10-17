package basic.recursion.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.Algorithm;
import basic.recursion.PermutationGenerator;

/**
 * 通过给字母赋成相应的0..9的数字，使得由字符串代表的算术等式成立。
 * 选自：邓俊辉著《数据结构与算法（Java描述）》
 * @author Jingang Zhou
 *
 */
@Algorithm("递归")
@Algorithm("排列组合")
public abstract class PuzzleSolver {

	private Integer[] values;
	
	/**
	 * @param values 指定的字符变量值范围
	 */
	public PuzzleSolver(Set<Integer> values){
		this.values = values.toArray(new Integer[values.size()]);
	}
	
	/**
	 * 只给出一个解。
	 * @return
	 */
	public Map<Character, Integer> solve() {	
		List<Character> list = new ArrayList<Character>(getVariables());		
		List<Integer> vs = new ArrayList<>(list.size());
		
		return internalGenerate(list, vs, 0, list.size());			
	}	
	
	/**
	 * 检查方案是否满足要求
	 * @param solution 指定的方案
	 * @return
	 */
	protected abstract boolean check(Map<Character, Integer> solution);
	
	/**
	 * 获得所有的字符变量
	 * @return
	 */
	protected abstract Set<Character> getVariables();
	
	/**
	 * 遍历求解，只返回第一个找到的可行解。如果想返回所有可行解，请参考 {@link PermutationGenerator#generate()}
	 * @param cs 字符变量列表
	 * @param list 当前构造中的方案列表
	 * @param k 当前正在对第几个遍历进行计算
	 * @param length 字符变量列表长度
	 * @return
	 */
	private Map<Character, Integer> internalGenerate(List<Character> cs, List<Integer> list, int k, int length){
		if (k == length){
			Map<Character, Integer> ret = toMap(cs, list);
			if (check(ret)){
				return ret;
			}		
		}else{
			for (int i=0; i<values.length; i++){
				if (!list.contains(values[i])){
					list.add(values[i]);
					Map<Character, Integer> ret = internalGenerate(cs, list, k+1, length);
					if (ret.size() > 0){
						return ret;
					}else {
						list.remove(values[i]);						
					}
				}				
			}			
		}
		return Collections.emptyMap();
	}
	
	/**
	 * 对照字符-值映射表构造由字符列表组成的操作数
	 * @param cs
	 * @param map
	 * @return
	 */
	public static int buildOperand(List<Character> cs, Map<Character, Integer> map){
		int num = 0;
		for (Character c : cs){
			Integer n = map.get(c);
			num = num * 10 + n;
		}
		return num;
	}
	
	/**
	 * 判断字符列表构造的加法等式是否成立
	 * @param a1 第一个操作数对应的字符列表
	 * @param a2 第二个操作数对应的字符列表
	 * @param sum 和数对应的字符列表
	 * @param map 字符-值参照表
	 * @return true: 等式成立，否则不成立
	 */
	public static boolean isAdditionOK(List<Character> a1, List<Character> a2, List<Character> sum, Map<Character, Integer> map){
		return buildOperand(sum, map) == buildOperand(a1, map) + buildOperand(a2, map);
	}
	
	/**
	 * 从两个列表构造映射表
	 * @param cs 键
	 * @param vs 值
	 * @return
	 */
	private Map<Character, Integer> toMap(List<Character> cs, List<Integer> vs){
		Map<Character, Integer> ret = new HashMap<Character, Integer>();		
		for (int i=0; i<cs.size(); i++){
			ret.put(cs.get(i), vs.get(i));
		}
		return ret;
	}
}
