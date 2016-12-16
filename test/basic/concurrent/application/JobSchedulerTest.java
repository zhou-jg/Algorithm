package basic.concurrent.application;

import java.util.Arrays;
import java.util.HashSet;

import org.junit.Test;

public class JobSchedulerTest {

	@Test
	public void test() {
		JobScheduler scheduler = new JobScheduler();
		JobScheduler.Job j1 = new JobScheduler.Job("job1", scheduler, null);
		JobScheduler.Job j2 = new JobScheduler.Job("job2", scheduler, new HashSet<JobScheduler.Job>(Arrays.asList(j1)));
		JobScheduler.Job j3 = new JobScheduler.Job("job3", scheduler, new HashSet<JobScheduler.Job>(Arrays.asList(j1)));
		JobScheduler.Job j4 = new JobScheduler.Job("job4", scheduler, new HashSet<JobScheduler.Job>(Arrays.asList(j2)));
		JobScheduler.Job j5 = new JobScheduler.Job("job5", scheduler, new HashSet<JobScheduler.Job>(Arrays.asList(j1, j3)));
		JobScheduler.Job j6 = new JobScheduler.Job("job6", scheduler, new HashSet<JobScheduler.Job>(Arrays.asList(j3, j4)));
		
		scheduler.start();
		//补充主线程等待是为了防止测试由于主线程结束而提前退出。
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}		
	}

}
