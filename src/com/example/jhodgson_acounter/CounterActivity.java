package com.example.jhodgson_acounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_counter);

		final CounterListController listController = new CounterListController();

		// Set the name text
		TextView counterName = (TextView) findViewById(R.id.counter_name);
		counterName.setText(listController.getCurrentName());

		TextView counterCount = (TextView) findViewById(R.id.counter_number);
		counterCount.setText(String.valueOf(listController.getCurrentCount()));

		// ----------------------------------------------------------------------------------------------------------------------
		// Increment functionality
		Button increment = (Button) findViewById(R.id.increment);
		increment.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listController.incrementCounter();
				TextView count = (TextView) findViewById(R.id.counter_number);
				count.setText(String.valueOf(listController.getCurrentCount()));
				listController.saveState(getBaseContext());
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Reset functionality
		Button reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.verify);

				ResetDialogFragment rdf = new ResetDialogFragment();
				rdf.setArguments(bundle);
				rdf.show(getFragmentManager(), "Reset");
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Delete functionality
		Button delete = (Button) findViewById(R.id.delete);
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.verify);

				DeleteDialogFragment ddf = new DeleteDialogFragment();
				ddf.setArguments(bundle);
				ddf.show(getFragmentManager(), "Delete");
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Rename functionality
		Button rename = (Button) findViewById(R.id.rename);
		rename.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Bundle bundle = new Bundle();
				bundle.putInt("button1", R.string.cancel);
				bundle.putInt("button2", R.string.ok);
				bundle.putInt("layout", R.layout.rename);

				RenameDialogFragment rdf = new RenameDialogFragment();
				rdf.setArguments(bundle);
				rdf.show(getFragmentManager(), "Rename");
			}
		});
		// ----------------------------------------------------------------------------------------------------------------------

		// Back functionality
		Button backButton = (Button) findViewById(R.id.back_main);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Clear the current editable counter
				listController.clearCurrentCounter();
				finish();
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Stats button functionality
		Button statsButton = (Button) findViewById(R.id.individual_stats);
		statsButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(CounterActivity.this,
						StatsActivity.class);
				intent.putExtra("com.example.jhodgson_acounter.STATS_NAME",
						listController.getCurrentName() + " Stats");
				startActivity(intent);
			}
		});
	}
}
