import java.util.Random;


public class Event {
	private final int MAX_NUM_TICKETS = 5;
	private int eventId;
	private Ticket[] tickets;

	public Event(int eventId){
		this.eventId = eventId;
		
		Random random = new Random();
		//random.setSeed(20);		
		int numOfTickets = random.nextInt(MAX_NUM_TICKETS) + 1;
		tickets = new Ticket[numOfTickets];
		
		for(int i=0; i < numOfTickets; i++ ){			
			tickets[i] = new Ticket(i+1);
		}
	}

	/**
	 * @return the eventId
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * @return the tickets
	 */
	public Ticket[] getTickets() {
		return tickets;
	}

	/**
	 * @return the total ticket price
	 */
	public double getCheapestTicket() {
		double lowestPrice = tickets[0].getPrice();
		for(int i = 1; i < tickets.length; i++){
			if(tickets[i].getPrice() < lowestPrice ){
				lowestPrice = tickets[i].getPrice();
			}				
		}
		return lowestPrice;
	}
}
