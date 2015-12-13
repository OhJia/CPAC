/*************************************************
* Checkout Class						     	 *	 
* 											     *
* Provide methods to enter items, clear, get     *
* the number of items, get the total cost,       *
* get the total tax, and get a receipt.          *
*												 *
* Written by Jiashan Wu   						 *
* Date: November 15, 2015  						 *
* NYU ID: N15996627  							 *
*************************************************/

import java.lang.Math;

public class Checkout {

	private DessertItem [] dessertItems;
	private int numberOfItems;
	private int totalCost;
	private int totalTax;
	private String receipt = "";

	// Constructor 
	public Checkout() {
		dessertItems = new DessertItem[100];
		numberOfItems = 0;
		totalCost = 0;
		totalTax = 0;
	}

	public int numberOfItems() {
		return numberOfItems;
	}

	public void enterItem(DessertItem item) {
		dessertItems[numberOfItems] = item;
		numberOfItems += 1;
	}

	public void clear() {
		for (int i = 0; i < numberOfItems; i++) {
			dessertItems[i] = null;
		}
		//dessertItems = new DessertItem[100];
		numberOfItems = 0;
		receipt = "";
	}

	public int totalCost() {
		totalCost = 0;
		for (int i = 0; i < numberOfItems; i++) {
			totalCost += dessertItems[i].getCost();
		}
		return totalCost;
	}

	public int totalTax() {
		totalTax = Math.round((float)(totalCost() * DessertShoppe.TAX_RATE / 100));
		return totalTax;
	}

	/************************************** 
	  Receipt String
	 *************************************/
	public java.lang.String toString() {

		// Calculate Cost + Tax
		int allTotalCost = totalCost() + totalTax();

		String itemPriceAsString; 
		String taxAsString = 
			DessertShoppe.cents2dollarsAndCents(totalTax());		
		String allCostAsString =
			DessertShoppe.cents2dollarsAndCents(allTotalCost);

		// Add header to receipt String
		receipt += "\n      " + DessertShoppe.STORE_NAME + "\n" + 
				     "      " + "--------------------\n\n";
		
		/* 
		   Loop through every item in the array, 
		   and add each item name and price to receipt String
		*/
		for (int i = 0; i < numberOfItems; i++) { 
			
			itemPriceAsString = 
				DessertShoppe.cents2dollarsAndCents(dessertItems[i].getCost());

			// If the item is a Candy, add info before name
			// e.g. 1.33 lbs. @ .89 /lb.
			if (dessertItems[i] instanceof Candy) {
				Candy candy = (Candy) dessertItems[i];
				receipt += candy.getWeight() + " lbs. @ " +
					DessertShoppe.cents2dollarsAndCents(candy.getPrice()) +
					" /lb.\n";
			// If the item is a Cookie, add info before name
			// e.g. 4 @ 3.99 /dz.
			} else if (dessertItems[i] instanceof Cookie) {
				Cookie cookie = (Cookie) dessertItems[i];
				receipt += cookie.getNumber() + " @ " +
					DessertShoppe.cents2dollarsAndCents(cookie.getPrice()) +
					" /dz.\n";
			} 
			
			// Add name 
			receipt += dessertItems[i].getName();
			
			// Add spaces after the name (use nameSpace())
			// If item is a Sundae, calculate spaces with ice cream name
			if (dessertItems[i] instanceof Sundae) {
				Sundae sundae = (Sundae) dessertItems[i];
				receipt += nameSpace(sundae.getIceCreamName());
			} else {
				receipt += nameSpace(dessertItems[i].getName());
			}

			// Add spaces before price (use priceSpace())
			receipt += priceSpace(itemPriceAsString);

			// Add price and carriage return			
			receipt += itemPriceAsString + "\n";
		
		} 
		/* 
		  End of loop 
		*/


		// Add formatted Tax and Total Cost
		receipt += "\n" +
				   "Tax" + nameSpace("Tax") + 
				   priceSpace(taxAsString) + taxAsString +
				   "\n" + 
				   "Total Cost" + nameSpace("Total Cost") +
				   priceSpace(allCostAsString) + allCostAsString +
				   "\n\n";

		return receipt;

	}
	/************************************** 
	  end of toString()
	 *************************************/

	// Calculate how many spaces to add after a name in the receipt	
	private String nameSpace(String s) {
		String spaces = "";
		int nameSpace = DessertShoppe.MAX_ITEM_NAME_SIZE - s.length();
		while (nameSpace > 0) {
			spaces += " ";
			nameSpace -= 1;
		}
		return spaces;
	}

	// Calculate how many spaces to add before a price in the receipt	
	private String priceSpace(String s) {
		String spaces = "";
		int priceSpace = DessertShoppe.COST_WIDTH - s.length();
		while (priceSpace > 0) {
			spaces += " ";
			priceSpace -= 1;
		}
		return spaces;
	}
}

