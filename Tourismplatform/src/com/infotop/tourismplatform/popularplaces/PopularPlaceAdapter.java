package com.infotop.tourismplatform.popularplaces;

import com.infotop.tourismplatform.R;

import android.app.Activity;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class PopularPlaceAdapter extends ArrayAdapter<String>{
	
	private final String[] topicHead;
	private final String[] userName;
	private final int[] imageId;
	private final String[] desc;
	private final Activity context;

	public PopularPlaceAdapter(Activity context, String[]topicHead, String[] userName, int[] imageId, String[] desc) {
		super(context, R.layout.popular_place_adapter, desc);
		this.context = context;
		this.userName = userName;
		this.topicHead = topicHead;
		this.desc = desc;
		this.imageId = imageId;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		View rowView = view;
		final ViewHolder holder;
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(
					R.layout.popular_place_adapter, parent, false);
		holder = new ViewHolder();
		holder.txtTitle = (TextView) rowView.findViewById(R.id.list_header);
		holder.txtTitle1 = (TextView) rowView.findViewById(R.id.userName);
		holder.txtTitle2 = (TextView) rowView.findViewById(R.id.popPlace);
		holder.imageView = (ImageView) rowView.findViewById(R.id.list_popularplace_image);
			
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		final int id = position;
		holder.txtTitle.setText(topicHead[position]);
		holder.txtTitle1.setText(userName[position]);
		holder.txtTitle2.setText(desc[position]);
		holder.imageView.setImageResource(imageId[position]);
	

		return rowView;

	}
	
	private class ViewHolder {
		public TextView txtTitle;
		public TextView txtTitle1;
		public TextView txtTitle2;
		public ImageView imageView;
		
	}
		
}
