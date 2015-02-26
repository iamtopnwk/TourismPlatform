package com.infotop.tourismplatform.main;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.model.TravelNote;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelnoteListAdapter extends ArrayAdapter<TravelNote>{
	
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
			holder.head = (TextView) rowView.findViewById(R.id.placeDesc);
			holder.userName = (TextView) rowView.findViewById(R.id.tnote_userName);
			holder.price = (TextView) rowView.findViewById(R.id.price);
			holder.time = (TextView) rowView.findViewById(R.id.time);
			
		
			holder.placeImage = (ImageView) rowView.findViewById(R.id.placeImg);
			holder.userImage = (ImageView) rowView.findViewById(R.id.usrImg);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		final int id = position;
		//holder.head.setText(tNote[position].getName());
		holder.head.setText(tNote[position].getHeadName());
		holder.userName.setText(tNote[position].getUserName());
		holder.price.setText(tNote[position].getPrice());
		holder.time.setText(tNote[position].getTime());
		
		loader.displayImage(UrlInfo.ROOT_PATH+tNote[position].getImagePath(), holder.placeImage, null, null);
		loader.displayImage(UrlInfo.ROOT_PATH+tNote[position].getUserImage(), holder.userImage, op, null);

		return rowView;

	}
	
	
	private class ViewHolder {
		public TextView head;
		public TextView userName;
		public TextView price;
		public TextView time;
		public ImageView placeImage;
		public ImageView userImage;
		
	}


}
