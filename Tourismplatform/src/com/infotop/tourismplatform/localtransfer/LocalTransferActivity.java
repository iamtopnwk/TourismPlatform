package com.infotop.tourismplatform.localtransfer;

import java.util.concurrent.ExecutionException;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;
import com.infotop.tourismplatform.localtransfer.model.LocalTransfer;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.infotop.tourismplatform.utilities.GetOperation;
import com.infotop.tourismplatform.utilities.JsonHelper;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class LocalTransferActivity extends Activity {
	LocalTransportAdapter adapter;
	ListView listView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_local_transfer);
		
		listView=(ListView)findViewById(R.id.local_transport_list);
		String serverUrl=UrlInfo.TAG_LOCAL_TRANSPORT;
		
		AsyncTask<String, Void, String>localData=new GetOperation().execute(serverUrl);
		
		try {
			
			LocalTransfer[] localTransfersData=(LocalTransfer[]) JsonHelper.toObject(localData.get(), LocalTransfer[].class);
			adapter=new LocalTransportAdapter(LocalTransferActivity.this, localTransfersData);
			listView.setAdapter(adapter);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		} catch (ExecutionException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.local_transfer, menu);
		return true;
	}
	
	public void localTransportBack(View view){
		finish();
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
