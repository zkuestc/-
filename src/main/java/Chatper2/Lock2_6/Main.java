package Chatper2.Lock2_6;

public class Main {

	public static void main(String[] args) {
		PriceInfo pricesInfo = new PriceInfo();
		Reader readers[] = new Reader[5];
		Thread threadsReader[] = new Thread[5];
		for (int i = 0; i < 5; i++) {
			readers[i] = new Reader(pricesInfo);
			threadsReader[i] = new Thread(readers[i]);
		}
		Writer writer = new Writer(pricesInfo);
		Thread threadWriter = new Thread(writer);

		for (int i = 0; i < 5; i++) {
			threadsReader[i].start();
		}
		threadWriter.start();

	
	}

}
