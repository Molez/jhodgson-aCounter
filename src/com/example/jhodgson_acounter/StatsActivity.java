package com.example.jhodgson_acounter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class StatsActivity extends Activity {

	private ReportGenerator report;
	private CustomStatsAdapter adapter;
	private StatsListController listController;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);

		report = new GlobalReportGenerator();
		listController = report.generateEmptyReport();

		Intent intent = getIntent();
		TextView textView = (TextView) findViewById(R.id.stats_name);
		textView.setText(intent
				.getStringExtra("com.example.jhodgson_acounter.STATS_NAME"));

		// ----------------------------------------------------------------------------------------------------------------------
		// "Hour" button functionality
		Button hourButton = (Button) findViewById(R.id.hour);
		hourButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listController = report.generateHourlyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Day" button functionality
		Button dayButton = (Button) findViewById(R.id.day);
		dayButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listController = report.generateDailyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Week" button functionality
		Button weekButton = (Button) findViewById(R.id.week);
		weekButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				listController = report.generateWeeklyReport();
				adapter.notifyDataSetChanged();

			}
		});

		// ----------------------------------------------------------------------------------------------------------------------
		// "Month" button functionality
		Button monthButton = (Button) findViewById(R.id.month);
		monthButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
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
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats, menu);
		return true;
	}
}
