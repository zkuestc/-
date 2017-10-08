package Chatper1.unSafeTask;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class UnsafeTask implements Runnable {

	private Date currentDate;

	public void run() {
		// TODO Auto-generated method stub

		currentDate = new Date();
		System.out.printf("线程 %s 开始执行,执行时间,%s\n", Thread.currentThread().getId(), currentDate);

		try {
			TimeUnit.SECONDS.sleep((int) (Math.rint(Math.random() * 10)));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.printf("线程%s执行完毕,%s \n", Thread.currentThread().getId(), currentDate);

	}

}
