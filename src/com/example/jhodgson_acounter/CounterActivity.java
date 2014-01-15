package com.example.jhodgson_acounter;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CounterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.counter);

		final CounterListController listController = new CounterListController();

		// Get the extra intent data
		Intent intent = getIntent();
		int position = intent.getIntExtra("Index", 0);
		listController.setCurrentCounter(position);

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
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Reset functionality
		Button reset = (Button) findViewById(R.id.reset);
		reset.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Clear the current editable counter
				listController.resetCounter();
				TextView count = (TextView) findViewById(R.id.counter_number);
				count.setText(String.valueOf(listController.getCurrentCount()));
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
				Intent intent = new Intent(CounterActivity.this,
						MainActivity.class);
				startActivity(intent);
			}
		});
	}
}
