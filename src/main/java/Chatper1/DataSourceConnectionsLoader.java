package Chatper1;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceConnectionsLoader implements Runnable {

	public void run() {
		// TODO Auto-generated method stub
		System.out.printf("beginning data source loading :%s\n", new Date());

		try {
			TimeUnit.SECONDS.sleep(6);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.printf("Data source loading has finiashed %s\n", new Date());
	}

}
