/*************************************************
* CAR CLASS							     		 *
* Creates a Car class. The constructor takes     *
* index number as argument and assigns color     *
* location (x, y), and ignition state.           *
* Static methods for moving instance of Car      * 
* horizontally and vertically, changing ignition * 
* state, getting color, ignition state, 		 * 
* x position, and y position. 					 * 
* toString method calls get methods and returns  * 
* a string of concatenated information for Car.  * 
*												 *
* Written by Jiashan Wu   						 *
* Date: November 5, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

public class Car {
	private char color;
	private String cString = "";
	private int x, y;
	private boolean ignition;
	private int index;
	private final char[] COLORS = {'R', 'G', 'B', 'W', 'S'};

	public Car(int index) {
		this.color = assignColor();
		this.x = (int)(Math.random() * 20) + 1;;
		this.y = (int)(Math.random() * 20) + 1;;
		this.ignition = false;
		this.index = index + 1;
	}

	public char assignColor() {		
		int colorNumber = (int)(Math.random() * 5);
		return this.COLORS[colorNumber];
	}

	public void moveHorizontally(int spaces) {
		int tempX = 0;
		if (!ignition) {
			System.out.println("\n*****************************\n" + 
							     "*    The ignition is off.   *\n" +
							     "*     Please turn it on.    *\n" +
							     "*****************************");
			
		} else {
			tempX = this.x + spaces;
			if (tempX > 20 || tempX < 1){
				System.out.println("\n*****************************\n" + 
							         "* Oops. Can't move that far *\n" +
							         "*****************************");
				
			} else {
				this.x = tempX;
			}
		}
	}

	public void moveVertically(int spaces) {
		int tempY = 0;
		if (!ignition) {
			System.out.println("\n*****************************\n" + 
							     "*    The ignition is off.   *\n" +
							     "*     Please turn it on.    *\n" +
							     "*****************************");
			
		} else {
			tempY = this.y + spaces;
			if (tempY > 20 || tempY < 1){
				System.out.println("\n*****************************\n" + 
							         "* Oops. Can't move that far *\n" +
							         "*****************************");
				
			} else {
				this.y = tempY;
			}
		}
	}

	public void changeIgnitionState() {
		this.ignition = !this.ignition;
	}

	public String getColor() {
		switch (this.color) {
			case 'R':
				this.cString = "red";
				break;
			case 'G':
				this.cString  = "green";
				break; 
			case 'B':
				this.cString  = "blue";
				break;
			case 'W':
				this.cString  = "white";
				break;
			case 'S':
				this.cString  = "silver";
				break;
			default:
				break;
		}
		return this.cString ;
	}

	public boolean getIgnitionStatus() {
		return this.ignition;
	}

	public int getXPos() {
		return this.x;
	}

	public int getYPos() {
		return this.y;
	}

	public String toString() {
		
		this.x = this.getXPos();
		this.y = this.getYPos();
		this.ignition = this.getIgnitionStatus();
		String ignitionString = "";
		String locationString = "";
		String drawString = "";

		String headerString = "\nCAR #" + this.index + " INFORMATION";
		String colorString = "\nColor: " + this.getColor();

		if (ignition)
			ignitionString = "\nIgnition: on";
		else 
			ignitionString = "\nIgnition: off";

		locationString = "\nLocation: " + "(" + this.x + ", " + this.y + ")\n";

		for (int v = 0; v < 20; v++){
			for (int h = 0; h < 20; h++){
				if (v + 1 == y && h + 1 == x)
					drawString += this.color + " ";
				else 
					drawString += "- ";
			}
			drawString += "\n";
		}
		drawString += "\n"; 

		return headerString + colorString + ignitionString + 
			locationString + drawString;
	}
}


		
