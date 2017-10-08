package Chatper2.Synchronized2_3;

public class Main {
	public static void main(String[] args) {
		Cinema cinema1 = new Cinema();
		TicketOffice1 ticketOffice1 = new TicketOffice1(cinema1);
		Thread thread1 = new Thread(ticketOffice1, "TicketOffice1");
		Cinema cinema2 = new Cinema();
		TicketOffice2 ticketOffice2 = new TicketOffice2(cinema2);
		Thread thread2 = new Thread(ticketOffice2, "TicketOffice2");

		thread1.start();
		thread2.start();

		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.printf("Room 1 Vacancies: %d\n", cinema1.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema1.getVacanciesCinema2());

	}
}
