package Chatper1.Daemon;

import java.util.ArrayDeque;
import java.util.Date;
import java.util.Deque;

public class CleanerTask extends Thread {
	private Deque<Event> deque;

	public CleanerTask(Deque<Event> deque) {
		// TODO Auto-generated constructor stub
		this.deque = deque;
		setDaemon(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("开始运行");
		while (true) {
			Date date = new Date();
			clean(date);
		}
	}

	private void clean(Date date) {
		long diference;
		boolean delete;
		if (deque.size() == 0) {
			System.out.println("队列中午元素");
			return;
		}
		delete = false;
		do {
			Event e = deque.getLast();
			diference = date.getTime() - e.getDate().getTime();
			System.out.println(diference);
			if (diference > 10000) {
				System.out.printf("Cleaner : %s \n", e.getEvent());
				deque.removeLast();
				delete = true;
			}
		} while (diference > 10000);
		if (delete) {
			System.out.printf("Cleaner : Size of the queue: %d\n", deque.size());
		}
	}

	public static void main(String[] args) {
		Deque<Event> deque = new ArrayDeque<Event>();

		WriterTask writer = new WriterTask(deque);

		for (int i = 0; i < 3; i++) {
			Thread thread = new Thread(writer);
			thread.start();
		}

		CleanerTask cleaner = new CleanerTask(deque);
		cleaner.start();
	}

}
