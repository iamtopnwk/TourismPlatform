package com.infotop.tourismplatform.main;

import java.util.ArrayList;











import com.infotop.tourismplatform.R;
import com.infotop.tourismplatform.buy.BuyActivity;
import com.infotop.tourismplatform.food.FoodActivity;
import com.infotop.tourismplatform.introductionnote.IntroductionNoteActivity;
import com.infotop.tourismplatform.localtransfer.LocalTransferActivity;
import com.infotop.tourismplatform.popularplaces.PopularPlacesActivity;
import com.infotop.tourismplatform.traffic.TrafficActivity;
import com.infotop.tourismplatform.traffic.TrafficAdapterActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ModulesListAdapter extends ArrayAdapter<String> {
	
	private final ArrayList<String> name;
	private final ArrayList<String> name1;
	private final int[] imageId;
	private final Activity context;
	int id;
	public ModulesListAdapter(Activity context, ArrayList<String> name,ArrayList<String> name1,int[]imageId) {
		super(context, R.layout.module_list_item,name);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.name = name;
		this.name1 = name1;
		this.imageId = imageId;
	
		
System.out.println("nnnnnnnnnnnn"+name);
System.out.println("nnnnnnnnnnnn"+name1);
	}

	@SuppressLint("ViewHolder")
	@Override
	public View getView(int position, View rowView, ViewGroup parent) {
		
		 rowView = LayoutInflater.from(parent.getContext()).inflate(
					R.layout.module_list_item, null);
		 TextView txtTitle1 = (TextView) rowView.findViewById(R.id.module_list);
		 TextView txtTitle2 = (TextView) rowView.findViewById(R.id.module_list1);
		// ImageView imgView = (ImageView) rowView.findViewById(R.id.iconImg);
        System.out.println("jjjjjjjjjjjjjjjjjjj"+name.get(position));
			txtTitle1.setText(name.get(position));
			txtTitle2.setText(name1.get(position));
			//imgView.setImageResource(imageId[position]);
		
			txtTitle1.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					System.out.println("viiieww"+v);
					Intent intent = null;
					if(((TextView) v).getText().equals("Introduction")){
						intent = new Intent(v.getContext(), IntroductionNoteActivity.class);
					}
					if(((TextView) v).getText().equals("Traffic")){
							intent = new Intent(v.getContext(), TrafficActivity.class);
					}
					if(((TextView) v).getText().equals("Buy")){
						intent = new Intent(v.getContext(), BuyActivity.class);
				    }
					
						
						context.startActivity(intent);
				}
				

			});

		
			txtTitle2.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View v) {

					Intent intent = null;
					
					if(((TextView) v).getText().equals("PopularPlace")){
						intent = new Intent(v.getContext(), PopularPlacesActivity.class);
				       }
					if(((TextView) v).getText().equals("Food")){
						intent = new Intent(v.getContext(), FoodActivity.class);
				       }
					if(((TextView) v).getText().equals("LocalTransport")){
						intent = new Intent(v.getContext(), LocalTransferActivity.class);
				       }
						
						context.startActivity(intent);
				  }
			});


			return rowView;
		// TODO Auto-generated method stub
		
	
	}

}
