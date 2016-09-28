package basic.concurrent.application;

import java.util.concurrent.CountDownLatch;

/**
 * 让三个并发的线程按序执行某个目标共享对象上的不同操作。
 * 本应用采用<code>CountDownLatch</code>来对这些线程进行同步。
 * 也可以采用<code>Semaphore</Semaphore>来做。
 * 
 * @author Jingang Zhou
 *
 */
public class ThreadExecutionInOrder {
	
	public static void main(String[] args){
		TargetObject o = new TargetObject();
		CountDownLatch one2two = new CountDownLatch(1);
		CountDownLatch two2three = new CountDownLatch(1);
		new ThreadA(o, one2two).start();
		new ThreadB(o, one2two, two2three).start();
		new ThreadC(o, two2three).start();
	}

	static class TargetObject {
		void first(){
			System.out.println("first");
		}
		void second(){
			System.out.println("second");		
		}
		void third(){
			System.out.println("third");
		}
	}	
		
		
	static class ThreadA extends Thread{
		TargetObject obj = null;
		CountDownLatch lock = null;
		ThreadA(TargetObject o, CountDownLatch lock){
			obj = o;
			this.lock = lock;
		}
		
		public void run(){			
			obj.first();
			lock.countDown();		
		}
	}
	
	static class ThreadB extends Thread{
		TargetObject obj = null;
		CountDownLatch lock1, lock2;
		ThreadB(TargetObject o, CountDownLatch lock1, CountDownLatch lock2){
			obj = o;
			this.lock1 = lock1;
			this.lock2 = lock2;
		}
		
		public void run(){
			try {
				lock1.await();
				obj.second();
				lock2.countDown();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
	
	static class ThreadC extends Thread{
		TargetObject obj = null;
		CountDownLatch lock = null;
		ThreadC(TargetObject o, CountDownLatch lock){
			obj = o;
			this.lock = lock;
		}
		
		public void run(){
			try {
				lock.await();
				obj.third();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
	}
}
