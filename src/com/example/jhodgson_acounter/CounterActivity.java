package com.example.jhodgson_acounter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
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
				AlertDialog.Builder builder = new AlertDialog.Builder(
						CounterActivity.this);
				builder.setMessage("Are you sure?")
						.setPositiveButton(R.string.ok,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										listController.resetCounter();
										TextView count = (TextView) findViewById(R.id.counter_number);
										count.setText(String
												.valueOf(listController
														.getCurrentCount()));

									}
								})
						.setNegativeButton(R.string.cancel,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// User cancelled the dialog
									}
								});
				// Create the AlertDialog object and return it
				builder.create();
				builder.show();
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Delete functionality
		Button delete = (Button) findViewById(R.id.delete);
		delete.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder builder = new AlertDialog.Builder(
						CounterActivity.this);
				builder.setMessage("Are you sure?")
						.setPositiveButton(R.string.ok,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										listController.deleteCurrentCounter();
										Intent intent = new Intent(
												CounterActivity.this,
												MainActivity.class);
										startActivity(intent);

									}
								})
						.setNegativeButton(R.string.cancel,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// User cancelled the dialog
									}
								});
				// Create the AlertDialog object and show it
				builder.create();
				builder.show();
			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// Rename functionality
		Button rename = (Button) findViewById(R.id.rename);
		rename.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				AlertDialog.Builder builder = new AlertDialog.Builder(
						CounterActivity.this);
				LayoutInflater inflater = CounterActivity.this.getLayoutInflater();
				final View v = inflater.inflate(R.layout.rename, null);
				builder.setView(v);
				builder.setPositiveButton(R.string.ok,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										EditText renameName = (EditText) v.findViewById(R.id.rename_name);
										String name = renameName.getText().toString();
										if(name != null){
											listController.renameCurrentCounter(name);
											TextView counterName = (TextView) findViewById(R.id.counter_name);
											counterName.setText(listController.getCurrentName());
										}

									}
								})
						.setNegativeButton(R.string.cancel,
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// User cancelled the dialog
									}
								});
				// Create the AlertDialog object and show it
				builder.create();
				builder.show();
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
