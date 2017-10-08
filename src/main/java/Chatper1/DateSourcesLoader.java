package Chatper1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateSourcesLoader implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("beginning data source loading :%s\n", new Date());

		try {
			TimeUnit.SECONDS.sleep(4);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Data source loading has finiashed %s\n", new Date());
	}

	public static void main(String[] args) {
		DateSourcesLoader dateSourcesLoader = new DateSourcesLoader();
		Thread thread1 = new Thread(dateSourcesLoader, "dateSourcesLoader");

		DataSourceConnectionsLoader dataSourceConnectionsLoader = new DataSourceConnectionsLoader();
		Thread thread2 = new Thread(dataSourceConnectionsLoader, "dataSourceConnectionsLoader");
	
		thread1.start();
		thread2.start();
		
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Thread.class.getName()+"线程结束");
	}

}
