package com.example.jhodgson_acounter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public abstract class ReportGenerator {

	protected StatsListController statsListController;
	protected CounterListController counterListController;
	protected ArrayList<Calendar> clicks;
	
	public ReportGenerator(){
		this.statsListController = new StatsListController();
		this.counterListController = new CounterListController();
	}
	
	public abstract void init();

	public StatsListController generateEmptyReport(){
		statsListController.clear();
		return statsListController;
	}
	
	public StatsListController generateHourlyReport() {
		statsListController.clear();
		Calendar cal; 
		String oldDate = null;
		
		for(int i =0; i < clicks.size(); i++){
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM DD, yyyy -- KK aa", Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			if(printDate.equals(oldDate)){
				statsListController.increment();
			}
			else{
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
		
		for(int i =0; i < clicks.size(); i++){
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM DD, yyyy", Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			if(printDate.equals(oldDate)){
				statsListController.increment();
			}
			else{
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
		
		for(int i =0; i < clicks.size(); i++){
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM, yyyy 'week' W", Locale.CANADA);
			String printDate = date.format(cal.getTime());

			if(printDate.equals(oldDate)){
				statsListController.increment();
			}
			else{
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
		
		for(int i =0; i < clicks.size(); i++){
			cal = clicks.get(i);
			SimpleDateFormat date = new SimpleDateFormat("MMM, yyyy", Locale.CANADA);
			String printDate = date.format(cal.getTime());
			
			if(printDate.equals(oldDate)){
				statsListController.increment();
			}
			else{
				oldDate = printDate;
				statsListController.addStats(printDate);
				statsListController.increment();
			}
		}
		return statsListController;
	}
}
