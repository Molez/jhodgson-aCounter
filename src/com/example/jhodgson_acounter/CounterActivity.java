package com.example.jhodgson_acounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/*This class holds the code for the Counter Activity. All Button functionality and activity states reside here*/

public class CounterActivity extends Activity {

	CounterListController listController = new CounterListController();
	
	//Create the activity
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);

		// Set the counters name text
		TextView counterName = (TextView) findViewById(R.id.counter_name);
		counterName.setText(listController.getCurrentName());
		// Set the count number
		TextView counterCount = (TextView) findViewById(R.id.counter_number);
		counterCount.setText(String.valueOf(listController.getCurrentCount()));

		// ----------------------------------------------------------------------------------------------------------------------
		// Increment(+) button functionality
		Button increment = (Button) findViewById(R.id.increment);
		increment.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listController.incrementCounter();
				TextView count = (TextView) findViewById(R.id.counter_number);
				count.setText(String.valueOf(listController.getCurrentCount()));
				listController.saveState(getBaseContext()); // Save
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Reset button functionality
		Button reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Bundle the layout and button names for the fragment
				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.verify);
				// Create and launch the fragment
				ResetDialogFragment rdf = new ResetDialogFragment();
				rdf.setArguments(bundle);
				rdf.show(getFragmentManager(), "Reset");
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Delete button functionality
		Button delete = (Button) findViewById(R.id.delete);
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Bundle the layout and button names for the fragment
				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.verify);
				// Create and launch the fragment
				DeleteDialogFragment ddf = new DeleteDialogFragment();
				ddf.setArguments(bundle);
				ddf.show(getFragmentManager(), "Delete");
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Rename button functionality
		Button rename = (Button) findViewById(R.id.rename);
		rename.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Bundle the layout and button names for the fragment
				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.rename);
				// Create and launch the fragment
				RenameDialogFragment rdf = new RenameDialogFragment();
				rdf.setArguments(bundle);
				rdf.show(getFragmentManager(), "Rename");
			}
		});
		// ----------------------------------------------------------------------------------------------------------------------

		// Back button functionality
		Button backButton = (Button) findViewById(R.id.back_main);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Clear the current editable counter
				listController.clearCurrentCounter();
				finish(); // Close the activity
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Stats button functionality
		Button statsButton = (Button) findViewById(R.id.individual_stats);
		statsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Intent to move to the stats activity
				Intent intent = new Intent(CounterActivity.this,
						StatsActivity.class);
				// Pass the name of the counter to the stats activity
				intent.putExtra(MainActivity.EXTRA_MESSAGE,
						listController.getCurrentName() + " Stats");
				startActivity(intent);
			}
		});
	}

	// Save on destroying this activity
	@Override
	protected void onDestroy() {
		super.onDestroy();
		listController.saveState(getBaseContext());
	}

	// Save when we stop this activity
	@Override
	protected void onStop() {
		super.onStop();
		listController.saveState(getBaseContext());
	}

	// Save when we pause this activity
	@Override
	protected void onPause() {
		super.onPause();
		listController.saveState(getBaseContext());
	}
}
