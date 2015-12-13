/*************************************************
* CAR  										     
* Set ignition state, color, and (x,y) for car,  
* then ask user for action: turn the ignition    
* on and off, or move the car horizontally or    
* vertically. Display car information and        
* current (x,y) on 20x20 grid after each action.  
*												 
* Written by Jiashan Wu   						 
* Date: October 1, 2015  						 
*************************************************/

import java.util.Scanner;

public class Car{

	public static void main(String args[]){
		
		// Set initial color, position and ignition state 
		char color = setRandomColor();		
		int x = setRandomPosition();
		int y = setRandomPosition();
		boolean ignition = false;

		// For getting and storing user inputs
		Scanner myScanner = new Scanner(System.in);
		String directionChoiceString;
		char directionChoice;
		int spaces = 0;

		boolean quit = false;
		
		while (!quit) {
			System.out.println("\nWhat would you like to do?\n" +
						   "1: turn the ignition on/off\n" +
						   "2: change the positoin of car\n" + 
						   "Q: quit this program");
			String choice = myScanner.next();

			switch (choice){

				case "1":
					ignition = changeIgnition(ignition);
					reportState(color, ignition, x, y);
					break;
				
				case "2":
					System.out.println("\nIn which direction would you " + 
						"like to move the car?\n" + 
						"H: horizontal\n" +
						"V: vertical");
					directionChoiceString = myScanner.next();
					directionChoice = directionChoiceString.charAt(0);

					// Based on choice of direction, ask for spaces and move car
					if (directionChoice == 'H' || directionChoice == 'h'){
						System.out.println("\nHow far (negative value to move left)?");
						spaces = myScanner.nextInt();
						x = moveHorizontally(ignition, x, spaces);
					} else if (directionChoice == 'V' || directionChoice == 'v'){
						System.out.println("\nHow far (negative value to move up)?");
						spaces = myScanner.nextInt();
						y = moveVertically(ignition, y, spaces);
					}

					reportState(color, ignition, x, y);							
					break;
				
				case "q": case "Q":
					quit = true;
					reportState(color, ignition, x, y);
					break;
				
				default:
					System.out.println("\n*********************************\n" + 
							     	     "*  That was not a valid choice. *\n" +
							     	     "*     Please select again.      *\n" +
							     	     "*********************************");
					break;
			}

		} // End loop for user choice
		
	} /********** End of main() ****************/
	
	public static int setRandomPosition(){
		int position = (int)(Math.random() * 20) + 1;
		return position;
	}

	public static char setRandomColor(){ 
		final char[] COLORS = {'R', 'G', 'B', 'W', 'S'};
		int colorNumber = (int)(Math.random() * 5);
		return COLORS[colorNumber];
	}

	public static Boolean changeIgnition(Boolean ignition){
		return !ignition;
	}

	public static int moveHorizontally(Boolean ignition, int x, int spaces){
		int tempX = 0;
		if (!ignition) {
			System.out.println("\n*****************************\n" + 
							     "*    The ignition is off.   *\n" +
							     "*     Please turn it on.    *\n" +
							     "*****************************");
			return x;
		} else {
			tempX = x + spaces;
			//System.out.println("IGNITION IS ON! tempX: "+tempX);
			if (tempX > 20 || tempX < 1){
				System.out.println("\n*****************************\n" + 
							         "* Oops. Can't move that far *\n" +
							         "*****************************");
				return x;
			} else {
				return tempX;
			}
		}
	}

	public static int moveVertically(Boolean ignition, int y, int spaces){
		int tempY = 0;
		if (!ignition) {
			System.out.println("\n*****************************\n" + 
							     "*    The ignition is off.   *\n" +
							     "*     Please turn it on.    *\n" +
							     "*****************************");
			return y;
		} else {
			tempY = y + spaces;
			if (tempY > 20 || tempY < 1){
				System.out.println("\n*****************************\n" + 
							         "* Oops. Can't move that far *\n" +
							         "*****************************");
				return y;
			} else {
				return tempY;
			}
		}
	}

	public static void reportState(char color, boolean ignition, int x, int y){
		
		System.out.println("\nCAR INFORMATION");
		
		switch (color) {
			case 'R':
				System.out.println("Color: red");
				break;
			case 'G':
				System.out.println("Color: green");
				break; 
			case 'B':
				System.out.println("Color: blue");
				break;
			case 'W':
				System.out.println("Color: white");
				break;
			case 'S':
				System.out.println("Color: silver");
				break;
			default:
				break;
		}

		if (ignition)
			System.out.println("Ignition: on");
		else 
			System.out.println("Ignition: off");

		System.out.println("Location: " + "(" + x + ", " + y + ")\n");

		for (int v = 0; v < 20; v++){
			for (int h = 0; h < 20; h++){
				if (v + 1 == y && h + 1 == x)
					System.out.print(color + " ");
				else 
					System.out.print("- ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
	
	} // End of reportState()

} // END
