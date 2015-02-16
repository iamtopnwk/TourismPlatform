package com.infotop.tourismplatform.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.infotop.tourismplatform.R;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainPage extends Activity {
	 private ListView mainListView ;
	 ArrayList<String> list = new ArrayList<String>();
	 ArrayList<String> list1 = new ArrayList<String>();
	 private ModulesListAdapter listAdapter ;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_page);
		mainListView = (ListView) findViewById( R.id.mainlist);
		String[] modules = new String[] { "Introduction", "Food", "Buy"}; 
		String[] modules1=new String[] { "Traffic","LocalTransport", "PopularPlace"}; 
		 list.addAll( Arrays.asList(modules) );
		 list1.addAll( Arrays.asList(modules1) );
		 
		 listAdapter = new ModulesListAdapter(MainPage.this, list,list1);
		 System.out.println("llllllllllliiissttt::::"+list);
		 System.out.println("llllllllllliiissttt::::"+list1);
		    
		    
		    mainListView.setAdapter( listAdapter );    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main_page, menu);
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
