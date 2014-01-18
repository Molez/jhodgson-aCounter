package com.example.jhodgson_acounter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class GlobalReportGenerator extends ReportGenerator{
	
	private ArrayList<Calendar> clicks;
	
	public void init(){
		
		clicks = new ArrayList<Calendar>();
		//Add merge all the counters calendars into this(^) array and sort it.
		ArrayList<CounterModel> counters = this.counterListController.getList();
		
		for(int i =0; i < counters.size(); i++){
			clicks.addAll(counters.get(i).getCountTimes());
		}
		Collections.sort(clicks);
	}
	
	@Override
	public StatsListController generateHourlyReport() {
		statsListController.clear();
		
		for(int i =0; i < clicks.size(); i++){
			statsListController.addStats(clicks.get(i).getTime().toString());
		}
		
		return statsListController;
	}

	@Override
	public StatsListController generateDailyReport() {
		statsListController.clear();
		
		statsListController.addStats("Jan 1st");
		statsListController.increment();
		return statsListController;
	}

	@Override
	public StatsListController generateWeeklyReport() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StatsListController generateMonthlyReport() {
		// TODO Auto-generated method stub
		return null;
	}

}
