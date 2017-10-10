package Chatper3.semaphore3_3;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
	// 2. 声明一个对象为Semaphore，称它为semaphore。
	private final Semaphore semaphore;
	private Lock lockPrinters;
	private boolean freePrinters[];

	// 3. 实现类的构造函数并初始能保护print quere的访问的semaphore对象的值。
	public PrintQueue() {
		semaphore = new Semaphore(3);
		freePrinters = new boolean[3];
		for (int i = 0; i < 3; i++) {
			freePrinters[i] = true;
		}
		lockPrinters = new ReentrantLock();
	}

	// 4. 实现Implement the printJob()方法，此方法可以模拟打印文档，并接收document对象作为参数。
	public void printJob() {

		// 5. 在这方法内，首先，你必须调用acquire()方法获得demaphore。这个方法会抛出
		// InterruptedException异常，使用必须包含处理这个异常的代码。
		try {
			semaphore.acquire();

			int assignedPrinter = getPrinter();
			// 6. 然后，实现能随机等待一段时间的模拟打印文档的行。
			long duration = (long) (Math.random() * 10);
			System.out.printf("%s: PrintQueue: Printing a Job in Printer%d during %d seconds\n",
					Thread.currentThread().getName(), assignedPrinter, duration);
			TimeUnit.SECONDS.sleep(duration);

			// 8. 最后，调用release() 方法来解放semaphore并标记打印机为空闲，通过在对应的freePrinters
			// array引索内分配真值。
			

			// 7. 最后，释放semaphore通过调用semaphore的relaser()方法。
			// 14. 最后， 此方法写信息到操控台表明它已经结束运行了。
			freePrinters[assignedPrinter] = true;

		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
			semaphore.release();
		}
	}

	private int getPrinter() {
		// TODO Auto-generated method stub
		int ret = -1;
		try {
			lockPrinters.lock();
			for (int i = 0; i < freePrinters.length; i++) {
				if (freePrinters[i]) {
					ret = i;
					freePrinters[i] = false;
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lockPrinters.unlock();
		}
		return ret;
	}
}
