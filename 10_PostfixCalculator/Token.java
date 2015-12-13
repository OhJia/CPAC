/*************************************************
* Token Class					     	         	 
* 											     
* Takes a string and checks whether the element  
* is an operand, a parenthesis, or operator.     
* If it's an operator, assign precedence.                        
*												 
* Written by Jiashan Wu   						
* Date: December 12, 2015  						 
*************************************************/

public class Token{

    boolean operator =  false;
    boolean operand = false;
    boolean parenthesis = false;
    int precedence = 0;
    String info;
    
    Token(String s){
		tokenize(s);
		info = s;
    }

    void tokenize(String s){
    	char c = s.toCharArray()[0];
		if(Character.isDigit(c)) operand = true;
		else if(c == '(' || c == ')') parenthesis = true;
		else if(c == '^'){
			operator = true;
			precedence = 3;
		}else if(c == '*' || c == '/'){
			operator = true;
			precedence = 2;
		}else if( c == '+' || c == '-' ){
			operator = true;
			precedence = 1;
		}
    }
} // End of Token class