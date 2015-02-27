package com.infotop.tourismplatform.popularplaces;

import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.model.PopularPlace;
import com.infotop.tourismplatform.urls.UrlInfo;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

import android.app.Activity;
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


public class PopularPlaceAdapter extends ArrayAdapter<PopularPlace>{
	
	
	private PopularPlace[] popPlace;
	private final DisplayImageOptions op;
	private final Activity context;
	
	protected ImageLoader loader = ImageLoader.getInstance();
	public PopularPlaceAdapter(Activity context, PopularPlace[] popPlace, DisplayImageOptions op) {
		super(context, R.layout.popular_place_adapter, popPlace);
		this.context = context;
		this.popPlace =popPlace;
		this.op = op;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent) {
		View rowView = view;
		final ViewHolder holder;
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(
					R.layout.popular_place_adapter, parent, false);
		holder = new ViewHolder();		
		holder.topicHead = (TextView) rowView.findViewById(R.id.list_header);
		holder.userName = (TextView) rowView.findViewById(R.id.userName);
		
		holder.desc = (TextView) rowView.findViewById(R.id.popPlace);
		
		holder.userImage = (ImageView) rowView.findViewById(R.id.user_image);
		holder.popImage = (ImageView) rowView.findViewById(R.id.list_popularplace_image);
		rowView.setTag(holder);
		} else {
			holder = (ViewHolder) rowView.getTag();
		}
		
		holder.topicHead.setText(popPlace[position].getHeadName());
		holder.userName.setText(popPlace[position].getUserName());
		SpannableString ss = new SpannableString(popPlace[position].getMessage());
		ss.setSpan(new MyLeadingMarginSpan2(5, 210), 0, ss.length(), 0);
		holder.desc.setText(ss);
		loader.displayImage(UrlInfo.ROOT_PATH+popPlace[position].getImagePath(), holder.popImage, null, null);
		loader.displayImage(UrlInfo.ROOT_PATH+popPlace[position].getUserImage(), holder.userImage, op, null);
		

		return rowView;

	}
	
	private class ViewHolder {
		public TextView topicHead;
		public TextView userName;
		public ImageView userImage;
		public TextView desc;
		public ImageView popImage;
		
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
