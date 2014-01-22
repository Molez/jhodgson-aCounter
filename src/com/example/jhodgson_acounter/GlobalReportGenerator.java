package com.example.jhodgson_acounter;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

/*This class extends the basic Report Generator and specifies
how a global report should be initialized. A report is created from
a list of dates. Thus we compile all the dates from all the counters
into one big list and sort it. This allows all the reports to be 
generated globally instead of for a specific counter.*/

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
