/****************************************************
* TestSmallInt  							        
* Ask user for input, and use input to test         
* class SmallInt, print input as decimal,           
* binary, and hexidecimal                           
*											        
* Written by Jiashan Wu   						    
* Date: October 28, 2015  						    
****************************************************/

import java.util.Scanner;

public class TestSmallInt{
	public static void main(String[] args){
		int number;

		System.out.println("Input an integer between 0 and " + SmallInt.MAXVALUE);
		Scanner myScanner = new Scanner(System.in);
		number = myScanner.nextInt();
		SmallInt testInt = new SmallInt(number);

		// SmallInt testInt = new SmallInt(45);
		// testInt.setDec(number);
		
		System.out.println("***** Testing using value " + number + " *****");
		System.out.println("Decimal: " + testInt.getDec());
		System.out.println("Binary: " + testInt.getBin());
		System.out.println("Hexidecimal: " + testInt.getHex());
	}
}