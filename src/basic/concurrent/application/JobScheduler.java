package basic.concurrent.application;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 对彼此有依赖关系的任务进行并发的调度执行。
 * @author Jingang Zhou
 *
 */
public class JobScheduler {

	private ExecutorService service = Executors.newFixedThreadPool(10);
	private List<Job> jobs = new ArrayList<JobScheduler.Job>();
	private boolean running = false;
	
	public synchronized void start(){
		if (!running){
			running = true;
			for (Job job : jobs){
				job.virtualExec();
			}
		}		
	}
	
	void addJob(Job job){
		jobs.add(job);
	}
	
	public synchronized void stop(){
		running = false;
		service.shutdown();
	}
	
	synchronized void jobDone(Job job){
		jobs.remove(job);
		for (Job otherJob : jobs){
			otherJob.onJobDone(job);
		}
	}
	
	void jobCanStart(Job job){
		service.submit(job);
	}
	
	/**
	 * 代表了一个需要执行的任务。任务的执行可能有先后依赖。
	 * @author Jingang Zhou
	 *
	 */
	public static class Job implements Runnable{
		/*需要在当前Job执行时已经完成的Jobs*/
		private final Set<Job> depends = new HashSet<>();
		private final String name;
		private final JobScheduler scheduler;
		
		public Job(String name, JobScheduler scheduler, Set<Job> depends){
			Objects.requireNonNull(name);
			this.name = name;
			this.scheduler = scheduler;
			if (depends != null){
				this.depends.addAll(depends);
			}
			scheduler.addJob(this);
		}
		
		public void onJobDone(Job job){
			if (depends.remove(job)){
				virtualExec();
			}
		}
		
		
		public void virtualExec(){
			if (canStart()){
				scheduler.jobCanStart(this);
			}
		}
		public boolean canStart(){
			return depends.isEmpty();
		}
		
		@Override
		public void run() {
			exec();
			scheduler.jobDone(this);
		}
		
		/**
		 * Do the exact work in the subclass.
		 */
		protected void exec(){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(name + " finished!");
		}
		
		@Override
		public int hashCode() {
			return name.hashCode();
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj instanceof Job){
				return ((Job) obj).name.equals(name);
			}
			return false;
		}
	}
	
}
