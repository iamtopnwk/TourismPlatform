package com.infotop.tourismplatform.popularplaces;

import java.util.concurrent.ExecutionException;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;
import com.infotop.tourismplatform.buy.MallActivity;
import com.infotop.tourismplatform.buy.MallListAdapter;
import com.infotop.tourismplatform.model.Mall;
import com.infotop.tourismplatform.model.PopularPlace;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.infotop.tourismplatform.utilities.GetOperation;
import com.infotop.tourismplatform.utilities.JsonHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class PopularPlacesActivity extends Activity {

	ListView	popularPlaceList;
	PopularPlaceAdapter popularAdapter;
	DisplayImageOptions op;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_popular_places);
		popularPlaceList.setDividerHeight(10);
		
		op = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.notavailable)
		.showImageForEmptyUri(R.drawable.notavailable)
		.showImageOnFail(R.drawable.notavailable).cacheInMemory(true)
		.cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(0))
		.build();

		String serverUrl=UrlInfo.TAG_POPULAR_PLACE;
		AsyncTask<String, Void, String>popPlaceData=new GetOperation().execute(serverUrl);
		 try{
			 
			 PopularPlace[] popPlace=(PopularPlace[]) JsonHelper.toObject(popPlaceData.get(), PopularPlace.class);
			 System.out.println("======================"+popPlace);
			 popularAdapter = new PopularPlaceAdapter(PopularPlacesActivity.this,popPlace,op);
		     popularPlaceList.setAdapter(popularAdapter);
		 } catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		
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
