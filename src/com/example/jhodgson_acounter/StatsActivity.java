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
	private boolean cameFromMain = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stats);
		
		Intent intent = getIntent();
		TextView textView = (TextView) findViewById(R.id.stats_name);
		String statsName = intent
				.getStringExtra("com.example.jhodgson_acounter.STATS_NAME");
		textView.setText(statsName);
		
		if(statsName.equals("Global Stats")){
			report = new GlobalReportGenerator();
			report.init();
			listController = report.generateEmptyReport();
			cameFromMain = true;
		}
		else
		{
			report = new CounterReportGenerator();
			report.init();
			listController = report.generateEmptyReport();
			cameFromMain = false;
		}

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
		
		// ----------------------------------------------------------------------------------------------------------------------
		// Back functionality
		Button backButton = (Button) findViewById(R.id.back_stats);
		backButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				
				if(cameFromMain){
				Intent intent = new Intent(StatsActivity.this,
						MainActivity.class);
				startActivity(intent);
				}
				else{
					Intent intent = new Intent(StatsActivity.this,
							CounterActivity.class);
					startActivity(intent);
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stats, menu);
		return true;
	}
}
