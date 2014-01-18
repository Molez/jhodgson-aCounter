package com.example.jhodgson_acounter;

public class GlobalReportGenerator extends ReportGenerator{

	@Override
	public StatsListController generateHourlyReport() {
		
		statsListController.clear();
		
		statsListController.addStats("Feb 1st");
		statsListController.increment();
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
