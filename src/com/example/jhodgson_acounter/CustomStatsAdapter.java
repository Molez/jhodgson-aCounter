package com.example.jhodgson_acounter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/*This class defines a custom list adapter for displaying stats
in a list. We display the name on the left and the count on the right.

To-Do: This code essentially identical to the CustomeListAdapter class code. 
We could generalise this class using generics for the ArrayAdapter and get
better code reuse, ss long as counter and stats objects provide the toString()
and getCounteString() method's.
*/
public class CustomStatsAdapter extends ArrayAdapter<StatsModel> {

	public CustomStatsAdapter(Context context, int textViewResourceId) {
		super(context, textViewResourceId);
	}

	private List<StatsModel> items;
	private Context context;
	private int resource;

	public CustomStatsAdapter(Context context, int resource,
			List<StatsModel> items) {

		super(context, resource, items);

		this.items = items;
		this.context = context;
		this.resource = resource;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(resource, parent, false);

		TextView name = (TextView) rowView.findViewById(R.id.list_name);
		TextView count = (TextView) rowView.findViewById(R.id.list_count);

		name.setText(items.get(position).toString());
		count.setText(items.get(position).getCountString());
		return rowView;
	}

}
