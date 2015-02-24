package com.infotop.tourismplatform.main;

import model.TravelNote;

import com.infotop.tourismplatform.R;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelnoteListAdapter extends ArrayAdapter<TravelNote>{
	/*private final String[] desc;
	private final String[] name;
	private final int[] imageId;*/
	private final TravelNote[] tNote;
	private final Activity context;
	private final DisplayImageOptions op;
	
	protected ImageLoader loader = ImageLoader.getInstance();
	public TravelnoteListAdapter(Activity context, TravelNote[] tNote,DisplayImageOptions op ) {
		super(context, R.layout.travel_list_items,tNote);
		this.context = context;
		this.tNote = tNote;
		this.op = op;
		
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		View rowView = view;
		final ViewHolder holder;
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(
					R.layout.travel_list_items, parent, false);
			holder = new ViewHolder();
			holder.head = (TextView) rowView.findViewById(R.id.placeName);
			holder.message = (TextView) rowView.findViewById(R.id.placeDesc);
			holder.time = (TextView) rowView.findViewById(R.id.time);
			
		
			holder.placeImage = (ImageView) rowView.findViewById(R.id.placeImg);
			holder.userImage = (ImageView) rowView.findViewById(R.id.usrImg);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		final int id = position;
		holder.head.setText(tNote[position].getName());
		holder.message.setText(tNote[position].getHeadName());
		holder.time.setText(tNote[position].getTime());
		//holder.placeImage.setImageURI(tNote[position].getImagePath());
		//holder.userImage.setImageResource(imageId[position]);
		loader.displayImage(tNote[position].getImagePath(), holder.placeImage, op, null);
		loader.displayImage(tNote[position].getUserImage(), holder.userImage, op, null);

		return rowView;

	}
	
	
	private class ViewHolder {
		public TextView head;
		public TextView message;
		public TextView time;
		public ImageView placeImage;
		public ImageView userImage;
		
	}


}
