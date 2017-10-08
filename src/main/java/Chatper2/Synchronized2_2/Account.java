package Chatper2.Synchronized2_2;

public class Account {
	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public /*synchronized*/ void addAmount(double amount) {
		synchronized (this) {
			double tmp = balance;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 1000 +50
			tmp += amount;
			// 1050
			balance = tmp;
		}
	}

	public void subtractAmount(double amount) {
		synchronized (this) {
			double tmp = balance;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// 1000-50
			tmp -= amount;
			// 950
			balance = tmp;
		}
	}

}
