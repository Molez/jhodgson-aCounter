package com.example.jhodgson_acounter;

import java.util.ArrayList;

/*This class implements the customeListModel to provide storage
for stats models. Manipulation of this list is done through its
controller.*/

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
