import java.util.ArrayList;
import java.util.List;
/**
n 个数字（0,1,…,n-1）形成一个圆圈，从数字0 开始，每次从这个圆圈中
删除第m 个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。
当一个数字删除后，从被删除数字的下一个继续删除第m 个数字。
求出在这个圆圈中剩下的最后一个数字。
*/
public class FinalSurviorFinder {
  public int find(int n, int m){
		List<Integer> list = new ArrayList<Integer>(n);
		for (int i=0; i<n; i++){
			list.add(i);
		}
		int index = 0;
		while (list.size() > 2){
			int k = (m-1+index) % list.size();
			list.remove(k);
			index = k;
		}
		return list.get(0);
	}
}
