/**
 * 
 */
package com.cobusbernard.shoppa.data;

/**
 * This class represents an item in a shopping list.
 * 
 * @author Cobus Bernard
 */
public class ShoppingItem implements Comparable<ShoppingItem> {

	private String name;
	private boolean inBasket;
	
	
	/**
	 * Default constructor.
	 * 
	 * @param name		name of the shopping item.
	 * @param inBasket	whether the item has already been added to the basket.
	 */
	public ShoppingItem(String name, boolean inBasket) {
		super();
		this.name = name;
		this.inBasket = inBasket;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the inBasket
	 */
	public boolean isInBasket() {
		return inBasket;
	}

	/**
	 * @param inBasket the inBasket to set
	 */
	public void setInBasket(boolean inBasket) {
		this.inBasket = inBasket;
	}

	@Override
	public int compareTo(ShoppingItem another) {
		return this.name.compareTo(another.getName());
	}
	
}
