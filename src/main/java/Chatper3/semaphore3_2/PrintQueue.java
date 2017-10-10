package Chatper3.semaphore3_2;

import java.util.concurrent.Semaphore;

public class PrintQueue {
	// 2. 声明一个对象为Semaphore，称它为semaphore。
	private final Semaphore semaphore;

	// 3. 实现类的构造函数并初始能保护print quere的访问的semaphore对象的值。
	public PrintQueue() {
		semaphore = new Semaphore(1);
	}

	// 4. 实现Implement the printJob()方法，此方法可以模拟打印文档，并接收document对象作为参数。
	public void printJob() {

		// 5. 在这方法内，首先，你必须调用acquire()方法获得demaphore。这个方法会抛出
		// InterruptedException异常，使用必须包含处理这个异常的代码。
		try {
			semaphore.acquire();

			// 6. 然后，实现能随机等待一段时间的模拟打印文档的行。
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job during %d seconds\n", Thread.currentThread().getName(),
					duration);
			Thread.sleep(duration);

			// 7. 最后，释放semaphore通过调用semaphore的relaser()方法。
			// 14. 最后， 此方法写信息到操控台表明它已经结束运行了。
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaphore.release();
		}
	}
}
