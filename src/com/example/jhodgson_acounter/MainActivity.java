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
	
	public final static String EXTRA_MESSAGE = "com.example.myfirstapp.STATS_NAME";
	public final static String GLOBAL = "Global Stats";
	private CustomListAdaper adapter;
	private CounterListController listController = new CounterListController();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		//We only ever need to load the data if the program resarts and we lose the cache.
		//Thus we reload when this menu is created as it is always the first activity made.
		//TO-DO: Ensure if this activity is recreated multiple times we only reload once per
		//instance of the program.
		listController.restoreState(getBaseContext());

		final CounterListController listController = new CounterListController();
		
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
					listController.saveState(getBaseContext()); //Save the new counter
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
		
		// Stats button functionality
		Button statsButton = (Button) findViewById(R.id.global_stats);
		statsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(MainActivity.this,
						StatsActivity.class);
				intent.putExtra(EXTRA_MESSAGE,
						GLOBAL);
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
	
	 //save on destroy
	 @Override
     protected void onDestroy() {
		 super.onDestroy();
		 listController.saveState(getBaseContext());
	 }
	 
	 //Save on stop
	 @Override
	 protected void onStop(){
		 super.onStop();
		 listController.saveState(getBaseContext());
	 }
	 
	 //Save on pause
	 @Override
	 protected void onPause()
	 {
	     super.onPause();
	     listController.saveState(getBaseContext());
	 }
	 
	 //Update the counter list on resume
	 @Override
	 protected void onResume(){
		 super.onResume();
		 adapter.notifyDataSetChanged();
	 }
	 
}
