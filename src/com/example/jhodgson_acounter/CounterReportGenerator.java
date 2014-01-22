package com.example.jhodgson_acounter;

/*This class extends the basic report generator and simply initializes
the data that the report generator uses. In this case it sets the data
equal to the times of the current editable counter*/

public class CounterReportGenerator extends ReportGenerator {

	@Override
	public void init() {
		clicks = counterListController.getCurrentCounter().getCountTimes();
	}
}
