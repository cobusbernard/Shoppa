/**
 * 
 */
package com.cobusbernard.shoppa.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cobusbernard.shoppa.R;
import com.cobusbernard.shoppa.constants.Constants;
import com.cobusbernard.shoppa.data.ShoppingItem;

/**
 * Adapter used to scroll the list of items.
 * 
 * @author Cobus Bernard
 * @company Global Kinetic
 *
 * @version: $Revision$
 */
public class ShoppingItemListAdapter extends BaseListAdapter<ShoppingItem> {

	/**
	 * Default constructor.
	 * 
	 * @param c		the context.
	 * @param list	the list to construct the adapter with.
	 */
	public ShoppingItemListAdapter(Context c, List<ShoppingItem> list) {
		super(c, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout rowLayout;
		ShoppingItem item = this.list.get(position);

		rowLayout = (LinearLayout)LayoutInflater.from(this.context).inflate(R.layout.rowlayout_item , parent, 
			false);
		
		TextView itemTextView = (TextView)rowLayout.findViewById(R.id.item_row_name);
		itemTextView.setText(item.getName());
		
		CheckBox itemCheckBox = (CheckBox)rowLayout.findViewById(R.id.item_row_checkbox);
		itemCheckBox.setChecked(item.isInBasket());
		
		rowLayout.setBackgroundColor(Constants.listColors[position % 2]);
        return rowLayout;
	}

	@Override
	public long getItemId(int position) {
		//FIXME: need to figure out how to handle this.
		return 0;
	}

}
