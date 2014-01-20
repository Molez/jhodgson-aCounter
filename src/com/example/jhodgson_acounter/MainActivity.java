package com.example.jhodgson_acounter;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;

public class MainActivity extends Activity {

	private CustomListAdaper adapter;
	private CounterListController listController = new CounterListController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		listController.restoreState(getBaseContext());

		final CounterListController listController = new CounterListController();
		
		//Load the 

		// ----------------------------------------------------------------------------------------------------------------------
		// "New" button functionality
		Button newButton = (Button) findViewById(R.id.new_counter);
		newButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				EditText counterName = (EditText) findViewById(R.id.counter_Name);
				String name = counterName.getText().toString();

				// Make sure name is not empty
				if (!name.isEmpty() && name != null) {
					listController.addCounter(name);
					counterName.setText(""); // Clear the text after use
					adapter.notifyDataSetChanged();
					listController.saveState(getBaseContext());
				}
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Spinner functionality (Sort Options)

		Spinner spinner = (Spinner) findViewById(R.id.sort_spinner);
		ArrayAdapter<CharSequence> sortAdapter = ArrayAdapter
				.createFromResource(this, R.array.sort_array,
						android.R.layout.simple_spinner_item);

		sortAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(sortAdapter);

		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parentView,
					View selectedItemView, int position, long id) {

				if (position == 0)
					listController.sortCounters();
				else
					listController.sortCountersReverse();

				adapter.notifyDataSetChanged();
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				// TODO Auto-generated method stub
				
			}

		});

		// ----------------------------------------------------------------------------------------------------------------------
		// author Java Experience; https://www.youtube.com/watch?v=tNoeFkXCZ6w
		// The list functionality was adapted from Java Experience
		// ----------------------------------------------------------------------------------------------------------------------
		// List functionality

		ListView countersListView = (ListView) findViewById(R.id.listView1);

		// Setting up the counters list
		adapter = new CustomListAdaper(getApplicationContext(), R.layout.list,
				listController.getList());
		countersListView.setAdapter(adapter);

		countersListView.setOnItemClickListener(new OnItemClickListener() {
			
			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {

				listController.setCurrentCounter(position);

				Intent intent = new Intent(MainActivity.this,
						CounterActivity.class);
				startActivity(intent);
			}
		});
		// --------------------------guide--------------------------------------------------------------------------------------------
		// Stats button functionality
		Button statsButton = (Button) findViewById(R.id.stats);
		statsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						StatsActivity.class);
				intent.putExtra("com.example.jhodgson_acounter.STATS_NAME",
						"Global Stats");
				startActivity(intent);
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	 @Override
     protected void onDestroy() {
		 super.onDestroy();
		 listController.saveState(getBaseContext());
	 }
	 
	 protected void onStop(){
		 super.onStop();
		 listController.saveState(getBaseContext());
	 }
	 
	 @Override
	 protected void onPause()
	 {
	     super.onPause();
	     listController.saveState(getBaseContext());
	 }

	 protected void onResume(){
		 super.onResume();
		 adapter.notifyDataSetChanged();
	 }
	 
}
