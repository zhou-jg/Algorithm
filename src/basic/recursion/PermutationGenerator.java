package basic.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 从给定的集合中生成指定规模（长度）的排列列表。假设输入集合的规模为m，要生成的组合元素规模
 * 为n (n <= m)，则组合数 P(m, n) = m!/(m-n)! 
 * @author Jingang Zhou
 * @see CombinationGenerator
 * @see StringPermutation
 */
public class PermutationGenerator {

	private Character[] data;
	
	public PermutationGenerator (Set<Character> data){
		this.data = data.toArray(new Character[data.size()]);
	}
	
	public PermutationGenerator(Character[] data){
		this(new HashSet<Character>(Arrays.asList(data)));
	}
	
	public List<List<Character>> generate(int length){
		if (data.length < length){
			throw new IllegalArgumentException("长度不能大于集合元素数：" + data.length);
		}
		List<List<Character>> ret = new ArrayList<List<Character>>();
		List<Character> list = new ArrayList<Character>(length);
		internalGenerate(ret, list, 0, length);
		return ret;
	}
	
	private void internalGenerate(List<List<Character>> ret, List<Character> list, int k, int length){
		if (k == length){
			ret.add(new ArrayList<>(list));			
		}else{
			for (int i=0; i<data.length; i++){
				if (!list.contains(data[i])){
					list.add(data[i]);
					internalGenerate(ret, list, k+1, length);
					list.remove(data[i]);
				}				
			}		
		}
	}
}
