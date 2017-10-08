package Chatper1.threadGroup;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {
		ThreadGroup threadGroup = new ThreadGroup("searchaer");
		Result result = new Result();
		SearchTask searchTask = new SearchTask(result);

		for (int i = 0; i < 5; i++) {
			Thread thread = new Thread(threadGroup, searchTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.printf("Number of Threads : %d\n", threadGroup.activeCount());
		System.out.println("Infomation about the Thread Group\n");
		threadGroup.list();
		System.out.println("-------------------");
		
		
		Thread[] threads = new Thread[threadGroup.activeCount()];
		threadGroup.enumerate(threads);

		for (int i = 0; i < threadGroup.activeCount(); i++) {
			System.out.printf("Thread %s : %s\n", threads[i].getName(), threads[i].getState());
		}
		waitFinish(threadGroup);
		threadGroup.interrupt();
	}

	private static void waitFinish(ThreadGroup threadGroup) {
		while (threadGroup.activeCount() > 4) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
