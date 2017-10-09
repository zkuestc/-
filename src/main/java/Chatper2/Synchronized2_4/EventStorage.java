package Chatper2.Synchronized2_4;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {
	private int maxSize;
	private List<Date> storage;

	public EventStorage() {
		maxSize = 100;
		storage = new LinkedList<Date>();
	}

	public synchronized void set() {
		while (storage.size() == maxSize) {
			try {
				System.out.println("共享池已满，生产者开始wait");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("生产者生产了，唤醒消费者消费");
		storage.add(new Date());
		
		System.out.printf("Set: %d \n", storage.size());
		notifyAll();
	}

	public synchronized void get() {
		while (storage.size() == 0) {
			try {
				System.out.println("共享池已空，消费者开始wait");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("消费者消费了，唤醒生产者继续生产");
		System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
		notifyAll();
	}

}
