/****************************************************
* SmallInt class 							        *
* Stores input value, checks whether within range   *
* Generates decimal, binary, and hexidecimal values *
* and return as Strings                             *
*												    *
* Written by Jiashan Wu   						    *
* Date: October 28, 2015  						    *
* NYU ID: N15996627  							    *
****************************************************/

public class SmallInt {
	private int value;
	// public static final int MAXVALUE = 1000;
	public static final int MAXVALUE = 1000;

	public SmallInt(int input){
		this.value = checkError(input);
	}

	public String getDec() {
		return "" + this.value;
	}

	public void setDec(int newInt) {
		this.value = checkError(newInt);
		return;
	}

	/* 
		Generate and return Binary String
	*/
	public String getBin() {
		String binaryString = "";  
		int bit, quotient;
		
		// Store value from instance of class in int number
		int number = this.value; 
		
		// if number is 0, set binaryString as 0 
		if (number == 0){ 
			binaryString = "0";
		} else {
			while(number > 0){ // Until number is 0
				
				// Continuously set bit as remainder of number 
				// divide by 2, which is always 0 or 1.
				// Add each new bit (0 or 1) to binaryString 
				// on the left side.
				bit = number % 2;
				binaryString = bit + binaryString;
				
				// Continuously set quotient as int value 
				// of number divide by 2, assign number as 
				// new quotient value
				quotient = (int)(number / 2);				
				number = quotient;
			}
		}
		return binaryString;
	}

	/* 
		Generate and return Hexidecimal String
	*/
	public String getHex() {
		String hexString = ""; 
		String[] hexBits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", 
							"A", "B", "C", "D", "E", "F"};
		int bit, quotient;

		// Store value from instance of class in int number
		int number = this.value;

		// if number is 0, set hexString as 0 
		if (number == 0){
			hexString = "0";
		} else {
			while(number > 0){ // Until number is 0

				// Continuously set bit as remainder of number 
				// divide by 16, which is always an integer
				// between 0 and 15. Get the correponding string 
				// from the hexBits array.
				// Add each string (0 or 1) to hexString 
				// on the left side.
				bit = number % 16;
				hexString = hexBits[bit] + hexString;
				
				// Continuously set quotient as int value 
				// of number divide by 16, assign number as 
				// new quotient value
				quotient = (int)(number / 16);				
				number = quotient;
			}
		}		
		return hexString;
	}

	private int checkError(int number) {
		if (number < 0 || number > MAXVALUE){
			System.out.println("\n*********************************\n" + 
					     	     "     error: not an integer       \n" +
					     	     "     between 0 and " + MAXVALUE+"\n" +
					     	     "*********************************");
			return 0;
		} else {
			return number;
		}
	}

}