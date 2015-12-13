/*************************************************
* Sundae Class						     	     *	 
* 											     *
* Derived from IceCream class. Provide methods   *
* to get the cost and get the ice cream name.    *
* 												 *
* Written by Jiashan Wu   						 *
* Date: November 15, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.lang.Math;

public class Sundae extends IceCream {

	private int costTopping;
	private int cost;
	private String iceCreamName;

	// Constructor
	public Sundae(String _nIceCream, int _cIceCream, 
					String _nTopping, int _cTopping) {
		
		super(_nIceCream, _cIceCream);		
		formatName(_nTopping);
		costTopping = _cTopping < 0 ? 0 : _cTopping;
	}

	/* Format name for receipt
	 e.g. Caramel Sundae with
	      Vanilla Ice Cream */
	private void formatName(String _nTopping) {
		iceCreamName = super.name;
		super.name = _nTopping + " Sundae with\n" + super.name;
	}

	// Get only the ice cream name
	// Used to calculate spaces in the receipt
	public String getIceCreamName() {
		return iceCreamName;
	}

	public int getCost() {
		cost = Math.round((float)(super.getCost() + costTopping));
		return cost;
	}
}

