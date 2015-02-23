package com.infotop.tourismplatform.main;

import com.infotop.tourismplatform.R;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TravelnoteListAdapter extends ArrayAdapter<String>{
	private final String[] desc;
	private final String[] name;
	private final int[] imageId;
	private final Activity context;
	public TravelnoteListAdapter(Activity context, String[] desc,
			String[] name, int[] imageId) {
		super(context, R.layout.travel_list_items,desc);
		this.context = context;
		this.desc = desc;
		this.name = name;
		this.imageId = imageId;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		View rowView = view;
		final ViewHolder holder;
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(
					R.layout.travel_list_items, parent, false);
			holder = new ViewHolder();
			holder.txtTitle = (TextView) rowView.findViewById(R.id.placeDesc);
			holder.txtTitle1 = (TextView) rowView.findViewById(R.id.placeName);
		
			holder.imageView = (ImageView) rowView.findViewById(R.id.placeImg);
			rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		final int id = position;
		holder.txtTitle.setText(desc[position]);
		holder.txtTitle1.setText(name[position]);
		holder.imageView.setImageResource(imageId[position]);
	

		return rowView;

	}
	
	
	private class ViewHolder {
		public TextView txtTitle;
		public TextView txtTitle1;
		public ImageView imageView;
		
	}


}
