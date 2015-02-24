package com.infotop.tourismplatform.popularplaces;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class PopularPlacesActivity extends Activity {

	ListView	popularPlaceList;
	PopularPlaceAdapter popularAdapter;
	
	String[] topicHead = {"Underground Grand Canyon", "Bamboo Museum"};
	
	String[] userName = {"Pratik", "Pabitra"};
	
	int[] imageId = {
			R.drawable.trvle,
			R.drawable.trvlee,
	};
	
	String[] desc = {"Underground Grand Canyon at the foot of Longgang Mountain",
			"Yinqueshan Han Tomb and Bamboo Slips Museum (present No.219, Yimeng Lu)"};
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popular_places);
		
		popularPlaceList = (ListView) findViewById(R.id.popularplace_list);
		int[] colors = {0, 0, 0};
		popularPlaceList.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		popularPlaceList.setDividerHeight(10);
		popularAdapter = new PopularPlaceAdapter(PopularPlacesActivity.this, topicHead, userName, imageId, desc);
		popularPlaceList.setAdapter(popularAdapter);
	}
	
	public void popularPlaceBack(View view){
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.popular_places, menu);
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
