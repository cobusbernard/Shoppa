/**
 * 
 */
package com.cobusbernard.shoppa.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.globalkinetic.android.activity.R;
import com.globalkinetic.android.constants.Constants;
import com.globalkinetic.android.data.Match;

/**
 * Adapter used to scroll the list of news items.
 * 
 * @author Cobus Bernard
 * @company Global Kinetic
 *
 * @version: $Revision$
 */
public class MatchListAdapter extends BaseListAdapter<Match> {

	/**
	 * Default constructor.
	 * 
	 * @param c		the context.
	 * @param list	the list to construct the adapter with.
	 */
	public MatchListAdapter(Context c, List<Match> list) {
		super(c, list);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LinearLayout rowLayout;
		Match match = this.list.get(position);

		rowLayout = (LinearLayout)LayoutInflater.from(this.context).inflate(R.layout.rowlayout_match, parent, 
			false);
		
		TextView matchNameTextView = (TextView)rowLayout.findViewById(R.id.match_name);
		matchNameTextView.setText(match.getDisplayTitle() + "\n" + match.getTitle());
		
		TextView matchTimeTextView = (TextView)rowLayout.findViewById(R.id.match_time);
		matchTimeTextView.setText(match.getDisplayDate());
		
		ImageView matchChannelImage = (ImageView)rowLayout.findViewById(R.id.match_channel_image);
		if (match.getChannelImage() != null) {
			matchChannelImage.setImageBitmap(match.getChannelImage());
		}
		
		rowLayout.setBackgroundColor(Constants.listColors[position % 2]);
        return rowLayout;
	}

	@Override
	public long getItemId(int position) {
		//FIXME: need to figure out how to handle this.
		return 0;
	}

}
