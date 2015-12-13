/*************************************************
* Candy Class						     	     *	 
* 											     *
* Derived from DessertItem class. 				 *
* Provide methods to get the cost, get the       *
* weight of candy, and get the price (/lb.)      *	
*											     *
* Written by Jiashan Wu   						 *
* Date: November 15, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.lang.Math;

public class Candy extends DessertItem {

	private double weight;
	private int pricePerLb;
	private int cost;

	// Constructor
	public Candy(String _name, double _weight, int _price) {
		super(_name);
		setWeight(_weight);
		setPrice(_price);
	}

	public void setWeight(double _weight) {
		weight = _weight < 0.0 ? 0.0 : _weight;
	}

	public double getWeight() {
		return weight;
	}

	public void setPrice(int _price) {
		pricePerLb = _price < 0 ? 0 : _price;
	}

	public int getPrice() {
		return pricePerLb;
	}

	public int getCost() {
		cost = Math.round((float)(weight * pricePerLb));
		return cost;
	}
}