/*************************************************
* TEST CAR PROGRAM 							    
* Create an array of 10 Car instances. 			 
* Ask user for action: turn the ignition         
* on and off, or move the car horizontally or    
* vertically. Display car information and        
* current (x,y) on 20x20 grid after each action.  
*												 
* Written by Jiashan Wu   						 
* Date: November 5, 2015  						 
*************************************************/

import java.util.Scanner;

public class TestCars{

	public static void main(String args[]){
		
		/* Create an array of 10 Car instances */
		Car[] car = new Car[10];
		for (int i = 0; i < 10; i++) {
			car[i] = new Car(i);
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
				Ask the user for car choice 
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
				System.out.println(car[carIndex].toString());
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
					car[carIndex].changeIgnitionState();
					System.out.println(car[carIndex].toString());
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
						car[carIndex].moveHorizontally(spaces);
					} else if (directionChoice == '2'){
						System.out.println("\nHow far (negative value to move up)?");
						spaces = myScanner.nextInt();
						car[carIndex].moveVertically(spaces);
					} 

					System.out.println(car[carIndex].toString());	
					askCarChoice = true;						
					break;
				
				case '3': 
					quit = true;
					System.out.println(car[carIndex].toString());
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

} // END
