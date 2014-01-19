package com.example.jhodgson_acounter;

import java.util.ArrayList;

public class StatsListController {

	private StatsListModel statsListModel = null;
	private StatsModel currentStats = null;

	public StatsListController() {
		super();
		this.statsListModel = new StatsListModel();
	}

	public ArrayList<StatsModel> getList() {
		return statsListModel.getList();
	}

	public void addStats(String name) {
		currentStats = new StatsModel(name);
		statsListModel.getList().add(currentStats);
	}

	public void increment() {
		currentStats.increment();
	}

	public void clear() {
		statsListModel.getList().clear();
	}

}
