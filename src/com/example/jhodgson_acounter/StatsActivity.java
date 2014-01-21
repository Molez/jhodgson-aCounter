package com.example.jhodgson_acounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class StatsActivity extends Activity {

	private ReportGenerator report;
	private CustomStatsAdapter adapter;
	private StatsListController listController;
	private Button lastButton = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);

		Intent intent = getIntent();
		TextView textView = (TextView) findViewById(R.id.stats_name);
		String statsName = intent
				.getStringExtra(MainActivity.EXTRA_MESSAGE);
		textView.setText(statsName);

		if (statsName.equals(MainActivity.GLOBAL)) {
			report = new GlobalReportGenerator();
			report.init();
			listController = report.generateEmptyReport();
		} else {
			report = new CounterReportGenerator();
			report.init();
			listController = report.generateEmptyReport();
		}

		// ----------------------------------------------------------------------------------------------------------------------
		// "Hour" button functionality
		final Button hourButton = (Button) findViewById(R.id.hour);
		
		hourButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				resetLastButton();
				lastButton = hourButton;
				hourButton.setTextColor(getResources().getColor(R.color.yellow));
				listController = report.generateHourlyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Day" button functionality
		final Button dayButton = (Button) findViewById(R.id.day);
		
		dayButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				resetLastButton();
				lastButton = dayButton;
				dayButton.setTextColor(getResources().getColor(R.color.yellow));
				listController = report.generateDailyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Week" button functionality
		final Button weekButton = (Button) findViewById(R.id.week);

		weekButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				resetLastButton();
				lastButton = weekButton;
				weekButton.setTextColor(getResources().getColor(R.color.yellow));
				listController = report.generateWeeklyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Month" button functionality
		final Button monthButton = (Button) findViewById(R.id.month);
		
		monthButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				//Reset the color of the last button back to white
				resetLastButton();
				lastButton = monthButton;
				monthButton.setTextColor(getResources().getColor(R.color.yellow));
				listController = report.generateMonthlyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// author Java Experience; https://www.youtube.com/watch?v=tNoeFkXCZ6w
		// The list functionality was adapted from Java Experience
		// ----------------------------------------------------------------------------------------------------------------------
		// List functionality

		ListView statsListView = (ListView) findViewById(R.id.stats_list_View);

		// Setting up the counters list
		adapter = new CustomStatsAdapter(getApplicationContext(),
				R.layout.list, listController.getList());
		statsListView.setAdapter(adapter);

		// ----------------------------------------------------------------------------------------------------------------------
		// Back functionality
		Button backButton = (Button) findViewById(R.id.back_stats);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats, menu);
		return true;
	}
	
	//Resets the color of the text of the last button clicked
	private void resetLastButton(){
		if (lastButton != null){
			lastButton.setTextColor(getResources().getColor(R.color.white));
		}
	}
	
	//Stats menu never alters any data that cannot be re-created easily. So we do not bother with onResume() and onPause()
}
