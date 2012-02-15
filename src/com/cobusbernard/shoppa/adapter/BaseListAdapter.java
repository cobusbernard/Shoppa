/**
 * 
 */
package com.cobusbernard.shoppa.adapter;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Abstract class to provide the common implementations for all list adapters.
 * 
 * @author Cobus Bernard
 * @company Global Kinetic
 *
 * @version: $Revision$
 */
public abstract class BaseListAdapter<T> extends BaseAdapter {

	protected List<T> list;
	protected Context context;
	
	
	/**
	 * Default constructor.
	 * 
	 * @param context	the context.
	 * @param list		the list to construct the adapter with.
	 */
	public BaseListAdapter(Context context, List<T> list){
        this.list = list;
        this.context = context;
    }
	
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		return this.list.size();
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int position) {
		return this.list.get(position);
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public abstract long getItemId(int position);
	
	
    public void Remove(int id){
        notifyDataSetChanged();
    }

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public abstract View getView(int position, View convertView, ViewGroup parent); 
	
}
