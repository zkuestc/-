package Chatper2.Lock2_6;

public class Writer implements Runnable {
	private PriceInfo priceInfo;

	public Writer(PriceInfo priceInfo) {
		this.priceInfo = priceInfo;
	}

	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.printf("Writer: Attempt to modify theprices.\n");
			priceInfo.setPrice(Math.random() * 10, Math.random() * 8);
			System.out.printf("Writer: Prices have been modified.\n");
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
