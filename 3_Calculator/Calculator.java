/***************************************
* CALCULATOR
* Ask user for input and operator,
* then calculate the answer. 
* Enter c to clear answer and x to exit. 

* Written by Jiashan Wu
* Date: September 23, 2015
* NYU ID: N15996627
****************************************/

import java.util.Scanner; 

public class Calculator {
	public static void main(String[] args){

		double input2 = 0.0;
		double answer= 0.0;
		String operator = "";
		boolean divideByZero = false;
		
		// Get 1st input, operator and 2nd input
		Scanner userInput = new Scanner(System.in); 	
		System.out.print("1st input: ");
		answer = userInput.nextDouble();		
		System.out.print("op: ");
		operator = userInput.next();
		System.out.print("2nd input: ");
		input2 = userInput.nextDouble();

		// If operator is x, exit the program
		while (!operator.equals("x")) {

			if (operator.equals("+") || operator.equals("-") || 
			operator.equals("*") || operator.equals("/")) {

				// If divide by 0, show error message and skip to line 76
				if (operator.equals("/") && Math.abs(input2-0.0) <= 0.000001) {
					System.out.println("Error: division by zero");
					divideByZero = true;
				}

				// calculate
				switch (operator){
					case "+":
						answer = answer + input2;
						System.out.println("ans: " + answer);
						break;
					case "-":
						answer = answer - input2;
						System.out.println("ans: " + answer);
						break;
					case "*":
						answer = answer * input2;
						System.out.println("ans: " + answer);
						break;
					case "/":
						if (!divideByZero) {
							answer = answer / input2;
							System.out.println("ans: " + answer);
						}						
						break;
					default:
						break;
				}
				
				System.out.print("op: ");
				operator = userInput.next();

			} 

			// If operator is c, reset answer as 0 and ask for operator
			if (operator.equals("c")) {
				answer = 0.0;
				System.out.println("ans: " + answer);
				System.out.print("op: ");
				operator = userInput.next();

			} 

			// If operator is unknown, show error message and ask for operator
			if (!operator.equals("+") && !operator.equals("-") && 
			!operator.equals("*") && !operator.equals("/") && 
			!operator.equals("c") && !operator.equals("x")) {
				System.out.println("Error: Unknown operator $");
				System.out.print("op: ");
				operator = userInput.next();
			}

			// get more input 
			if (!operator.equals("x")) {
				System.out.print("more input: ");
				input2 = userInput.nextDouble();
			}			

		} // End program is operator is x

	} // End main
}
