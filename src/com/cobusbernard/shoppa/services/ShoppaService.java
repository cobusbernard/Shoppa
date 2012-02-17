/**
 * 
 */
package com.cobusbernard.shoppa.services;

import java.util.ArrayList;
import java.util.List;

import com.cobusbernard.shoppa.data.ShoppingItem;

/**
 * @author cobus
 *
 */
public class ShoppaService implements IShoppaService {

	/* (non-Javadoc)
	 * @see com.cobusbernard.shoppa.services.IShoppaService#getShoppingList()
	 */
	@Override
	public List<ShoppingItem> getShoppingList() {

		//TODO: Implement this.
		
		ArrayList<ShoppingItem> list = new ArrayList<ShoppingItem>();
		
		list.add(new ShoppingItem("Bread", false));
		list.add(new ShoppingItem("Milk", true));
		list.add(new ShoppingItem("Eggs", false));
		list.add(new ShoppingItem("Dog Food", false));
		
		return list;
	}

}
