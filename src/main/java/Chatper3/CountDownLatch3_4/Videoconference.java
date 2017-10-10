package Chatper3.CountDownLatch3_4;

import java.util.concurrent.CountDownLatch;

public class Videoconference implements Runnable {
	private final CountDownLatch controller;

	public Videoconference(int num) {
		this.controller = new CountDownLatch(num);
	}

	public void arrive(String name) {
		System.out.printf("%s has arrived.\n", name);
		controller.countDown();
		System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());
	}

	public void run() {
		// TODO Auto-generated method stub

		try {
			System.out.printf("VideoConference: Initialization: %d participants.\n", controller.getCount());
			controller.await();
			System.out.println("VideoConference: All the participants have come\n");
			System.out.println("VideoConference: Let's start...\n");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
