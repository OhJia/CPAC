/*************************************************
* Converter Class					     	     *	 
* 											     *
* Take an infix expression and convert it to     *
* a postfix expression.                          *
*												 *
* Written by Jiashan Wu   						 *
* Date: December 12, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.util.ArrayList;

public class Converter {
	ArrayList<Token> tokens = new ArrayList<Token>();
	LinkedStack<Token> stack = new LinkedStack<Token>();
	String output;
	String input;

	public Converter(String _input){
		output = "";
		input = _input;
		toPostFix(input);
	}

	public String toPostFix(String _input) {
		
		// Tokenize input string into a list of tokens
		char[] input = _input.toCharArray();
		String inputString = "";
		for (int i = 0; i < input.length; i++) {
			if (Character.isDigit(input[i])) {
				String numberString = input[i] + ""; 
				for (int j = i + 1; j < input.length; j++) {
					if (Character.isDigit(input[j])) {
						numberString += input[j];
						i = j;
					}
					else break;
				}
				tokens.add(new Token(numberString));

			} else if (input[i] == '*' || input[i] == '/' || input[i] == '+' || 
				input[i] == '^' || input[i] == '-' || input[i] == '(' || 
				input[i] == ')') {				
				inputString = input[i] + "";
				tokens.add(new Token(inputString));
			}
		}

		// Go through all tokens in list
		for (Token t : tokens) {
			
			// If is operand, add to output string
			if (t.operand) {
				output += t.info + " ";
				
			} else if (t.parenthesis) {
				// If is open parenthesis, push to stack
				if (t.info.equals("(")) stack.push(t);
				
				// If is closed parenthesis, 
				// popout all operators on stack and append to output
				// until find matching parenthesis
				else {
					while (!stack.top().info.equals("(")) {
						output += stack.top().info + " ";
						stack.pop();
					}
					stack.pop();
				}

			// If is operator
			} else {
				// If stack is empty, push operator to stack
				if (stack.isEmpty()) stack.push(t); 
				// If top of stack is (, push operator to stack
				else if (stack.top().info.equals("(")) stack.push(t); 
				else {
					// While operator on stack has higher or equal precedence,
					// append operator in stack to output and pop it
					while (!stack.isEmpty() && t.precedence <= stack.top().precedence) {
						output += stack.top().info + " ";
						stack.pop();
					}
					// push operator to stack
					stack.push(t);
				}
			}
		} // Finished all tokens

		// Add rest of stack to output string
		while (!stack.isEmpty()) {
			output += stack.top().info + " ";
			stack.pop();
		}

		return output;

	} // End of convertToPostfix()

}