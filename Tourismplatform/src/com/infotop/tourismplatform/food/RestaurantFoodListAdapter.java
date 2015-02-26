package com.infotop.tourismplatform.food;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.model.RestaurantFood;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

	

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan.LeadingMarginSpan2;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

	public class RestaurantFoodListAdapter extends ArrayAdapter<RestaurantFood> {
	    
		private final Activity context;
	    private final RestaurantFood[] restaurantFood;
		private final DisplayImageOptions op;
		
		protected ImageLoader loader = ImageLoader.getInstance();
		public RestaurantFoodListAdapter(Activity context, RestaurantFood[] restaurantFood, DisplayImageOptions op) {
			super(context, R.layout.restro_food_items,restaurantFood);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.restaurantFood = restaurantFood;
			this.op = op;
			
		}
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			View rowView = view;
			final ViewHolder holder;
			if (rowView == null) {
				rowView = context.getLayoutInflater().inflate(
						R.layout.restro_food_items, parent, false);
				holder = new ViewHolder();
				
				//String text = context.getString(R.string.message);
				//SpannableString ss = new SpannableString(text);
				 //Expose the indent for the first three rows
				//ss.setSpan(new MyLeadingMarginSpan2(7, 210), 0, ss.length(), 0);
				//TextView messageView = (TextView)rowView.findViewById(R.id.message_view);
				//messageView.setText(ss);
				
				holder.restro_food_heading_view = (TextView) rowView.findViewById(R.id.restro_food_heading_view);
				holder.restro_food_message_view = (TextView) rowView.findViewById(R.id.restro_food_message_view);
				holder.restro_price = (TextView) rowView.findViewById(R.id.restro_price);
				
			    holder.restro_food_image = (ImageView) rowView.findViewById(R.id.restro_food_image);
				
				rowView.setTag(holder);
			} else {
				holder = (ViewHolder) rowView.getTag();
			}
			
			
			holder.restro_food_heading_view.setText(restaurantFood[position].getHeadName());
			holder.restro_food_message_view.setText(restaurantFood[position].getMessage());
			holder.restro_price.setText(restaurantFood[position].getPrice());
			//holder.message.setText(mall[position].getMessage());
			
			
			loader.displayImage(UrlInfo.ROOT_PATH+restaurantFood[position].getImagePath(), holder.restro_food_image, op, null);
			
			

			return rowView;

		}
		
		
		private class ViewHolder {
			public TextView restro_food_heading_view;
			public TextView restro_food_message_view;
			public TextView restro_price;
			public ImageView restro_food_image;
			
		}
	


}



