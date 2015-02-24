package com.infotop.tourismplatform.traffic;

import com.infotop.tourismplatform.R;


import com.infotop.tourismplatform.traffic.model.Traffic;


import android.app.Activity;

import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import android.widget.TextView;

public class TrafficAdapterActivity extends ArrayAdapter<Traffic> {
	
	 
	

	    private final Activity context;
		private final Traffic[] trafficData;
		
		  public TrafficAdapterActivity(Activity context, Traffic[] trafficData){
			super(context,R.layout.activity_traffic_adapter,trafficData);
			this.context=context;
			this.trafficData=trafficData;
		}
		  @Override
			public View getView(int position, View view, ViewGroup parent){
				View rowView=view;
				final ViewHolder holder;
				if (rowView == null) {
					rowView = context.getLayoutInflater().inflate(
							R.layout.activity_traffic_adapter, parent, false);
					holder = new ViewHolder();
					holder.txtTitle = (TextView) rowView.findViewById(R.id.traffic_head);
					holder.txtTitle1 = (TextView) rowView.findViewById(R.id.traffic_message);
					holder.show=(ImageButton)rowView.findViewById(R.id.show);
					holder.hide=(ImageButton)rowView.findViewById(R.id.hide);
					rowView.setTag(holder);
				}else {
					holder = (ViewHolder) rowView.getTag();
				}
				
				holder.txtTitle.setText(trafficData[position].getHeadName());
				holder.txtTitle1.setText(trafficData[position].getMessage());
				
				 holder.show.setOnClickListener(new OnClickListener() {

					   @Override
					   public void onClick(View v) {
					    System.out.println("Show button");
					    holder.show.setVisibility(View.INVISIBLE);
					   holder. hide.setVisibility(View.VISIBLE);
					   holder.txtTitle1.setMaxLines(Integer.MAX_VALUE);
					   

					   }
					  });
				 holder.hide.setOnClickListener(new OnClickListener() {

					   @Override
					   public void onClick(View v) {
					    System.out.println("Hide button");
					    holder.hide.setVisibility(View.INVISIBLE);
					    holder.show.setVisibility(View.VISIBLE);
					    holder.txtTitle1.setMaxLines(5);

					   }
					  });

				 
				return rowView;
				
			}
			private class ViewHolder {
				public TextView txtTitle;
				public TextView txtTitle1;
				public ImageButton show;
				public ImageButton hide;
				
				
				
			}
}