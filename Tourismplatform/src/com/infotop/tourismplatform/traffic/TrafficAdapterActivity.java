package com.infotop.tourismplatform.traffic;

import com.infotop.tourismplatform.R;


import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;

import android.widget.TextView;

public class TrafficAdapterActivity extends Activity {
	
	 TextView descText,descText1;
	 ImageButton show, hide,show1,hide1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_traffic_adapter);
		descText = (TextView) findViewById(R.id.traffic_message);
		descText1=(TextView) findViewById(R.id.train_message);
		
		  show = (ImageButton) findViewById(R.id.show);
		  show.setOnClickListener(new OnClickListener() {

		   @Override
		   public void onClick(View v) {
		    System.out.println("Show button");
		    show.setVisibility(View.INVISIBLE);
		    hide.setVisibility(View.VISIBLE);
		    descText.setMaxLines(Integer.MAX_VALUE);

		   }
		  });
		  
		  hide = (ImageButton) findViewById(R.id.hide);
		  hide.setOnClickListener(new OnClickListener() {

		   @Override
		   public void onClick(View v) {
		    System.out.println("Hide button");
		    hide.setVisibility(View.INVISIBLE);
		    show.setVisibility(View.VISIBLE);
		    descText.setMaxLines(5);

		   }
		  });
		  
		  show1 = (ImageButton) findViewById(R.id.show1);
		  show1.setOnClickListener(new OnClickListener() {

		   @Override
		   public void onClick(View v) {
		    System.out.println("Show button");
		    show1.setVisibility(View.INVISIBLE);
		    hide1.setVisibility(View.VISIBLE);
		    descText1.setMaxLines(Integer.MAX_VALUE);

		   }
		  });
		  hide1 = (ImageButton) findViewById(R.id.hide1);
		  hide1.setOnClickListener(new OnClickListener() {

		   @Override
		   public void onClick(View v) {
		    System.out.println("Hide button");
		    hide1.setVisibility(View.INVISIBLE);
		    show1.setVisibility(View.VISIBLE);
		    descText1.setMaxLines(5);

		   }
		  });

		 }

		}