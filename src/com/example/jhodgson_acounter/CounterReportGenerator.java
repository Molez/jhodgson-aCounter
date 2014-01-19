package com.example.jhodgson_acounter;

public class CounterReportGenerator extends ReportGenerator {

	@Override
	public void init() {
		clicks = counterListController.getCurrentCounter().getCountTimes();
	}
}
