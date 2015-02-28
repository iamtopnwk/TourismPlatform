package com.infotop.tourismplatform.food;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;
import com.infotop.tourismplatform.buy.BuyActivity;
import com.infotop.tourismplatform.buy.MallActivity;
import com.infotop.tourismplatform.buy.SpecialBuyActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class FoodActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_food);
		TabHost tabHost = getTabHost();

		// Tab for SpecialFood
		TabSpec tab1 = tabHost.newTabSpec("SpFood");
		Intent i1 = new Intent(FoodActivity.this, SpecialFoodActivity.class);
		tab1.setIndicator(getResources().getString(R.string.special_foods));
		tab1.setContent(i1);

		// Tab for RestaurantFood
		TabSpec tab2 = tabHost.newTabSpec("Restro");
		Intent i2 = new Intent(FoodActivity.this, RestaurantFoodActivity.class);
		tab2.setIndicator(getResources().getString(R.string.restro_food));
		tab2.setContent(i2);

		// Adding all TabSpec to TabHost
		
		tabHost.addTab(tab1); // Adding songs tab
		tabHost.addTab(tab2); // Adding videos tab
	
}
	
	public void foodActivityBack(View view){
		finish();
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.food, menu);
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
