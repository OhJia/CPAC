/*************************************************
* Cookie Class						     	     	 
* 											     
* Derived from DessertItem class. 				 
* Provide methods to get the cost, get the       
* number of cookies, and get the price (/dz.)    	
*											     
* Written by Jiashan Wu   						 
* Date: November 15, 2015  						 
*************************************************/

import java.lang.Math;

public class Cookie extends DessertItem {

	private int number;
	private int pricePerDozen;
	private int cost;

	// Constructor
	public Cookie(String _name, int _number, int _price) {
		super(_name);
		setNumber(_number);
		setPrice(_price);
	}

	public void setNumber(int _number) {
		number = _number < 0 ? 0 : _number;
	}

	public int getNumber() {
		return number;
	}

	public void setPrice(int _price) {
		pricePerDozen = _price < 0 ? 0 : _price;
	}

	public int getPrice() {
		return pricePerDozen;
	}

	public int getCost() {
		cost = Math.round((float)(number / 12.0 * pricePerDozen));
		return cost;
	}
}