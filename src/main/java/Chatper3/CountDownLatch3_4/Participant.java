package Chatper3.CountDownLatch3_4;

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {

	private Videoconference conference;
	private String name;

	public Participant(Videoconference conference, String name) {
		// TODO Auto-generated constructor stub
		this.conference = conference;
		this.name = name;

	}

	public void run() {
		// TODO Auto-generated method stub
		long duration = (long) (Math.random() * 10);
		try {
			TimeUnit.SECONDS.sleep(duration);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 18. 然后，使用Videoconference 对象的arrive() 方法来表明参与者的到达。
		conference.arrive(name);
	}

}
