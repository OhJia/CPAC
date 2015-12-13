/*************************************************
* Postfix Calculator					     	 *	 
* 											     *
* Prompt user for an infix expression, and       *
* convert it to postfix expression with an       *
* instance of Converter class. Evaluate the      *
* postfix expression, print the converted        *
* postfix expression, and evaluated answer.	     *	
*											     *
* Written by Jiashan Wu   						 *
* Date: December 4, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		System.out.println("type your infix expression: ");
      	String infixInput = myScanner.nextLine();

      	// Convert infix expression into postfix
		Converter postfix = new Converter(infixInput);
		System.out.println("converted to postfix: " + postfix.output);

		// Evaluate postfix expression
		double answer = evaluate(postfix.output);
		System.out.println("answer is " + answer);

	}

	public static double evaluate(String postfix) {
		
		double answer = 0.0;
		String[] postfixArray = postfix.split(" ");
		ArrayList<Token> tokens = new ArrayList<Token>();
		LinkedStack<Token> evalStack = new LinkedStack<Token>();

		// Tokenize strings in postfix to list of tokens
		for (int i = 0; i < postfixArray.length; i++) {
			tokens.add(new Token(postfixArray[i]));
		}

		// Go through all tokens
		for (int i = 0; i < tokens.size(); i++) {
			// If token is operand, push to stack
			if (tokens.get(i).operand) {
				evalStack.push(tokens.get(i));
			
			// If token is operator 
			} else {
				// Store operator in variable,
				// Store last two numbers in stack in variables, and pop them
				String operator = tokens.get(i).info;
				double number2 = Double.parseDouble(evalStack.top().info);
				evalStack.pop();
				double number1 = Double.parseDouble(evalStack.top().info);
				evalStack.pop();
				
				// Calculations between two numbers
				if (operator.equals("+")) {answer = number1 + number2;}
				else if (operator.equals("-")) {answer = number1 - number2;}
				else if (operator.equals("/")) {answer = number1 / number2;}
				else if (operator.equals("*")) {answer = number1 * number2;}
				else if (operator.equals("^")) {answer = Math.pow(number1, number2);}

				// Push calculated answer to stack
				evalStack.push(new Token(answer + ""));
			}

		} // finish going through all tokens

		return answer;

	}

}