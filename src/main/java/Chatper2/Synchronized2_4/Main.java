package Chatper2.Synchronized2_4;

public class Main {
	public static void main(String[] args) {
		EventStorage storage = new EventStorage();
		Producer producer = new Producer(storage);
		Thread thread1 = new Thread(producer);
		Consumer consumer = new Consumer(storage);
		Thread thread2 = new Thread(consumer);
		thread2.start();
		thread1.start();
	}
}
