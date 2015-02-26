package com.infotop.tourismplatform.buy;

    import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.model.Mall;
import com.infotop.tourismplatform.model.SpecialBuy;
import com.infotop.tourismplatform.model.TravelNote;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

	import android.R.string;
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

	public class SpecialBuyListAdapter extends ArrayAdapter<SpecialBuy> {
	    
		private final Activity context;
	    private final SpecialBuy[] specialBuy;
		private final DisplayImageOptions op;
		
		protected ImageLoader loader = ImageLoader.getInstance();
		public SpecialBuyListAdapter(Activity context, SpecialBuy[] specialBuy, DisplayImageOptions op) {
			super(context, R.layout.sp_buy_item,specialBuy);
			// TODO Auto-generated constructor stub
			this.context = context;
			this.specialBuy = specialBuy;
			this.op = op;
			
		}
		
		@Override
		public View getView(int position, View view, ViewGroup parent) {
			View rowView = view;
			final ViewHolder holder;
			if (rowView == null) {
				rowView = context.getLayoutInflater().inflate(
						R.layout.sp_buy_item, parent, false);
				holder = new ViewHolder();
				
				//String text = context.getString(R.string.message);
				//SpannableString ss = new SpannableString(text);
				 //Expose the indent for the first three rows
				//ss.setSpan(new MyLeadingMarginSpan2(7, 210), 0, ss.length(), 0);
				//TextView messageView = (TextView)rowView.findViewById(R.id.message_view);
				//messageView.setText(ss);
				
				holder.buy_heading_view = (TextView) rowView.findViewById(R.id.buy_heading_view);
				holder.buy_message_view = (TextView) rowView.findViewById(R.id.buy_message_view);
			
				holder.sp_buy_image = (ImageView) rowView.findViewById(R.id.sp_buy_image);
				
				rowView.setTag(holder);
			} else {
				holder = (ViewHolder) rowView.getTag();
			}
			
			
			holder.buy_heading_view.setText(specialBuy[position].getHeadName());
			//holder.message.setText(mall[position].getMessage());
			SpannableString ss = new SpannableString(specialBuy[position].getMessage());
			ss.setSpan(new MyLeadingMarginSpan2(7, 210), 0, ss.length(), 0);
			holder.buy_message_view.setText(ss);
			
			loader.displayImage(UrlInfo.ROOT_PATH+specialBuy[position].getImagePath(), holder.sp_buy_image, op, null);
			
			

			return rowView;

		}
		
		
		private class ViewHolder {
			public TextView buy_heading_view;
			public TextView buy_message_view;
			public ImageView sp_buy_image;
			
		}


		class MyLeadingMarginSpan2 implements LeadingMarginSpan2 {
			private int margin;
			private int lines;

			MyLeadingMarginSpan2(int lines, int margin) {
				this.margin = margin;
				this.lines = lines;
			}

			
			/* * Returns the amount by which to adjust the leading margin. Positive
			 * values move away from the leading edge of the paragraph, negative
			 * values move towards it.
			 */
			@Override
			public int getLeadingMargin(boolean first) {
				if (first) {
					
					/* * This indentation is applied to the number of rows returned
					 * getLeadingMarginLineCount ()*/
					 
					return margin;
				} else {
					// Offset for all other Layout layout ) { }
					
					/* * Returns * the number of rows which should be applied * indent
					 * returned by getLeadingMargin (true) Note:* Indent only
					 * applies to N lines of the first paragraph.*/
					 
					return 0;
				}
			}

			@Override
			public void drawLeadingMargin(Canvas c, Paint p, int x, int dir,
					int top, int baseline, int bottom, CharSequence text,
					int start, int end, boolean first, Layout layout) {
			}

			
			/* * Returns the number of lines of text to which this object is attached
			 * that the "first line" margin will apply to. Note that if this returns
			 * N, the first N lines of the region, not the first N lines of each
			 * paragraph, will be given the special margin width.
			 */

			@Override
			public int getLeadingMarginLineCount() {
				return lines;
			}
		};

	


}
