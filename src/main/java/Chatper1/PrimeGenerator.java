package Chatper1;

public class PrimeGenerator extends Thread{

	
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		long number = 1L;
		
		while(true){
			System.out.println(number++);
			if(interrupted()){
				System.out.println("进程终止了..");
				return;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread task = new PrimeGenerator();
		task.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		task.interrupt();
	}
}
