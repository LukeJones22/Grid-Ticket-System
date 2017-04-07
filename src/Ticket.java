import java.util.Random;


public class Ticket {
	private int ticketNum;
	private double price;
	
	public Ticket(int ticketNum){
		this.ticketNum = ticketNum;
		Random random = new Random();
		double min = 1.00, max = 400.00;
		price = min + random.nextDouble() * (max-min);
	}

	/**
	 * @return the ticketNum
	 */
	public int getTicketNum() {
		return ticketNum;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	
}
