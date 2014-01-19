package com.example.jhodgson_acounter;

import java.util.ArrayList;

public class StatsListModel implements CustomListModel<StatsModel> {

	private ArrayList<StatsModel> list;

	public StatsListModel() {
		super();
		list = new ArrayList<StatsModel>();
	}

	public ArrayList<StatsModel> getList() {
		return list;
	}

	public void setList(ArrayList<StatsModel> list) {
		this.list = list;
	}

}
