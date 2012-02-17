/**
 * 
 */
package com.cobusbernard.shoppa.services;

import java.util.List;

import com.cobusbernard.shoppa.data.ShoppingItem;

/**
 * Defines the contract for the Shoppa services.
 * 
 * @author Cobus Bernard
 */
public interface IShoppaService {

	public List<ShoppingItem> getShoppingList();
	
}
