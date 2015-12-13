/*************************************************
* CARS 										     *
* Set ignition state, color, and (x,y) for car,  *
* then ask user for action: turn the ignition    *
* on and off, or move the car horizontally or    *
* vertically. Display car information and        *
* current (x,y) on 20x20 grid after each action. * 
*												 *
* Written by Jiashan Wu   						 *
* Date: October 8, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.util.Scanner;

public class Cars{

	public static void main(String args[]){
		
		/* Set initial color, position and ignition state 
			for an array of 10 cars */
		char[] colors = new char[10];		
		int x []= new int[10];
		int[] y = new int[10];
		boolean[] ignition = new boolean[10];

		for (int i = 0; i < 10; i++) {
			colors[i] = setRandomColor();
			x[i] = (int)(Math.random() * 20) + 1;
			y[i] = (int)(Math.random() * 20) + 1;
			ignition[i] = false;
		}

		// Variables for car choice while loops
		boolean askCarChoice = true;
		int carIndex = -100;
		
		// Variables for getting and storing user inputs
		Scanner myScanner = new Scanner(System.in);
		String choiceString;
		char choice = 0;
		String directionChoiceString;
		char directionChoice;
		int spaces = 0;

		boolean quit = false;
		
		while (!quit) {

			/*****************************************************************************
				Ask the user for car choice and check for validity
				then report the state of the car chosen 
			******************************************************************************/
			while (askCarChoice) {				
				carIndex = -100;
				while (carIndex < 0 || carIndex > 9) {
					// Check that the invalid choice is not the inital assignment
					if (carIndex != -100) {
						System.out.println("\n*********************************\n" + 
									     	 "*  That was not a valid choice. *\n" +
								     	     "*     Please select again.      *\n" +
								     	     "*********************************");
					}

					System.out.println("\nWhich car would you like to use next (1-10)?");

					// Check that the user has entered an int
					while (!myScanner.hasNextInt()) {
						System.out.println("\n*********************************\n" + 
									     	 "*  That was not a valid choice. *\n" +
								     	     "*     Please select again.      *\n" +
								     	     "*********************************");
						System.out.println("\nWhich car would you like to use next (1-10)?");
						myScanner.nextLine();
					}
					carIndex = myScanner.nextInt() - 1;
				}
				reportState(carIndex, colors[carIndex], ignition[carIndex], 
					x[carIndex], y[carIndex]);
				askCarChoice = false;
			}
			
			/****************************** End of car choice ****************************/

			System.out.println("\nWhat would you like to do?\n" +
						   "1 - turn the ignition on/off\n" +
						   "2 - change the position of car\n" + 
						   "3 - quit this program");
			
			choiceString = myScanner.next();
			choice = choiceString.charAt(0);

			switch (choice){

				case '1':
					ignition[carIndex] = changeIgnition(ignition[carIndex]);
					reportState(carIndex, colors[carIndex], ignition[carIndex], 
						x[carIndex], y[carIndex]);
					break;
				
				case '2':
					System.out.println("\nIn which direction would you " + 
										"like to move the car?\n" + 
										"1 - horizontal\n" +
										"2 - vertical");
					directionChoiceString = myScanner.next();
					directionChoice = directionChoiceString.charAt(0);

					// Based on choice of direction, ask for spaces and move car
					if (directionChoice == '1'){
						System.out.println("\nHow far (negative value to move left)?");
						spaces = myScanner.nextInt();
						x[carIndex] = moveHorizontally(ignition[carIndex], x[carIndex], spaces);
					} else if (directionChoice == '2'){
						System.out.println("\nHow far (negative value to move up)?");
						spaces = myScanner.nextInt();
						y[carIndex] = moveVertically(ignition[carIndex], y[carIndex], spaces);
					} 

					reportState(carIndex, colors[carIndex], ignition[carIndex], 
						x[carIndex], y[carIndex]);	
					askCarChoice = true;						
					break;
				
				case '3': 
					quit = true;
					reportState(carIndex, colors[carIndex], ignition[carIndex], 
						x[carIndex], y[carIndex]);
					break;
				
				default:
					System.out.println("\n*********************************\n" + 
							     	     "*  That was not a valid choice. *\n" +
							     	     "*     Please select again.      *\n" +
							     	     "*********************************");
					break;
			}

			//reportState(carIndex, colors[carIndex], ignition[carIndex], x[carIndex], y[carIndex]);

		} // End loop for user choice
		
	} /********** End of main() ****************/
	

	public static char setRandomColor(){ 
		final char[] COLORS = {'R', 'G', 'B', 'W', 'S'};
		int colorNumber = (int)(Math.random() * 5);
		return COLORS[colorNumber];
	}

	public static boolean changeIgnition(boolean ignition){
		return !ignition;
	}

	public static int moveHorizontally(boolean ignition, int x, int spaces){
		int tempX = 0;
		if (!ignition) {
			System.out.println("\n*****************************\n" + 
							     "*    The ignition is off.   *\n" +
							     "*     Please turn it on.    *\n" +
							     "*****************************");
			return x;
		} else {
			tempX = x + spaces;
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

	public static int moveVertically(boolean ignition, int y, int spaces){
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

	public static void reportState(int index, char color, boolean ignition, int x, int y){
		index++;
		System.out.println("\nCAR #" + index + " INFORMATION");
		
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
