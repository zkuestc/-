package Chatper1.unSafeTask;

import java.util.concurrent.TimeUnit;

public class Core {

	public static void main(String[] args) {
		UnsafeTask unsafeTask = new UnsafeTask();
		for (int i = 0; i < 10; i++) {
			Thread thread = new Thread(unsafeTask);
			thread.start();
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
