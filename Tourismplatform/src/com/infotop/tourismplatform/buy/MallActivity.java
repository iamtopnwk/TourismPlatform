package com.infotop.tourismplatform.buy;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.main.TravelNotesMainActivity;
import com.infotop.tourismplatform.main.TravelnoteListAdapter;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MallActivity extends Activity {
	MallListAdapter malllistAdapter;
	private ListView mallListView ;
	 String[] name = 
            { "Mall1", "Mall2", "Mall3"};
	
	
	 int[] imageId = {
		      R.drawable.mall,
		      R.drawable.mallc,
		      R.drawable.brcelet,
		    };
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mall);
		mallListView=(ListView)findViewById(R.id.mall_list);
		int[] colors = {0, 0, 0}; // red for the example
		mallListView.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		mallListView.setDividerHeight(10);
		malllistAdapter = new MallListAdapter(MallActivity.this,name,imageId);
		mallListView.setAdapter(malllistAdapter);
	}
		
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.mall, menu);
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
