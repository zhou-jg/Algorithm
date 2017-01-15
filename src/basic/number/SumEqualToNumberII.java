import java.util.ArrayList;
import java.util.List;
import util.Algorithm
/**
输入两个整数n 和m，从数列1，2，3.......n 中随意取几个数,
使其和等于m ,要求将其中所有的可能组合列出来.
*/
public class SumEqualToNumberII {
  @Algorithm("递归")
  public List<List<Integer>> compute(int n, int m){
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		List<Integer> list = new ArrayList<Integer>();
		for (int i=1; i<=n; i++) {
			helper(ret, list, i, n, m);
		}
		return ret;
	}
	
	private void helper(List<List<Integer>> ret, List<Integer> list, int current, int n, int m){
		if (current <= m){
			list.add(current);
			if (current == m){
				ret.add(new ArrayList<Integer>(list));
			}else{
				for (int k=current+1; k<=n; k++){
					helper(ret, list, k, n, m-current);
				}
			}
			
			list.remove(list.size()-1);			
		}
	}
}
