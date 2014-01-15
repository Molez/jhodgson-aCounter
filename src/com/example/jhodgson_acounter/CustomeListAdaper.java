package com.example.jhodgson_acounter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CustomeListAdaper extends ArrayAdapter<CounterModel>{
	
	public CustomeListAdaper(Context context, int textViewResourceId) {
	    super(context, textViewResourceId);
	    // TODO Auto-generated constructor stub
	}

	private List<CounterModel> items;
	private Context context;
	private int resource;

	public CustomeListAdaper(Context context, int resource, List<CounterModel> items) {

	    super(context, resource, items);

	    this.items = items;
	    this.context = context;
	    this.resource = resource;
	}
	
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(resource, parent, false);
	    
	    TextView name = (TextView) rowView.findViewById(R.id.list_name);
	    TextView count = (TextView) rowView.findViewById(R.id.list_count);
	    
	    name.setText(items.get(position).toString());
	    count.setText(items.get(position).getCountString());
	    return rowView;
	  }

}
