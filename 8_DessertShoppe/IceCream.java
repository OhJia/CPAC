/*************************************************
* Ice Cream Class						     	 	 
* 											     
* Derived from DessertItem class. 				 
* Provide method to get the cost.                
* 												 
* Written by Jiashan Wu   						 
* Date: November 15, 2015  						 
*************************************************/

import java.lang.Math;

public class IceCream extends DessertItem {

	private int cost;

	// Constructor
	public IceCream(String _name, int _cost) {
		super(_name);
		cost = _cost < 0 ? 0 : _cost;
	}

	public int getCost() {
		return cost;
	}
}