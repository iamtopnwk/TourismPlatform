package com.infotop.tourismplatform.main;
import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.R.id;
import com.infotop.tourismplatform.R.layout;
import com.infotop.tourismplatform.R.menu;
import com.infotop.tourismplatform.introductionnote.IntroductionNoteActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.ViewFlipper;
import android.widget.TabHost.TabSpec;

public class RaidersMainActivity extends TabActivity {
	 int mFlipping = 0;
	 ImageView iv1, iv2, iv3, iv4, iv5;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tablayout);
		
		iv1 = (ImageView)findViewById(R.id.homeviewflipper1);
		iv2 = (ImageView) findViewById(R.id.homeviewflipper2);
		iv3 = (ImageView) findViewById(R.id.homeviewflipper3);
		iv4 = (ImageView) findViewById(R.id.homeviewflipper4);
		iv5 = (ImageView) findViewById(R.id.homeviewflipper5);

		Bitmap b1 = BitmapFactory.decodeResource(getResources(),
				R.drawable.chinawall);
		Bitmap b2 = BitmapFactory.decodeResource(getResources(),
				R.drawable.china);
		Bitmap b3 = BitmapFactory.decodeResource(getResources(),
				R.drawable.chinaa);
		Bitmap b4 = BitmapFactory.decodeResource(getResources(),
				R.drawable.chinaaa);
		Bitmap b5 = BitmapFactory.decodeResource(getResources(),
				R.drawable.chinaphoto);

		iv1.setImageBitmap(b1);
		iv2.setImageBitmap(b2);
		iv3.setImageBitmap(b3);
		iv4.setImageBitmap(b4);
		iv5.setImageBitmap(b5);
		
		ViewFlipper flipper = (ViewFlipper)findViewById(R.id.flipper1);

		if (mFlipping == 0) {
			/** Start Flipping */
			flipper.startFlipping();
			mFlipping = 1;

		} else {
			/** Stop Flipping */
			flipper.stopFlipping();
			mFlipping = 0;

		}
		System.gc();
		
	//	deviceId = getIntent().getExtras().getString("dId");
		TabHost tabHost = getTabHost();

		// Tab for Songs
		TabSpec tab1 = tabHost.newTabSpec("Main");
		Intent i1 = new Intent(RaidersMainActivity.this, MainPage.class);
		//i1.putExtra("dId", deviceId);
		tab1.setIndicator(getResources().getString(R.string.MainPage));
		tab1.setContent(i1);

		// Tab for Videos
		TabSpec tab2 = tabHost.newTabSpec("TravelNotes");
		Intent i2 = new Intent(RaidersMainActivity.this, TravelNotesMainActivity.class);
		//i2.putExtra("dId", deviceId);
		tab2.setIndicator(getResources().getString(R.string.travelNote));
		tab2.setContent(i2);

		// Adding all TabSpec to TabHost
		
		tabHost.addTab(tab1); // Adding songs tab
		tabHost.addTab(tab2); // Adding videos tab
	
}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.raiders_main, menu);
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

