package com.infotop.tourismplatform.traffic;

import java.util.concurrent.ExecutionException;

import com.infotop.tourismplatform.R;

import com.infotop.tourismplatform.main.MainPage;
import com.infotop.tourismplatform.main.RaidersMainActivity;
import com.infotop.tourismplatform.traffic.model.Traffic;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.infotop.tourismplatform.utilities.GetOperation;
import com.infotop.tourismplatform.utilities.JsonHelper;


import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class TrafficActivity extends Activity {
	TrafficAdapterActivity adapter;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traffic);
		
		listView=(ListView)findViewById(R.id.traffic_list);
		String serverUrl=UrlInfo.TAG_INTRODUCTION_NOTE;
		
		AsyncTask<String, Void, String>introData=new GetOperation().execute(serverUrl);
		try{
			Traffic[] trafficData=(Traffic[]) JsonHelper.toObject(introData.get(), Traffic[].class);
	        adapter=new TrafficAdapterActivity(TrafficActivity.this, trafficData);
			listView.setAdapter(adapter);
			
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void trafficBack(View v){
		
           finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.traffic, menu);
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
