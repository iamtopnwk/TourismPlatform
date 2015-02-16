package com.infotop.tourismplatform.main;

import java.util.ArrayList;




import com.infotop.tourismplatform.R;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ModulesListAdapter extends ArrayAdapter<String> {
	
	private ArrayList<String> name;
	private ArrayList<String> name1;
	private final Activity context;
	public ModulesListAdapter(Activity context, ArrayList<String> name,ArrayList<String> name1) {
		super(context, R.layout.module_list_item,name);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.name = name;
		this.name1 = name1;
		
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
		
        System.out.println("jjjjjjjjjjjjjjjjjjj"+name.get(position));
			txtTitle1.setText(name.get(position));
			txtTitle2.setText(name1.get(position));
			

			return rowView;
		// TODO Auto-generated method stub
		
	
	
	}

}
