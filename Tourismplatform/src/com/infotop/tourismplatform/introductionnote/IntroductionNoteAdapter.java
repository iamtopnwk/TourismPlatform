package com.infotop.tourismplatform.introductionnote;


import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.introductionnote.model.IntroductionNote;



import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class IntroductionNoteAdapter extends ArrayAdapter<IntroductionNote>{
	private final Activity context;
	private final IntroductionNote[] iNotes;
	
	public  IntroductionNoteAdapter(Activity context, IntroductionNote[] iNotes){
		super(context,R.layout.introduction_note_adapter,iNotes);
		this.context=context;
		this.iNotes=iNotes;
	}
	
	@Override
	public View getView(int position, View view, ViewGroup parent){
		View rowView=view;
		final ViewHolder holder;
		if (rowView == null) {
			rowView = context.getLayoutInflater().inflate(
					R.layout.introduction_note_adapter, parent, false);
			holder = new ViewHolder();
			holder.txtTitle = (TextView) rowView.findViewById(R.id.heading);
			holder.txtTitle1 = (TextView) rowView.findViewById(R.id.txt_message);
			rowView.setTag(holder);
		}else {
			holder = (ViewHolder) rowView.getTag();
		}
		
		holder.txtTitle.setText(iNotes[position].getHeadName());
		holder.txtTitle1.setText(iNotes[position].getMessage());
		return rowView;
		
	}
	private class ViewHolder {
		public TextView txtTitle;
		public TextView txtTitle1;
		
		
	}
}
