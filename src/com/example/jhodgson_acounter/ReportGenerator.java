package com.example.jhodgson_acounter;

public abstract class ReportGenerator {

	private StatsListController statsListController;
	private CounterListController counterListController;
	
	public ReportGenerator(){
		this.statsListController = new StatsListController();
		this.counterListController = new CounterListController();
	}
	
	public abstract StatsListController generateReport();
}
