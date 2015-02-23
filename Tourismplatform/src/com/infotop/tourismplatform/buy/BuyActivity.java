package com.infotop.tourismplatform.buy;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;
import com.infotop.tourismplatform.main.MainPage;
import com.infotop.tourismplatform.main.RaidersMainActivity;
import com.infotop.tourismplatform.main.TravelNotesMainActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class BuyActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_buy);
		TabHost tabHost = getTabHost();

		// Tab for Songs
		TabSpec tab1 = tabHost.newTabSpec("Mall");
		Intent i1 = new Intent(BuyActivity.this, MallActivity.class);
		//i1.putExtra("dId", deviceId);
		tab1.setIndicator(getResources().getString(R.string.mallActivity));
		tab1.setContent(i1);

		// Tab for Videos
		TabSpec tab2 = tabHost.newTabSpec("Special");
		Intent i2 = new Intent(BuyActivity.this, SpecialShopsActivity.class);
		//i2.putExtra("dId", deviceId);
		tab2.setIndicator(getResources().getString(R.string.special_Shops));
		tab2.setContent(i2);

		// Adding all TabSpec to TabHost
		
		tabHost.addTab(tab1); // Adding songs tab
		tabHost.addTab(tab2); // Adding videos tab
	
}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.buy, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
