package Chatper1.threadFactory;

import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}
