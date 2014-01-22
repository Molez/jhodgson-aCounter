package com.example.jhodgson_acounter;

import java.util.ArrayList;

/*This class implements a controller for a list of stats objects. All
handling of stats objects should be through the controller. There is
an agreement with the report generator, the only current
user of this class, that when it creates a new stats model this model
will be the current editable model. This model can be incremented until
a new one is created. Once that happens it is assumed that the old model 
is done and need not be edited again. If this agreement changes in the 
future we would have to re tool the class a bit.

To-Do: In order to build an array on top of the list we have a public 
method that exposes the underlying array in this class. A better solution
should be looked into.*/

public class StatsListController {

	private StatsListModel statsListModel = null;
	private StatsModel currentStats = null;

	public StatsListController() {
		super();
		this.statsListModel = new StatsListModel();
	}

	//return the underlying array holding stats models
	public ArrayList<StatsModel> getList() {
		return statsListModel.getList();
	}

	//Add a new stats model with the provided name
	public void addStats(String name) {
		currentStats = new StatsModel(name);
		statsListModel.getList().add(currentStats);
	}
	
	//Increment the count in the stats model by 1.
	public void increment() {
		currentStats.increment();
	}
	
	//Clears the list of stats models
	public void clear() {
		statsListModel.getList().clear();
	}

}
