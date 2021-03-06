package com.infotop.tourismplatform.buy;

import java.util.concurrent.ExecutionException;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.main.TravelNotesMainActivity;
import com.infotop.tourismplatform.main.TravelnoteListAdapter;
import com.infotop.tourismplatform.model.Mall;
import com.infotop.tourismplatform.model.TravelNote;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.infotop.tourismplatform.utilities.GetOperation;
import com.infotop.tourismplatform.utilities.JsonHelper;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

import android.app.Activity;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MallActivity extends Activity {
	MallListAdapter malllistAdapter;
	private ListView mallListView ;
	DisplayImageOptions op;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mall);
		mallListView=(ListView)findViewById(R.id.mall_list);
		int[] colors = {0, 0, 0}; // red for the example
		mallListView.setDivider(new GradientDrawable(Orientation.RIGHT_LEFT, colors));
		mallListView.setDividerHeight(10);
		
		op = new DisplayImageOptions.Builder()
		.showStubImage(R.drawable.notavailable)
		.showImageForEmptyUri(R.drawable.notavailable)
		.showImageOnFail(R.drawable.notavailable).cacheInMemory(true)
		.cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(0))
		.build();
		
		 String serverUrl=UrlInfo.TAG_MALL_MODULE;
		 AsyncTask<String, Void, String>mallData=new GetOperation().execute(serverUrl);
		 try{
			 
			 Mall[] mall=(Mall[]) JsonHelper.toObject(mallData.get(), Mall[].class);
		     malllistAdapter = new MallListAdapter(MallActivity.this,mall,op);
		     mallListView.setAdapter(malllistAdapter);
		 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
