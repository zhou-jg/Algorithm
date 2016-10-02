package basic.queue.application;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class HanoiTowerEx {

	private int n;
	private Map<Deque<Integer>, String> nameMapper;
	private Deque<Integer> A, B, C;
	/**
	 * 
	 * @param n 盘子高度
	 * @param names 各个柱的名字，用于输出显示
	 */
	public HanoiTowerEx(int n, String[] names){
		this.n = n;
		
		initData(names);
	}
	private void initData(String[] names) {
		A = new ArrayDeque<>();
		B = new ArrayDeque<>();
		C = new ArrayDeque<>();
		for (int i=n; i>0; i--){
			A.offerFirst(i);
		}
		nameMapper = new HashMap<>();
		nameMapper.put(A, names[0]);
		nameMapper.put(B, names[1]);
		nameMapper.put(C, names[2]);
	}
	
	public void resolve(){
		internalResolve(n, A, B, C);
	}
	
	private void internalResolve(int n, Deque<Integer> A, Deque<Integer> B, Deque<Integer> C){
		if (n==1){
			int num = A.pollFirst();
			C.offerFirst(num);
			outputState(num, nameMapper.get(A), nameMapper.get(C));
		}else{
			internalResolve(n-1, A, C, B);
			int num = A.pollFirst();
			C.offerFirst(num);
			outputState(num, nameMapper.get(A), nameMapper.get(C));
			internalResolve(n-1, B, A, C);
		}
	}
	
	protected void outputState(int num, String from, String to) {
		System.out.println("move [" + num + "] from " + from + " to " + to);
	}
	
	public static void main(String[] args){
		new HanoiTowerEx(3, new String[]{"A", "B", "C"}).resolve();
	}
}
