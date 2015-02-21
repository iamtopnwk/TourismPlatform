package com.infotop.tourismplatform.main;

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
import android.widget.ListView;

public class TravelNotesMainActivity extends Activity {
	TravelnoteListAdapter travelnotelistAdapter;
	private ListView travelnotesListView ;
	 String[] desc = 
             { "good place", "very good place", "i like that place"};
	
	 String[] name = 
             { "selva", "rakesh", "sureshbabu"};
	
	 int[] imageId = {
		      R.drawable.trvle,
		      R.drawable.trvlee,
		      R.drawable.trvleee,
		    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_travel_notes_main);
		travelnotesListView=(ListView)findViewById(R.id.travel_note_list);
		int[] colors = {0, 0, 0}; // red for the example
		travelnotesListView.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		travelnotesListView.setDividerHeight(10);
		travelnotelistAdapter = new TravelnoteListAdapter(TravelNotesMainActivity.this, desc,name,imageId);
		travelnotesListView.setAdapter(travelnotelistAdapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.travel_notes_main, menu);
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
