package Chatper2.Lock2_6;

public class Reader implements Runnable {

	private PriceInfo priceInfo;

	public Reader(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("%s: Price 1: %f\n", Thread.currentThread().getName(), priceInfo.getPrice1());
		System.out.printf("%s: Price 2: %f\n", Thread.currentThread().getName(), priceInfo.getPrice2());

	}

}
