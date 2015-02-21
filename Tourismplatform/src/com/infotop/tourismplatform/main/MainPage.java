package com.infotop.tourismplatform.main;

import java.util.ArrayList;
import java.util.Arrays;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.buy.BuyActivity;
import com.infotop.tourismplatform.introductionnote.IntroductionNoteActivity;
import com.infotop.tourismplatform.traffic.TrafficActivity;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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
		String[] modules = new String[] { "Introduction","Traffic","Buy"}; 
		String[] modules1=new String[] { "PopularPlace","Food","LocalTransport"}; 

		int[] imageId={ R.drawable.transport,
			            R.drawable.food,
			            R.drawable.buy,}; 
		 list.addAll( Arrays.asList(modules) );
		 list1.addAll( Arrays.asList(modules1) );
		 
		 listAdapter = new ModulesListAdapter(MainPage.this, list,list1,imageId);
		 System.out.println("llllllllllliiissttt::::"+list);
		 System.out.println("llllllllllliiissttt::::"+list1);
		    
		    
		    mainListView.setAdapter( listAdapter );    
		    
		   /* mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					//System.out.println("POSITION======"+position);
					//System.out.println("VIEW======"+id);
					Intent intent = null;
					 switch(position) {
					 case 1: 
						  
				            intent = new Intent(getApplicationContext(), IntroductionNoteActivity.class);
				            startActivity(intent);
						   
				     break;
				      
					 case 2:
						 for(int i=0;i<1;i++){
				            intent = new Intent(getApplicationContext(), TrafficActivity.class);
				            startActivity(intent);
				            System.out.println("iii"+i);
				            }
						
						 intent = new Intent(getApplicationContext(), IntroductionNoteActivity.class);
				            startActivity(intent);
				     break;
				     
					 case 3:
				            intent = new Intent(getApplicationContext(), BuyActivity.class);
				            startActivity(intent);
				     break;
					 default:
				      
					 }
					
				}
			});
		    */
		    
		    
		    
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
