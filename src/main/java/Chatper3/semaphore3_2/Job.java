package Chatper3.semaphore3_2;

public class Job implements Runnable {
	private PrintQueue printQueue;

	// 10. 实现类的构造函数，初始化这个类里的PrintQueue对象。
	public Job(PrintQueue printQueue) {
		this.printQueue = printQueue;
	}

	public void run() {
		// TODO Auto-generated method stub
		// 12. 首先， 此方法写信息到操控台表明任务已经开始执行了。
		System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());

		// 13. 然后，调用PrintQueue 对象的printJob()方法。
		printQueue.printJob();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
		
	}

}
