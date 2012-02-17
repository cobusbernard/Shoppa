package com.cobusbernard.shoppa;

import java.util.List;

import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import com.cobusbernard.shoppa.adapter.ShoppingItemListAdapter;
import com.cobusbernard.shoppa.data.ShoppingItem;
import com.cobusbernard.shoppa.services.ShoppaService;

public class ShoppaActivity extends TabActivity {
	
	private TabHost tabHost;
	private ListView tab1ListView;
	private ListView tab2ListView;
	private ListView tab3ListView;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        init();
        setupTabs();
        initAdapters();
    }
    
    /**l
     * Initialises all the required components.
     */
    private void init() {
    	this.tabHost = getTabHost();
    	this.tab1ListView = (ListView) findViewById(R.id.tab1ListView);
    	this.tab2ListView = (ListView) findViewById(R.id.tab2ListView);
    	this.tab3ListView = (ListView) findViewById(R.id.tab3ListView);
    }
    
    /**
     * Initialises all the adapters used by GUI objects.
     */
    private void initAdapters() {
    	List<ShoppingItem> list = (new ShoppaService()).getShoppingList();
    	
    	this.tab1ListView.setAdapter(new ShoppingItemListAdapter(this.tab1ListView.getContext(), 
			list));
    	this.tab2ListView.setAdapter(new ShoppingItemListAdapter(this.tab2ListView.getContext(), 
    			list));
    	this.tab3ListView.setAdapter(new ShoppingItemListAdapter(this.tab3ListView.getContext(), 
    			list));
    }
    
    /**
     * Sets up the tabs in the initial state.
     */
    private void setupTabs() {
        this.tabHost.addTab(this.tabHost.newTabSpec("tab_1")
    		//.setIndicator(buildTabView(this, getString(R.string.tab1_heading)))
    		.setIndicator(getString(R.string.tab1_heading))
			.setContent(R.id.tab1_content));
        
        this.tabHost.addTab(this.tabHost.newTabSpec("tab_2")
    		//.setIndicator(buildTabView(this, getString(R.string.tab2_heading)))
    		.setIndicator(getString(R.string.tab2_heading))
    		.setContent(R.id.tab2_content));
        
        this.tabHost.addTab(this.tabHost.newTabSpec("tab_3")
    		//.setIndicator(buildTabView(this, getString(R.string.tab3_heading)))
    		.setIndicator(getString(R.string.tab3_heading))
    		.setContent(R.id.tab3_content));
        
        this.tabHost.setCurrentTab(0);
    }
    
    public static LinearLayout buildTabView(Context context, String label){

        LayoutInflater li = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        final LinearLayout ll = (LinearLayout)li.inflate(R.layout.tablayout_title, null);

// the following lines will change the tabs size depending on the label (text) length.
// the longer tab text - the widther tabs
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, label.length() + 1);
        ll.setLayoutParams(layoutParams);
// .        
        final TextView tv = (TextView)ll.findViewById(R.id.tab_tv);

        tv.setOnTouchListener(new OnTouchListener() {

            public boolean onTouch(View v, MotionEvent event) {
                ll.onTouchEvent(event);
                return false;
            }
        });

        tv.setText(label);

        return ll;
    }
}