package Chatper1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FileClock implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10; i++) {
			System.out.printf("%s\n", new Date());
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("该进程"+Thread.currentThread().getName()+"被中断");
				return;
			}
		}

	}

	public static void main(String[] args) {
		FileClock clock = new FileClock();
		Thread thread = new Thread(clock);
		thread.start();

		try {
			System.out.println(Thread.currentThread().getName()+"开始休眠");
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		thread.interrupt();
	}

}
