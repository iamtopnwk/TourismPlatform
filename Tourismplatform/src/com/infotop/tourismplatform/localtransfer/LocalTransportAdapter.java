package com.infotop.tourismplatform.localtransfer;

import com.infotop.tourismplatform.localtransfer.model.LocalTransfer;

import com.infotop.tourismplatform.R;


import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

public class LocalTransportAdapter extends ArrayAdapter<LocalTransfer>{
	Activity context;
	LocalTransfer[] localTransfersData;
	 
	public LocalTransportAdapter(Activity context,LocalTransfer[] localTransfersData){
		super(context, R.layout.local_transport_adapter,localTransfersData);
		this.context=context;
		this.localTransfersData=localTransfersData;
	}

	@Override
	public View getView(int position,View view,ViewGroup parent){
		View rowView=view;
		final ViewHolder holder;
		if(view==null){
			rowView = context.getLayoutInflater().inflate(
					R.layout.local_transport_adapter, parent, false);
			holder = new ViewHolder();
			holder.txtHeadName=(TextView)rowView.findViewById(R.id.local_transport_head);
			holder.txtMessage=(TextView)rowView.findViewById(R.id.local_transport_message);
			holder.show=(ImageButton)rowView.findViewById(R.id.local_transport_show);
			holder.hide=(ImageButton)rowView.findViewById(R.id.local_transport_hide);
			rowView.setTag(holder);
		}else{
			holder=(ViewHolder)rowView.getTag();
		}
		holder.txtHeadName.setText(localTransfersData[position].getHeadName());
		holder.txtMessage.setText(localTransfersData[position].getMessage());
		
		holder.show.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("Show button");
			    holder.show.setVisibility(View.INVISIBLE);
			   holder. hide.setVisibility(View.VISIBLE);
			   holder.txtMessage.setMaxLines(Integer.MAX_VALUE);
				
			}
		});
		
		holder.hide.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				System.out.println("hide button");
				holder.hide.setVisibility(View.INVISIBLE);
				holder.show.setVisibility(View.VISIBLE);
				holder.txtMessage.setMaxLines(3);
				
			}
		});
		return rowView;
	}
	private class ViewHolder {
		public TextView txtHeadName;
		public TextView txtMessage;
		public ImageButton show;
		public ImageButton hide;
		
		
		
	}
}
