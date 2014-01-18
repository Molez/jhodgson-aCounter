package com.example.jhodgson_acounter;

public abstract class ReportGenerator {

	protected StatsListController statsListController;
	protected CounterListController counterListController;
	
	public ReportGenerator(){
		this.statsListController = new StatsListController();
		this.counterListController = new CounterListController();
	}

	public StatsListController generateEmptyReport(){
		statsListController.clear();
		return statsListController;
	}
	
	public abstract StatsListController generateHourlyReport();
	
	public abstract StatsListController generateDailyReport();
	
	public abstract StatsListController generateWeeklyReport();
	
	public abstract StatsListController generateMonthlyReport();
}
