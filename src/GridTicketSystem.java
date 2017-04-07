import java.util.Scanner;
import java.util.Random;

/** Main class */
public class GridTicketSystem {
	private static final int TOTAL_EVENTS = 10;
	
	/**
	 * Returns true when a string is numeric
	 * @param str a string
	 * @return true if string is numeric, otherwise false
	 */
	public static boolean isNumeric(String str) {
	    int len = str.length();
	    for (int i = 0; i < len; ++i) {
			if(str.charAt(i) == '-' || str.charAt(i) == '+'){
				continue;
			}
			if (!Character.isDigit(str.charAt(i))) {
	            return false;
	        }	     	
	    }	  
	    return true;
	}

	/**
	 * Prompts user for input and returns a numeric array
	 * containing the x,y values for a coordinate
	 * @return a numeric array with values for x and y
	 **/
	public static int[] readCoordinate(){
		boolean valid;
		int x = -99,y = -99;
		Scanner scan;
		do{
			valid = true;
			String[] xy;
			System.out.println("Please Input Coordinates:");
			scan = new Scanner(System.in);
			String input = scan.nextLine();
			xy = input.split(",");
			// check whether inputs contains x and y values
			if(xy.length != 2){
				valid = false;
				System.out.println("Invalid input. Please enter two numeric values seperated by comma");
				continue;
			}
			// check whether x is numeric
			if(!isNumeric(xy[0])){
				valid = false;
				System.out.println("Invalid input. Please enter numeric values");
				continue;
			}
			// check whether y is numeric
			if(!isNumeric(xy[1])){
				valid = false;
				System.out.println("Invalid input. Please enter numeric values");
				continue;
			}
			x = Integer.parseInt(xy[0]);
			y = Integer.parseInt(xy[1]);
			if(x< -10 || x > 10 || y < -10 || y > 10){
				valid = false;
				System.out.println("Coordinate value outside range. Please enter values between -10 and 10");
			}			
		}while(!valid);
		
		scan.close();

		if(x == -99 || y == -99){
			return null;
		}
		int[] coordinate = {x,y};
		
		return coordinate;		
	}	
	
	/** Sorts an array in ascending order */
	public static void sort(Coordinate[] coordinates){
		int len = coordinates.length;
		boolean unsorted = true;
		while(unsorted){
			unsorted = false;
			for(int j = 0; j < len-1; j++ ){
				if(coordinates[j].getDistance() > coordinates[j+1].getDistance() ){
					Coordinate temp = coordinates[j];
					coordinates[j] = coordinates[j+1];
					coordinates[j+1] = temp;
					unsorted = true;
				}
			}
		}
	}
	
	/**
	 * The main Method */
	public static void main(String[] args) {
		Coordinate[] coordinates = new Coordinate[TOTAL_EVENTS];
		int min = -10;
		int max = 10;
	
		Random random = new Random();
		//random.setSeed(20);

		int[] xy = readCoordinate();
		if(xy != null){
			for(int i = 0; i < TOTAL_EVENTS; i++){
				int x = random.nextInt((max - min) + 1) + min;
				int y = random.nextInt((max - min) + 1) + min;					
				int distance = Math.abs(x - xy[0]) +  Math.abs(y - xy[1]);
				coordinates[i] = new Coordinate(x, y, new Event(i+1), distance);			
			}
			
			System.out.println("Closest Events to ("+ xy[0] + "," + xy[1]+ "):");
			
			// sort coordinates entry in array
			sort(coordinates);
			
			for(int i = 0; i < 5; i++){
				System.out.printf("Event %d  - $%.2f, Distance %d\n", 
						coordinates[i].getEvent().getEventId(),
						coordinates[i].getEvent().getCheapestTicket(),
						coordinates[i].getDistance());
			}
		}
		else{
			System.out.println("Invalid input");
		}
	}
}
