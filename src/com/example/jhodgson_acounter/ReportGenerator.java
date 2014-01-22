package com.example.jhodgson_acounter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

/*This class handles generating reports about stats. This class
is abstract so that we can define multiple different groupings 
of data to run stats on. We could run stats on any number
of counters using this class simply by implementing different
variation of the init() function.

To-Do: The code for generateHourlyReport(), generateDailyReport(), etc 
contains very similar code. Essentially only the date format is different. 
Could collapse this code into a single function that takes a 
date format as an argument. Should explore whether this would 
make the code less readable however.
*/

public abstract class ReportGenerator {
	
	//This is the output of report generator. A list of stats objects
	protected StatsListController statsListController;
	//Controller we need to access source data.
	protected CounterListController counterListController;
	//The array we use to generate stats.
	protected ArrayList<Calendar> clicks;

	public ReportGenerator() {
		this.statsListController = new StatsListController();
		this.counterListController = new CounterListController();
	}
	//This function generates the clicks array.
	public abstract void init();

	//Return a empty report
	public StatsListController generateEmptyReport() {
		statsListController.clear();
		return statsListController;
	}

	//Return a list of stats objects representing hourly stats.
	public StatsListController generateHourlyReport() {
		//Clear the stats list in case its full from a different report
		statsListController.clear();
		Calendar cal;
		String oldDate = null;

		for (int i = 0; i < clicks.size(); i++) {
			cal = clicks.get(i);
			//Format our stats string
			SimpleDateFormat date = new SimpleDateFormat(
					"MMM DD, yyyy -- KK':00 'aa", Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			/*Check if our formatted date is the same as the last
			date we formatted. If so increment the current stats 
			object.*/
			if (printDate.equals(oldDate)) {
				statsListController.increment();
			} else {
				//Create a new stats object
				oldDate = printDate;
				statsListController.addStats(printDate);
				statsListController.increment();
			}
		}
		return statsListController;
	}

	public StatsListController generateDailyReport() {
		statsListController.clear();
		Calendar cal;
		String oldDate = null;

		for (int i = 0; i < clicks.size(); i++) {
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM DD, yyyy",
					Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			/*Check if our formatted date is the same as the last
			date we formatted. If so increment the current stats 
			object.*/
			if (printDate.equals(oldDate)) {
				statsListController.increment();
			} else {
				//Create a new stats object
				oldDate = printDate;
				statsListController.addStats(printDate);
				statsListController.increment();
			}
		}
		return statsListController;
	}

	public StatsListController generateWeeklyReport() {
		statsListController.clear();
		Calendar cal;
		String oldDate = null;

		for (int i = 0; i < clicks.size(); i++) {
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM, yyyy 'week' W",
					Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			/*Check if our formatted date is the same as the last
			date we formatted. If so increment the current stats 
			object.*/
			if (printDate.equals(oldDate)) {
				statsListController.increment();
			} else {
				//Create a new stats object
				oldDate = printDate;
				statsListController.addStats(printDate);
				statsListController.increment();
			}
		}
		return statsListController;
	}

	public StatsListController generateMonthlyReport() {
		statsListController.clear();
		Calendar cal;
		String oldDate = null;

		for (int i = 0; i < clicks.size(); i++) {
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM, yyyy",
					Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			/*Check if our formatted date is the same as the last
			date we formatted. If so increment the current stats 
			object.*/
			if (printDate.equals(oldDate)) {
				statsListController.increment();
			} else {
				//Create a new stats object
				oldDate = printDate;
				statsListController.addStats(printDate);
				statsListController.increment();
			}
		}
		return statsListController;
	}
}
