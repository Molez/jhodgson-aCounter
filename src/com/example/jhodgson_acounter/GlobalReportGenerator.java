package com.example.jhodgson_acounter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class GlobalReportGenerator extends ReportGenerator {

	public void init() {

		clicks = new ArrayList<Calendar>();
		// Add merge all the counters calendars into this(^) array and sort it.
		ArrayList<CounterModel> counters = this.counterListController.getList();

		for (int i = 0; i < counters.size(); i++) {
			clicks.addAll(counters.get(i).getCountTimes());
		}
		Collections.sort(clicks);
	}
}
