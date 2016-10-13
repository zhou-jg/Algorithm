package basic.recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import util.Algorithm;

/**
 * 从给定的集合中生成指定规模（长度）的组合列表。假设输入集合的规模为m，要生成的组合元素规模
 * 为n (n <= m)，则组合数 C(m, n) = m!/(n!*(m-n)!) 
 * @author Jingang Zhou
 *
 */
public class CombinationGenerator {

	private Character[] data;
	
	public CombinationGenerator(Set<Character> data){
		this.data = data.toArray(new Character[data.size()]);
	}
	
	public CombinationGenerator(Character[] data) {
		this(new HashSet<Character>(Arrays.asList(data)));
	}

	/**
	 * 生成指定长度的组合集合。该算法与八皇后问题类似，相当于行为指定的组合长度（{@code length}）、
	 * 列为集合规模的棋盘，要求不同行上的元素不相同。
	 * @param length 不大于给定集合的规模
	 * @return 所有可能的组合
	 * @see EightQueensProblem
	 */
	@Algorithm("递归")
	@Algorithm("排列组合")
	public Set<Set<Character>> generate(int length){
		if (data.length < length){
			throw new IllegalArgumentException("长度不能大于集合元素数：" + data.length);
		}
		Set<Set<Character>> ret = new HashSet<Set<Character>>();
		Set<Character> set = new HashSet<Character>();
		internalGenerate(ret, set, 0, length);
		return ret;
	}
	
	//递归主体
	private void internalGenerate(Set<Set<Character>> results, Set<Character> set, int k, int length){
		if (length == k){
			results.add(new HashSet<Character>(set));
		}else{
			for (int i=0; i<data.length; i++){
				if (!set.contains(data[i])){
					set.add(data[i]);
					internalGenerate(results, set, k+1, length);
					set.remove(data[i]);
				}				
			}			
		}
	} 

}
