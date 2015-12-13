/*************************************************
* Game of Life						     	     *	 
* 											     *
* Read initial world from a file and repeatedly  *
* generate new generations based on rules from   *
* the Game of Life. Program terminates when the  *
* world is empty, the new generation is the      *
* same as the last one, or when the user types x *       
*												 *
* Written by Jiashan Wu   						 *
* Date: December 4, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.util.Scanner;
import java.io.*;

public class GameOfLife {
	public static void main (String [] args) {

		final int M = 25;
		final int N = 75;
		char [][] oldGeneration = new char[M+2][N+2];
		char [][] newGeneration = new char[M+2][N+2];

		// Read file, print it, and store initial world in oldGeneration
		oldGeneration = getInitialWorldAndPrint(oldGeneration);
		// Copy values in the oldGeneration into newGeneration
		copyArray(oldGeneration, newGeneration);

		Scanner consoleReader = new Scanner(System.in);
		System.out.println();
		System.out.println("Type any letter to see new generation,\n" +
							"type x to terminate the program: ");		
		String userInput = consoleReader.next();

		int neighbors; 
		int generationNumber = 1;
		Boolean worldIsEmpty = false;
		int changedCells; // Keep track of number of changed cells

		// Generate new generation until user types x
		while (!userInput.equals("x")) {
			System.out.println();
			System.out.println("GENERATION " + generationNumber);				
			
			changedCells = 0; 

			for (int i = 0; i <= M+1; i++) {
				for (int j = 0; j <= N+1; j++) {
					// If border, leave empty
					if (i == 0 || i == M+1 || j == 0 || j == N+1){
						newGeneration[i][j] = '.';
					} else {
						neighbors = numberOfNeighbors(oldGeneration, i, j);
						// If occupied
						if (oldGeneration[i][j] == 'X') {
							if (neighbors != 2 && neighbors != 3) {
								newGeneration[i][j] = '.';
								changedCells += 1;
							} 
						// If empty
						} else {
							if (neighbors == 3) {
								newGeneration[i][j] = 'X';
								changedCells += 1;
							}
						}
					}
					System.out.print(newGeneration[i][j]);
				}
				System.out.println();
			}

			// Check whether world is empty
			worldIsEmpty = isWorldEmpty(newGeneration);
			if (worldIsEmpty) {
				System.out.println("\n*******************************\n" + 
							         "*       World is empty.       *\n" +
							         "*          Bye bye.           *\n" +
							         "*******************************");
				System.out.println();
				break;
			// If no cells have changed
			} else if (changedCells == 0) {
				System.out.println("\n*******************************\n" + 
							         "*    World has not changed.   *\n" +
							         "*           Bye bye.          *\n" +
							         "*******************************");
				System.out.println();
				break;
			}

			// Copy values in the newGeneration into oldGeneration
			copyArray(newGeneration, oldGeneration);
			generationNumber += 1;

			System.out.println();
			System.out.println("Type any letter to see new generation,\n" +
								"type x to terminate the program: ");	
			userInput = consoleReader.next();
			System.out.println();			
		
		} // End of while loop

	} 
	/*** End of main() ***/

	// Read file, print it, and store initial world in oldGeneration
	public static char[][] getInitialWorldAndPrint(char[][] world){
		
		Scanner consoleReader = new Scanner(System.in);
		System.out.print ("Which file do you want to open? ");		
		String filename = consoleReader.next();
		FileStringReader fileString = new FileStringReader(filename);

		String line = "";

		// Print initial world from file
	    System.out.println();
		System.out.println("GENERATION 0");
		for (int i = 0; i <= world.length-1; i++) {
			if(i == 0 || i == world.length-1) 
				line = "...........................................................................";				
		    else 
				line = fileString.readLine();

			for (int j = 0; j <= world[i].length-1; j++) {
				if (j == 0 || j == world[i].length-1) 
					world[i][j] = '.';
			    else 
			    	world[i][j] = line.charAt(j-1);
				System.out.print(world[i][j]);
			}
			System.out.println();
		}

		fileString.close(); 
		return world;
	}

	public static void copyArray(char[][] original, char[][] copy){
		for(int i=0; i<original.length; i++)
		  for(int j=0; j<original[i].length; j++)
		    copy[i][j]=original[i][j];
	}

	public static int numberOfNeighbors(char[][] world, int i, int j) {
		int neighbors = 0;
		neighbors += world[i-1][j-1] == 'X' ? 1 : 0;
		neighbors += world[i-1][j] == 'X' ? 1 : 0;
		neighbors += world[i-1][j+1] == 'X' ? 1 : 0;
		neighbors += world[i][j-1] == 'X' ? 1 : 0;
		neighbors += world[i][j+1] == 'X' ? 1 : 0;
		neighbors += world[i+1][j-1] == 'X' ? 1 : 0;
		neighbors += world[i+1][j] == 'X' ? 1 : 0;
		neighbors += world[i+1][j+1]  == 'X' ? 1 : 0;
		return neighbors;
	}

	public static Boolean isWorldEmpty(char[][] world){
		int occupied = 0;
		for (int i = 0; i < world.length; i++)
			for (int j = 0; j < world[i].length; j++)
				occupied += world[i][j] == 'X' ? 1 : 0;
		
		return occupied == 0;
	}

} // End of program