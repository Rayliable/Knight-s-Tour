package codes;

public class Main { //Knight's tour program!

	public static LinkedGrid Grid = new LinkedGrid(6);
	
	public static int solutions = 0;
	
	public static void main(String[] args) {
		
		Grid.setSecondaryPoints(); //Comment this line for slower code
		
		Grid.getFirst().kTour(1);
		
		System.out.println("Solutions: " +solutions);
	}

}
