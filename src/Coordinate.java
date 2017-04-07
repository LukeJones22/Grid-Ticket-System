
public class Coordinate {
	private int x;
	private int y;
	private Event event;
	private int distance;
	
	
	public Coordinate(int x, int y, Event event, int distance){
		this.x = x;
		this.y = y;
		this.event = event;
		this.distance = distance;
	}


	/**
	 * @return the distance
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}


	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @return the event
	 */
	public Event getEvent() {
		return event;
	}

}
