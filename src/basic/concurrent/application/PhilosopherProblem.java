package basic.concurrent.application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 哲学家就餐问题
 * @author Jingang Zhou
 *
 */
public class PhilosopherProblem {
	
	/**
	 * 
	 * @param num 哲学家数量
	 * @return 哲学家就餐状态 [i] = 1 表示第 i 个哲学家已就餐完毕
	 */
	public static int[] resolve(int num){
		Lock[] choppers = new ReentrantLock[num];
		for (int i=0; i<num; i++){
			choppers[i] = new ReentrantLock();
		}
		
		List<Callable<Integer>> philosophers = new ArrayList<>();
		ExecutorService pool = Executors.newFixedThreadPool(num);
		int[] result = new int[num];
		List<Future<Integer>> taskResults = null;
		
		for (int i=0; i<num-1; i++){
			philosophers.add(new Philosopher(i, choppers[i], choppers[i+1]));
		}
		philosophers.add(new Philosopher(choppers.length-1, choppers[choppers.length-1], choppers[0]));
		
		try {
			taskResults = pool.invokeAll(philosophers);
			for (Future<Integer> f : taskResults){
				result[f.get()] = 1;
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		} finally {
			pool.shutdown();
		}
		
		return result;
	}
	
	static class Philosopher implements Callable<Integer>{
		private final int index;
		private final Lock leftChopper, rightChopper;		
		
		Philosopher(int index, Lock leftChopper, Lock rightChopper){
			this.index = index;
			this.leftChopper = leftChopper;
			this.rightChopper = rightChopper;
		}
		
		@Override
		public Integer call(){
			int result = -1;
			while (result == -1){
				if (leftChopper.tryLock()){
					if (rightChopper.tryLock()){
						System.out.println(index + " is having dinner and finished.");					
						rightChopper.unlock();
						result = index;
					}
					leftChopper.unlock();
				}else{
					try {
						System.out.println(index + " is waiting....");
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			return result;
		}
		
		@Override
		public String toString(){
			return "Philosopher " + index;
		}
	}
	
	public static void main(String[] args){
		PhilosopherProblem.resolve(8);
	}
}
